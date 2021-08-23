package SafeFoodInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.IncongruityProductInfoMapper;
import SafeFoodInfo.vo.IncongruityProductInfoVO;

@Service
public class IncongruityProductInfoService {
    @Autowired
    IncongruityProductInfoMapper mapper;
    public void insertIncongruityProductInfo(IncongruityProductInfoVO vo){
        mapper.insertIncongruityProductInfo(vo);
    }
    public List<IncongruityProductInfoVO> selectIncongruityProductInfo_topList(){
        return mapper.selectIncongruityProductInfo_topList();
    }
}
