package SafeFoodInfo.vo.healthfood_vo;

import lombok.Data;

@Data
public class HealthFood_IngredientVO {
    private Integer hfi_seq;
    private String hfi_pawmtrl_nm;
    private String hfi_hf_fnclty_mtral_rcpgn_no;
    private String hfi_iftkn_atnt_matr_cn;
    private String hfi_wt_unit;
    private String hfi_day_intk_highlimit;
    private String hfi_day_intk_lowlimit;
    private String hfi_primary_fnclty;
}

