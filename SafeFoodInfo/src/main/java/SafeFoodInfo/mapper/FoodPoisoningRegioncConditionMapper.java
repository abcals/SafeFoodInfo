package SafeFoodInfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.FoodPoisoningRegioncConditionVO;

@Mapper
public interface FoodPoisoningRegioncConditionMapper {
    public void insertFoodPoisoningRegioncCondition(FoodPoisoningRegioncConditionVO vo);
}
