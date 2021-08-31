package SafeFoodInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.FoodPoisoningRegioncConditionMapper;
import SafeFoodInfo.vo.FoodPoisoningRegioncConditionVO;
import SafeFoodInfo.vo.PoisonIndexVO;

@Service
public class FoodPoisoningRegioncConditionService {
    @Autowired
    FoodPoisoningRegioncConditionMapper mapper;
    public void insertFoodPoisoningRegioncCondition(FoodPoisoningRegioncConditionVO vo){
        mapper.insertFoodPoisoningRegioncCondition(vo);
    }
    public void insertPoisonIndex(PoisonIndexVO vo){
        mapper.insertPoisonIndex(vo);
    }
}
