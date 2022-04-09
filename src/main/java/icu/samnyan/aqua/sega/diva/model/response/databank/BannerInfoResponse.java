package icu.samnyan.aqua.sega.diva.model.response.databank;

import icu.samnyan.aqua.sega.diva.model.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Getter
@Setter
public class BannerInfoResponse extends BaseResponse {
    private String bi_lut;
    // Array of 10
    private String bi_id;
    private String bi_st;
    private String bi_et;
    private String bi_ut;

    public BannerInfoResponse(String cmd, String req_id, String stat, String bi_lut, String bi_id, String bi_st, String bi_et, String bi_ut) {
        super(cmd, req_id, stat);
        this.bi_lut = bi_lut;
        this.bi_id = bi_id;
        this.bi_st = bi_st;
        this.bi_et = bi_et;
        this.bi_ut = bi_ut;
    }
}
