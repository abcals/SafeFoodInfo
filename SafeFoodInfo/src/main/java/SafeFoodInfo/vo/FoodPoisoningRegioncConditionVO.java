package SafeFoodInfo.vo;

import lombok.Data;

@Data
public class FoodPoisoningRegioncConditionVO {
    private Integer fp_seq;
    private String fp_year;
    private String fp_mm;
    private String fp_area;
    private Integer fp_cnt;
    private Integer fp_patnt;
}
