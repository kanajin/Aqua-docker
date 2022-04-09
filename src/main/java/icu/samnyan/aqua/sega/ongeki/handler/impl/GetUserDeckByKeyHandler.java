package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.ongeki.dao.userdata.UserDeckRepository;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserDeck;
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
@Component("OngekiGetUserDeckByKeyHandler")
public class GetUserDeckByKeyHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserDeckByKeyHandler.class);

    private final BasicMapper mapper;

    private final UserDeckRepository userDeckRepository;

    @Autowired
    public GetUserDeckByKeyHandler(BasicMapper mapper, UserDeckRepository userDeckRepository) {
        this.mapper = mapper;
        this.userDeckRepository = userDeckRepository;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        List<UserDeck> deckList = userDeckRepository.findByUser_Card_ExtId(userId);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", deckList.size());
        resultMap.put("userDeckList", deckList);

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
