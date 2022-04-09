package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
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
@Component("OngekiGetGameMessageHHandler")
public class GetGameMessageHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetGameMessageHandler.class);

    private final BasicMapper mapper;

    @Autowired
    public GetGameMessageHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Integer type = (Integer) request.get("type");

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("type", type);
        resultMap.put("length", 0);
        resultMap.put("gameMessageList", new List[]{});

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
