package SafeFoodInfo.controller;

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
}
