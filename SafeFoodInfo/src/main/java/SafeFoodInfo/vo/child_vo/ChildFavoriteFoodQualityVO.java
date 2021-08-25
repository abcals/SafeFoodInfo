package SafeFoodInfo.vo.child_vo;

import java.util.Date;

import lombok.Data;

@Data
public class ChildFavoriteFoodQualityVO {
    private Integer cq_seq;
    private String cq_child_ffq_crtfc_no;
    private String cq_bssh_nm;
    private String cq_lcns_no;
    private String cq_prdlst_cd_nm;
    private String cq_prdlst_nm;
    private String cq_cn_wt;
    private Date cq_appn_bgn_dt;
    private Date cq_appn_end_dt;
    private String cq_child_favor_food_type_nm;

    private Integer cnt;
}
