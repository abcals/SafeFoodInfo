package SafeFoodInfo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class FoodAdditivesInfoVO {
    private Integer fa_seq;
    private String fa_prdlst_code;
    private String fa_pc_kor_name;
    private String fa_testitm_code;
    private String fa_t_kor_name;
    private String fa_fnprt_itm_name;
    private String fa_spec_val;
    private String fa_spec_val_sumup;
    private Date fa_vald_begn_dt;
    private Date fa_vald_end_dt;
    private String fa_max_val;
    private String fa_min_val;
    private String fa_injry_yn;
    private String fa_unit_name;
}
