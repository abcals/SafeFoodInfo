package SafeFoodInfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.FoodAdditivesInfoVO;

@Mapper
public interface FoodAdditivesMapper {
    public void insertFoodAdditives(FoodAdditivesInfoVO vo);
}
