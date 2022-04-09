package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.ongeki.dao.userdata.UserCardRepository;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserCard;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("OngekiGetUserCardHandler")
public class GetUserCardHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserCardHandler.class);

    private final BasicMapper mapper;

    private final UserCardRepository userCardRepository;

    @Autowired
    public GetUserCardHandler(BasicMapper mapper, UserCardRepository userCardRepository) {
        this.mapper = mapper;
        this.userCardRepository = userCardRepository;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        Integer userId = (Integer) request.get("userId");
        Integer maxCount = (Integer) request.get("maxCount");
        Integer nextIndex = (Integer) request.get("nextIndex");

        int pageNum = nextIndex / maxCount;

        Page<UserCard> dbPage = userCardRepository.findByUser_Card_ExtId(userId, PageRequest.of(pageNum, maxCount));

        long currentIndex = maxCount * pageNum + dbPage.getNumberOfElements();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", dbPage.getNumberOfElements());
        resultMap.put("nextIndex", dbPage.getNumberOfElements() < maxCount ? -1 : currentIndex);
        resultMap.put("userCardList", dbPage.getContent());

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
