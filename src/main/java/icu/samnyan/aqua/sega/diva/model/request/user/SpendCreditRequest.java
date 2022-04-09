package icu.samnyan.aqua.sega.diva.model.request.user;

import icu.samnyan.aqua.sega.diva.model.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpendCreditRequest extends BaseRequest {
    private int pd_id;
    private int[] my_qst_id;
    private int[] my_qst_sts;
    private int crdt_typ;
    private int[] cmpgn_id;
    private int[] cmpgn_pb;
}
