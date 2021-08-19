package SafeFoodInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.FoodNutritionInfoMapper;
import SafeFoodInfo.vo.FoodNutritionInfoVO;

@Service
public class FoodNutritionInfoService {
    @Autowired
    FoodNutritionInfoMapper mapper;
    public void insertFoodNutritionInfo(FoodNutritionInfoVO vo){
        mapper.insertFoodNutritionInfo(vo);
    }    
}
