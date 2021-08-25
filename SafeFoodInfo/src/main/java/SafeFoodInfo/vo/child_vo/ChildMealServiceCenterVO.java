package SafeFoodInfo.vo.child_vo;

import lombok.Data;

@Data
public class ChildMealServiceCenterVO {
    private Integer cm_seq;
    private String cm_instt_nm;
    private String cm_cnter_nm;
    private String cm_report_yr;
    private String cm_report_qu;
    private Integer cm_kndrgr_reg_co;
    private Integer cm_kndrgr_nmpr_co;
    private Integer cm_dccntr_reg_co;
    private Integer cm_dccntr_nmpr_co;
    private Integer cm_etc_reg_co;
    private Integer cm_etc_nmpr_co;
}
