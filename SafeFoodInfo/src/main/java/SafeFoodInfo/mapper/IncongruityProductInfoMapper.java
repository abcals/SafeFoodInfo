package SafeFoodInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.IncongruityProductInfoVO;

@Mapper
public interface IncongruityProductInfoMapper {
    public void insertIncongruityProductInfo(IncongruityProductInfoVO vo);
    public List<IncongruityProductInfoVO> selectIncongruityProductInfo_topList();
}
