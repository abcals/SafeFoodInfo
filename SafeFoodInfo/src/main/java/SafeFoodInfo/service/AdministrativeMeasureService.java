package SafeFoodInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.AdministrativeMeasureMapper;
import SafeFoodInfo.vo.AdministrativeMeasureVO;

@Service
public class AdministrativeMeasureService {
    @Autowired
    AdministrativeMeasureMapper mapper;
    public void insertAdministrativeMeasure(AdministrativeMeasureVO vo){
        mapper.insertAdministrativeMeasure(vo);
    }
    public List<AdministrativeMeasureVO> selectAdministrativeMeasure_topList(){
        return mapper.selectAdministrativeMeasure_topList();
    }
}
