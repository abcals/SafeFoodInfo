package SafeFoodInfo.vo.board_vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardFileVO {
    private Integer f_bl_seq;
    private Integer f_seq;
    private String f_name;
    private String f_rename;
    private Integer f_size;
    private String f_ext;
    private String f_path;
    private String f_cuser;
    private Date f_cdate;
    private Date f_mdate;
    private Integer f_downcnt;
}
