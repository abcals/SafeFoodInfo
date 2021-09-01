package SafeFoodInfo.vo.board_vo;

import lombok.Data;

@Data
public class MemberInfoVO {
    private Integer mi_seq;
    private String mi_id;
    private String mi_pwd;
    private String mi_name;
    private String mi_email;
    private Integer mi_gen;
    private String mi_phone;
    private String mi_birth_year;
    private String mi_birth_m;
    private String mi_birth_d;
}
