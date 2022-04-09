package icu.samnyan.aqua.sega.chunithm.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chunithm.handler.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@RestController
@RequestMapping({"/ChuniServlet/{ROM_VERSION}/{CLIENT_ID}/ChuniServlet", "/ChuniServlet"})
public class ChuniServletController {

    private final GameLoginHandler gameLoginHandler;
    private final GameLogoutHandler gameLogoutHandler;
    private final GetGameChargeHandler getGameChargeHandler;
    private final GetGameEventHandler getGameEventHandler;
    private final GetGameIdlistHandler getGameIdlistHandler;
    private final GetGameMessageHandler getGameMessageHandler;
    private final GetGameRankingHandler getGameRankingHandler;
    private final GetGameSaleHandler getGameSaleHandler;
    private final GetGameSettingHandler getGameSettingHandler;
    private final GetTeamCourseRuleHandler getTeamCourseRuleHandler;
    private final GetTeamCourseSettingHandler getTeamCourseSettingHandler;
    private final GetUserActivityHandler getUserActivityHandler;
    private final GetUserCharacterHandler getUserCharacterHandler;
    private final GetUserChargeHandler getUserChargeHandler;
    private final GetUserCourseHandler getUserCourseHandler;
    private final GetUserDataExHandler getUserDataExHandler;
    private final GetUserDataHandler getUserDataHandler;
    private final GetUserDuelHandler getUserDuelHandler;
    private final GetUserFavoriteItemHandler getUserFavoriteItemHandler;
    private final GetUserFavoriteMusicHandler getUserFavoriteMusicHandler;
    private final GetUserItemHandler getUserItemHandler;
    private final GetUserLoginBonusHandler getUserLoginBonusHandler;
    private final GetUserMapHandler getUserMapHandler;
    private final GetUserMusicHandler getUserMusicHandler;
    private final GetUserOptionExHandler getUserOptionExHandler;
    private final GetUserOptionHandler getUserOptionHandler;
    private final GetUserPreviewHandler getUserPreviewHandler;
    private final GetUserRecentRatingHandler getUserRecentRatingHandler;
    private final GetUserRegionHandler getUserRegionHandler;
    private final GetUserRivalDataHandler getUserRivalDataHandler;
    private final GetUserRivalMusicHandler getUserRivalMusicHandler;
    private final GetUserTeamHandler getUserTeamHandler;
    private final UpsertClientBookkeepingHandler upsertClientBookkeepingHandler;
    private final UpsertClientDevelopHandler upsertClientDevelopHandler;
    private final UpsertClientErrorHandler upsertClientErrorHandler;
    private final UpsertClientSettingHandler upsertClientSettingHandler;
    private final UpsertClientTestmodeHandler upsertClientTestmodeHandler;
    private final UpsertUserAllHandler upsertUserAllHandler;
    private final UpsertUserChargelogHandler upsertUserChargelogHandler;

    @Autowired
    public ChuniServletController(GameLoginHandler gameLoginHandler, GameLogoutHandler gameLogoutHandler, GetGameChargeHandler getGameChargeHandler, GetGameEventHandler getGameEventHandler, GetGameIdlistHandler getGameIdlistHandler, GetGameMessageHandler getGameMessageHandler, GetGameRankingHandler getGameRankingHandler, GetGameSaleHandler getGameSaleHandler, GetGameSettingHandler getGameSettingHandler,GetTeamCourseRuleHandler getTeamCourseRuleHandler, GetTeamCourseSettingHandler getTeamCourseSettingHandler, GetUserActivityHandler getUserActivityHandler, GetUserCharacterHandler getUserCharacterHandler, GetUserChargeHandler getUserChargeHandler, GetUserCourseHandler getUserCourseHandler, GetUserDataExHandler getUserDataExHandler, GetUserDataHandler getUserDataHandler, GetUserDuelHandler getUserDuelHandler, GetUserFavoriteItemHandler getUserFavoriteItemHandler, GetUserFavoriteMusicHandler getUserFavoriteMusicHandler, GetUserItemHandler getUserItemHandler, GetUserLoginBonusHandler getUserLoginBonusHandler, GetUserMapHandler getUserMapHandler, GetUserMusicHandler getUserMusicHandler, GetUserOptionExHandler getUserOptionExHandler, GetUserOptionHandler getUserOptionHandler, GetUserPreviewHandler getUserPreviewHandler, GetUserRecentRatingHandler getUserRecentRatingHandler, GetUserRegionHandler getUserRegionHandler, GetUserRivalDataHandler getUserRivalDataHandler, GetUserRivalMusicHandler getUserRivalMusicHandler, GetUserTeamHandler getUserTeamHandler, UpsertClientBookkeepingHandler upsertClientBookkeepingHandler, UpsertClientDevelopHandler upsertClientDevelopHandler, UpsertClientErrorHandler upsertClientErrorHandler, UpsertClientSettingHandler upsertClientSettingHandler, UpsertClientTestmodeHandler upsertClientTestmodeHandler, UpsertUserAllHandler upsertUserAllHandler, UpsertUserChargelogHandler upsertUserChargelogHandler) {
        this.gameLoginHandler = gameLoginHandler;
        this.gameLogoutHandler = gameLogoutHandler;
        this.getGameChargeHandler = getGameChargeHandler;
        this.getGameEventHandler = getGameEventHandler;
        this.getGameIdlistHandler = getGameIdlistHandler;
        this.getGameMessageHandler = getGameMessageHandler;
        this.getGameRankingHandler = getGameRankingHandler;
        this.getGameSaleHandler = getGameSaleHandler;
        this.getGameSettingHandler = getGameSettingHandler;
        this.getTeamCourseRuleHandler = getTeamCourseRuleHandler;
        this.getTeamCourseSettingHandler = getTeamCourseSettingHandler;
        this.getUserActivityHandler = getUserActivityHandler;
        this.getUserCharacterHandler = getUserCharacterHandler;
        this.getUserChargeHandler = getUserChargeHandler;
        this.getUserCourseHandler = getUserCourseHandler;
        this.getUserDataExHandler = getUserDataExHandler;
        this.getUserDataHandler = getUserDataHandler;
        this.getUserDuelHandler = getUserDuelHandler;
        this.getUserFavoriteItemHandler = getUserFavoriteItemHandler;
        this.getUserFavoriteMusicHandler = getUserFavoriteMusicHandler;
        this.getUserItemHandler = getUserItemHandler;
        this.getUserLoginBonusHandler = getUserLoginBonusHandler;
        this.getUserMapHandler = getUserMapHandler;
        this.getUserMusicHandler = getUserMusicHandler;
        this.getUserOptionExHandler = getUserOptionExHandler;
        this.getUserOptionHandler = getUserOptionHandler;
        this.getUserPreviewHandler = getUserPreviewHandler;
        this.getUserRecentRatingHandler = getUserRecentRatingHandler;
        this.getUserRegionHandler = getUserRegionHandler;
        this.getUserRivalDataHandler = getUserRivalDataHandler;
        this.getUserRivalMusicHandler = getUserRivalMusicHandler;
        this.getUserTeamHandler = getUserTeamHandler;
        this.upsertClientBookkeepingHandler = upsertClientBookkeepingHandler;
        this.upsertClientDevelopHandler = upsertClientDevelopHandler;
        this.upsertClientErrorHandler = upsertClientErrorHandler;
        this.upsertClientSettingHandler = upsertClientSettingHandler;
        this.upsertClientTestmodeHandler = upsertClientTestmodeHandler;
        this.upsertUserAllHandler = upsertUserAllHandler;
        this.upsertUserChargelogHandler = upsertUserChargelogHandler;
    }

    @PostMapping("GameLoginApi")
    String gameLogin(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return gameLoginHandler.handle(request);
    }

    @PostMapping("GameLogoutApi")
    String gameLogout(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return gameLogoutHandler.handle(request);
    }

    @PostMapping("GetGameChargeApi")
    String getGameCharge(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameChargeHandler.handle(request);
    }

    @PostMapping("GetGameEventApi")
    String getGameEvent(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameEventHandler.handle(request);
    }

    @PostMapping("GetGameIdlistApi")
    String getGameIdList(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameIdlistHandler.handle(request);
    }

    @PostMapping("GetGameMessageApi")
    String getGameMessage(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameMessageHandler.handle(request);
    }

    @PostMapping("GetGameRankingApi")
    String getGameRanking(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameRankingHandler.handle(request);
    }

    @PostMapping("GetGameSaleApi")
    String getGameSale(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSaleHandler.handle(request);
    }

    /**
     * The game start up request
     *
     * @return json of GameSetting object
     */
    @PostMapping("GetGameSettingApi")
    String getGameSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSettingHandler.handle(request);
    }

    @PostMapping("GetTeamCourseRuleApi")
    String getTeamCourseRule(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getTeamCourseRuleHandler.handle(request);
    }
    @PostMapping("GetTeamCourseSettingApi")
    String getTeamCourseSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getTeamCourseSettingHandler.handle(request);
    }

    @PostMapping("GetUserActivityApi")
    String getUserActivity(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserActivityHandler.handle(request);
    }

    @PostMapping("GetUserCharacterApi")
    String getUserCharacter(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCharacterHandler.handle(request);
    }

    @PostMapping("GetUserChargeApi")
    String getUserCharge(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserChargeHandler.handle(request);
    }

    @PostMapping("GetUserCourseApi")
    String getUserCourse(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCourseHandler.handle(request);
    }

    @PostMapping("GetUserDataApi")
    String getUserData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDataHandler.handle(request);
    }

    @PostMapping("GetUserDataExApi")
    String getUserDataEx(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDataExHandler.handle(request);
    }

    @PostMapping("GetUserDuelApi")
    String getUserDuel(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDuelHandler.handle(request);
    }

    @PostMapping("GetUserFavoriteItemApi")
    String getUserFavoriteItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFavoriteItemHandler.handle(request);
    }

    @PostMapping("GetUserFavoriteMusicApi")
    public String getUserFavoriteMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFavoriteMusicHandler.handle(request);
    }

    @PostMapping("GetUserItemApi")
    String getUserItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserItemHandler.handle(request);
    }

    @PostMapping("GetUserLoginBonusApi")
    String getUserLoginBonus(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserLoginBonusHandler.handle(request);
    }

    @PostMapping("GetUserMapApi")
    String getUserMap(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMapHandler.handle(request);
    }

    @PostMapping("GetUserMusicApi")
    String getUserMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMusicHandler.handle(request);
    }

    @PostMapping("GetUserOptionApi")
    String getUserOption(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserOptionHandler.handle(request);
    }

    @PostMapping("GetUserOptionExApi")
    String getUserOptionEx(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserOptionExHandler.handle(request);
    }

    // Call when login. Return null if no profile exist
    @PostMapping("GetUserPreviewApi")
    String getUserPreview(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserPreviewHandler.handle(request);
    }

    @PostMapping("GetUserRecentRatingApi")
    String getUserRecentRating(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRecentRatingHandler.handle(request);
    }

    /**
     * For older version chunithm
     */
    @PostMapping("GetUserRecentPlayerApi")
    String getUserRecentPlayerApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRecentRatingHandler.handle(request);
    }

    @PostMapping("GetUserRegionApi")
    String getUserRegion(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRegionHandler.handle(request);
    }

    @PostMapping("GetUserRivalDataApi")
    String getUserRivalData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRivalDataHandler.handle(request);
    }
    @PostMapping("GetUserRivalMusicApi")
    String getUserRivalMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRivalMusicHandler.handle(request);
    }

    @PostMapping("GetUserTeamApi")
    String getUserTeam(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTeamHandler.handle(request);
    }

    @PostMapping("UpsertClientBookkeepingApi")
    String upsertClientBookkeeping(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping("UpsertClientDevelopApi")
    String upsertClientDevelop(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping("UpsertClientErrorApi")
    String upsertClientError(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping("UpsertClientSettingApi")
    String upsertClientSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertClientSettingHandler.handle(request);
    }

    @PostMapping("UpsertClientTestmodeApi")
    String upsertClientTestmode(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping("UpsertUserAllApi")
    String upsertUserAll(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserAllHandler.handle(request);
    }

    @PostMapping("UpsertUserChargelogApi")
    String upsertUserChargelog(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserChargelogHandler.handle(request);
    }

}
