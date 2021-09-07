package SafeFoodInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.board_vo.BoardListVO;

@Mapper
public interface BoardMapper {
    public void insertBoardContent(BoardListVO vo);
    public List<BoardListVO> selectBoardList();
}
