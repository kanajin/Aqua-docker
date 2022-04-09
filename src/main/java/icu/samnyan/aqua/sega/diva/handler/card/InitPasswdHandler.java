package icu.samnyan.aqua.sega.diva.handler.card;

import icu.samnyan.aqua.sega.diva.dao.userdata.GameSessionRepository;
import icu.samnyan.aqua.sega.diva.handler.BaseHandler;
import icu.samnyan.aqua.sega.diva.model.request.BaseRequest;
import icu.samnyan.aqua.sega.diva.model.response.BaseResponse;
import icu.samnyan.aqua.sega.diva.service.PlayerProfileService;
import icu.samnyan.aqua.sega.diva.util.DivaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component
public class InitPasswdHandler extends BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(InitPasswdHandler.class);

    private final PlayerProfileService playerProfileService;

    private final GameSessionRepository gameSessionRepository;

    public InitPasswdHandler(DivaMapper mapper, PlayerProfileService playerProfileService, GameSessionRepository gameSessionRepository) {
        super(mapper);
        this.playerProfileService = playerProfileService;
        this.gameSessionRepository = gameSessionRepository;
    }

    public String handle(BaseRequest request) {
        BaseResponse response = new BaseResponse(
                request.getCmd(),
                request.getReq_id(),
                "0");

        String resp = this.build(mapper.toMap(response));
        logger.info("Response: {}", resp);

        return resp;
    }
}
