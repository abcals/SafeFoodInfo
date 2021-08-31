package SafeFoodInfo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PoisonIndexVO {
    private Integer pi_seq;
    private String pi_code;
    private String pi_areaNo;
    private Date pi_date;
    private String pi_today;
    private String pi_tomorrow;
    private String pi_theDayAfterTomorrow;
}
