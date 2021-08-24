package SafeFoodInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.SellStopVO;

@Mapper
public interface SellStopMapper {
    public void insertSellStop(SellStopVO vo);
    public List<SellStopVO> selectSellStop_topList();
}
