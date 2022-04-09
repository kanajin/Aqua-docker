package icu.samnyan.aqua.sega.aimedb.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.aimedb.handler.BaseHandler;
import icu.samnyan.aqua.sega.aimedb.util.AimeDbUtil;
import icu.samnyan.aqua.sega.aimedb.util.LogMapper;
import icu.samnyan.aqua.sega.general.model.Card;
import icu.samnyan.aqua.sega.general.service.CardService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component
public class RegisterHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(RegisterHandler.class);

    private final LogMapper logMapper;

    private final CardService cardService;

    @Autowired
    public RegisterHandler(LogMapper logMapper, CardService cardService) {
        this.logMapper = logMapper;
        this.cardService = cardService;
    }

    @Override
    public void handle(ChannelHandlerContext ctx, ByteBuf msg) throws JsonProcessingException {
        Map<String, Object> requestMap = AimeDbUtil.getBaseInfo(msg);
        requestMap.put("type", "register");
        requestMap.put("luid", ByteBufUtil.hexDump(msg.slice(0x0020, 0x002a - 0x0020)));

        logger.info("Request: " + logMapper.write(requestMap));

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", "register");

        if (cardService.getCardByAccessCode((String) requestMap.get("luid")).isEmpty()) {
            Card card = cardService.registerByAccessCode((String) requestMap.get("luid"));

            resultMap.put("status", 1);
            resultMap.put("aimeId", card.getExtId().longValue());
        } else {
            logger.warn("Duplicated Aime Card Register detected, access code: {}", requestMap.get("luid"));
            resultMap.put("status", 0);
            resultMap.put("aimeId", 0L);
        }

        logger.info("Response: " + logMapper.write(resultMap));

        ByteBuf respSrc = Unpooled.copiedBuffer(new byte[0x0030]);
        respSrc.setShortLE(0x0004, 0x0006);
        respSrc.setShortLE(0x0008, (int) resultMap.get("status"));
        respSrc.setLongLE(0x0020, (long) resultMap.get("aimeId"));

        ctx.writeAndFlush(respSrc);

    }
}
