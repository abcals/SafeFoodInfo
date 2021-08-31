package SafeFoodInfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.FoodPoisoningRegioncConditionVO;
import SafeFoodInfo.vo.PoisonIndexVO;

@Mapper
public interface FoodPoisoningRegioncConditionMapper {
    public void insertFoodPoisoningRegioncCondition(FoodPoisoningRegioncConditionVO vo);
    public void insertPoisonIndex(PoisonIndexVO vo);
}
