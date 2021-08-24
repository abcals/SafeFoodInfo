package SafeFoodInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.SellStopMapper;
import SafeFoodInfo.vo.SellStopVO;

@Service
public class SellStopService {
    @Autowired
    SellStopMapper mapper;
    public void insertSellStop(SellStopVO vo){
        mapper.insertSellStop(vo);
    }
    public List<SellStopVO> selectSellStop_topList(){
        return mapper.selectSellStop_topList();
    }
}
