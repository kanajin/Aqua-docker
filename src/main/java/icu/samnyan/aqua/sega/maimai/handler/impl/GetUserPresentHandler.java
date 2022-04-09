package icu.samnyan.aqua.sega.maimai.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("MaimaiGetUserPresentHandler")
public class GetUserPresentHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserPresentHandler.class);

    private final BasicMapper mapper;

    public GetUserPresentHandler(BasicMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Empty
     */
    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", 0);
        resultMap.put("userPresentList", List.of());

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
