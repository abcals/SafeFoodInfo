package SafeFoodInfo.mapper;

import SafeFoodInfo.vo.FoodNutritionInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodNutritionInfoMapper {
    public void insertFoodNutritionInfo(FoodNutritionInfoVO vo);
}
