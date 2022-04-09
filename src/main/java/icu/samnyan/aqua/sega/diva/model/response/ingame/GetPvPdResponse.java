package icu.samnyan.aqua.sega.diva.model.response.ingame;

import icu.samnyan.aqua.sega.diva.model.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Getter
@Setter
public class GetPvPdResponse extends BaseResponse {
    private String pd_by_pv_id;
    private Boolean pdddt_flg;
    private String pdddt_tm;

    public GetPvPdResponse(String cmd, String req_id, String stat, String pd_by_pv_id, Boolean pdddt_flg, String pdddt_tm) {
        super(cmd, req_id, stat);
        this.pd_by_pv_id = pd_by_pv_id;
        this.pdddt_flg = pdddt_flg;
        this.pdddt_tm = pdddt_tm;
    }
}
