package SafeFoodInfo.vo.board_vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardListVO {
    private Integer bl_seq;
    private String bl_title;
    private String bl_content;
    private String bl_wuser;
    private Date bl_wdate;
    private Date bl_mdate;
    private Integer bl_cnt;
    private String bl_file;
}
