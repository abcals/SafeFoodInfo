package SafeFoodInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.FoodAdditivesMapper;
import SafeFoodInfo.vo.FoodAdditivesInfoVO;

@Service
public class FoodAdditivesService {
    @Autowired
    FoodAdditivesMapper mapper;
    public void insertFoodAdditives(FoodAdditivesInfoVO vo){
        mapper.insertFoodAdditives(vo);
    }
}
