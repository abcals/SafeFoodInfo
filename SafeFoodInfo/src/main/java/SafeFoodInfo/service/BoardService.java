package SafeFoodInfo.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.BoardMapper;
import SafeFoodInfo.vo.board_vo.BoardListVO;

@Service
public class BoardService {
    @Autowired
    BoardMapper mapper;
    public Map<String, Object> insertBoardContent(BoardListVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        mapper.insertBoardContent(vo);

        resultMap.put("status", true);
        resultMap.put("message", "글이 등록되었습니다.");
        return resultMap;
    }
    public List<BoardListVO> selectBoardList(){
        return mapper.selectBoardList();
    }
}
