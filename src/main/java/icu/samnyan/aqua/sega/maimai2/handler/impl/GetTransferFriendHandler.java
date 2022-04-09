package icu.samnyan.aqua.sega.maimai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.maimai2.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Maimai2GetTransferFriendHandler")
public class GetTransferFriendHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetTransferFriendHandler.class);

    private final StringMapper mapper;

    public GetTransferFriendHandler(StringMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        int userId = (int) request.get("userId");

        List<Object> transferFriendList = new ArrayList<>();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("transferFriendList", transferFriendList);

        String json = mapper.write(resultMap);
        logger.info("Response: " + json);
        return json;
    }
}
