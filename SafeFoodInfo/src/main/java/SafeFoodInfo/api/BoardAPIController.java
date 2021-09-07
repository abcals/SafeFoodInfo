package SafeFoodInfo.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SafeFoodInfo.service.BoardService;
import SafeFoodInfo.vo.board_vo.BoardListVO;

@RestController
public class BoardAPIController {
    @Autowired
    BoardService service;
    @PostMapping("/api/board/content")
    public Map<String, Object> postBoardContent(@RequestBody BoardListVO vo){
        Map<String, Object> resultMap = service.insertBoardContent(vo);
        
        return resultMap;
    }
    @GetMapping("/api/board/content/list")
    public Map<String, Object> getBoardList(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<BoardListVO> list = service.selectBoardList();
        resultMap.put("list", list);

        return resultMap;
    }
}
