package SafeFoodInfo.vo.child_vo;

import java.util.Date;

import lombok.Data;

@Data
public class ChildGoodStoreVO {
    private Integer cg_seq;
    private String cg_gnt_no;
    private String cg_upso_nm;
    private String cg_upjong;
    private String cg_addr;
    private Date cg_aplc_dt;
    private String cg_hold_instt_cd;

    private Integer g_cnt;
}
