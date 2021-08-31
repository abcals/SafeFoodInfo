package SafeFoodInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.child_vo.ChildFavoriteFoodQualityVO;
import SafeFoodInfo.vo.child_vo.ChildFoodSafeAreaVO;
import SafeFoodInfo.vo.child_vo.ChildGoodStoreVO;
import SafeFoodInfo.vo.child_vo.ChildMealServiceCenterVO;

@Mapper
public interface ChildInfoMapper {
    public void insertChildMealServiceCenter(ChildMealServiceCenterVO vo);
    public void insertChildGoodStore(ChildGoodStoreVO vo);
    public void insertChildFoodSafeArea(ChildFoodSafeAreaVO vo);
    public void insertChildFavoriteFoodQuality(ChildFavoriteFoodQualityVO vo);
    public List<ChildFavoriteFoodQualityVO> selectEnterpriseCnt();
    public List<ChildGoodStoreVO> selectRegionalGoodStoreCnt(String regional);
    public List<ChildGoodStoreVO> selectRegionalGoodStoreList(String region);
    public List<ChildMealServiceCenterVO> selectMealServiceList();
    public List<ChildFavoriteFoodQualityVO> selectFavoriteE_name();
    public List<ChildFavoriteFoodQualityVO> selectEnterpriseFavoriteFood(String enterprise);
}
