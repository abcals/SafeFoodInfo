package SafeFoodInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.ChildInfoMapper;
import SafeFoodInfo.vo.child_vo.ChildFavoriteFoodQualityVO;
import SafeFoodInfo.vo.child_vo.ChildFoodSafeAreaVO;
import SafeFoodInfo.vo.child_vo.ChildGoodStoreVO;
import SafeFoodInfo.vo.child_vo.ChildMealServiceCenterVO;

@Service
public class ChildInfoService {
    @Autowired
    ChildInfoMapper mapper;
    public void insertChildMealServiceCenter(ChildMealServiceCenterVO vo){
        mapper.insertChildMealServiceCenter(vo);
    }
    public void insertChildGoodStore(ChildGoodStoreVO vo){
        mapper.insertChildGoodStore(vo);
    }
    public void insertChildFoodSafeArea(ChildFoodSafeAreaVO vo){
        mapper.insertChildFoodSafeArea(vo);
    }
    public void insertChildFavoriteFoodQuality(ChildFavoriteFoodQualityVO vo){
        mapper.insertChildFavoriteFoodQuality(vo);
    }
    public List<ChildFavoriteFoodQualityVO> selectEnterpriseCnt(){
        return mapper.selectEnterpriseCnt();
    }
    public List<ChildGoodStoreVO> selectRegionalGoodStoreCnt(String regional){
        return mapper.selectRegionalGoodStoreCnt(regional);
    }
    public List<ChildGoodStoreVO> selectRegionalGoodStoreList(String region){
        return mapper.selectRegionalGoodStoreList(region);
    }
    public List<ChildMealServiceCenterVO> selectMealServiceList(){
        return mapper.selectMealServiceList();
    }
    public List<ChildFavoriteFoodQualityVO> selectFavoriteE_name(){
        return mapper.selectFavoriteE_name();
    }
    public List<ChildFavoriteFoodQualityVO> selectEnterpriseFavoriteFood(String enterprise){
        return mapper.selectEnterpriseFavoriteFood(enterprise);
    }
}
