package SafeFoodInfo.vo;

import lombok.Data;

@Data
public class FoodNutritionInfoVO {
    private Integer fni_seq;
    private String fni_serving_wt;
    private String fni_kcal;
    private String fni_carbohydrate;
    private String fni_protein;
    private String fni_fat;
    private String fni_saccharide;
    private String fni_sodium;
    private String fni_cholesterol;
    private String fni_saturated_fat;
    private String fni_trans_fat;
    private String fni_name;
    private String fni_bgn_year;
}
