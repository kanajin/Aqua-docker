package icu.samnyan.aqua.sega.ongeki.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.ongeki.dao.userdata.UserChapterRepository;
import icu.samnyan.aqua.sega.ongeki.handler.BaseHandler;
import icu.samnyan.aqua.sega.ongeki.model.userdata.UserChapter;
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
@Component("OngekiGetUserChapterHandler")
public class GetUserChapterHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(GetUserChapterHandler.class);

    private final BasicMapper mapper;

    private final UserChapterRepository userChapterRepository;

    @Autowired
    public GetUserChapterHandler(BasicMapper mapper, UserChapterRepository userChapterRepository) {
        this.mapper = mapper;
        this.userChapterRepository = userChapterRepository;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        long userId = ((Number) request.get("userId")).longValue();

        List<UserChapter> chapterList = userChapterRepository.findByUser_Card_ExtId(userId);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("length", chapterList.size());
        resultMap.put("userChapterList", chapterList);

        String json = mapper.write(resultMap);

        logger.info("Response: " + json);
        return json;
    }
}
