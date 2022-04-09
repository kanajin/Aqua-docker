package icu.samnyan.aqua.sega.diva.model.response.ingame;

import icu.samnyan.aqua.sega.diva.model.common.Result;
import icu.samnyan.aqua.sega.diva.model.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Getter
@Setter
public class BuyCstmzItmResponse extends BaseResponse {
    private Result shp_rslt;
    private int cstmz_itm_id;
    private String cstmz_itm_have;
    private int vcld_pts;

    public BuyCstmzItmResponse(String cmd, String req_id, String stat, Result shp_rslt, int cstmz_itm_id, String cstmz_itm_have, int vcld_pts) {
        super(cmd, req_id, stat);
        this.shp_rslt = shp_rslt;
        this.cstmz_itm_id = cstmz_itm_id;
        this.cstmz_itm_have = cstmz_itm_have;
        this.vcld_pts = vcld_pts;
    }

    public BuyCstmzItmResponse(String cmd, String req_id, String stat, Result shp_rslt) {
        super(cmd, req_id, stat);
        this.shp_rslt = shp_rslt;
    }
}
