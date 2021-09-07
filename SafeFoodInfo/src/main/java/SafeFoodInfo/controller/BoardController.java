package SafeFoodInfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("/join")
    public String getMemberJoin(){
        return "/board/join";
    }
    @GetMapping("/login")
    public String getMemberLogin(){
        return "/board/login";
    }
    @GetMapping("/member/logout")
    public String getLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/board/boardCreate")
    public String getBoardCreate(){
        return "/board/boardCreate";
    }
    @GetMapping("/board")
    public String getBoardList(){
        return "/board/boardList";
    }
}
