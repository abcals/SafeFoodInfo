package SafeFoodInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.AdministrativeMeasureVO;

@Mapper
public interface AdministrativeMeasureMapper {
    public void insertAdministrativeMeasure(AdministrativeMeasureVO vo);
    public List<AdministrativeMeasureVO> selectAdministrativeMeasure_topList();
}
