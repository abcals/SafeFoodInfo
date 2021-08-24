package SafeFoodInfo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class SellStopVO {
    private Integer ss_seq;
    private String ss_prdtnm;
    private String ss_rtrvlprvns;
    private String ss_bsshnm;
    private String ss_addr;
    private String ss_prcscitypoint_telno;
    private String ss_brcdno;
    private String ss_frmlcunit;
    private String ss_mnfdt;
    private String ss_rtrvlplandoc_rtrvlmthd;
    private String ss_distbtmlmt;
    private String ss_prdlst_type;
    private String ss_img_file_path;
    private String ss_prdlst_cd;
    private Date ss_cret_dtm;
    private String ss_rtrvldsuse_seq;
    private String ss_prdlst_report_no;
    private String ss_rtrvl_grdcd_nm;
    private String ss_prdlst_cd_nm;
    private String ss_lcns_no;
}
