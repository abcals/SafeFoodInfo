package SafeFoodInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.HealthFood_IngredientMapper;
import SafeFoodInfo.vo.healthfood_vo.HealthFood_IngredientVO;

@Service
public class HealthFood_IngredientService {
    @Autowired
    HealthFood_IngredientMapper mapper;
    public void insertHealthFoodIndividuelIngredient(HealthFood_IngredientVO vo){
        mapper.insertHealthFoodIndividuelIngredient(vo);
    }
}
