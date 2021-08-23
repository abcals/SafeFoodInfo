package SafeFoodInfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.healthfood_vo.HealthFood_IngredientVO;

@Mapper
public interface HealthFood_IngredientMapper {
    public void insertHealthFoodIndividuelIngredient(HealthFood_IngredientVO vo);
}
