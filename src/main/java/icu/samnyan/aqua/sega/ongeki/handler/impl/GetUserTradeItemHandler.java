package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;

import icu.samnyan.aqua.sega.ongeki.dao.userdata.UserTradeItemRepository;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserTradeItem;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("OngekiGetUserTradeItemHandler")
public class GetUserTradeItemHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserTradeItemHandler.class);

    private final BasicMapper mapper;

    private final UserTradeItemRepository userTradeItemRepository;

    @Autowired
    public GetUserTradeItemHandler(BasicMapper mapper, UserTradeItemRepository userTradeItemRepository) {
        this.mapper = mapper;
        this.userTradeItemRepository = userTradeItemRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();
        int startChapterId = ((Number) request.get("startChapterId")).intValue();
        int endChapterId = ((Number) request.get("endChapterId")).intValue();

        List<UserTradeItem> tradeItemList = userTradeItemRepository.findByUser_Card_ExtIdAndChapterIdGreaterThanEqualAndChapterIdLessThanEqual(userId, startChapterId, endChapterId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", tradeItemList.size());
        resultMap.put("userTradeItemList", tradeItemList);

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
