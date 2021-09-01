package SafeFoodInfo.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SafeFoodInfo.service.MemberService;
import SafeFoodInfo.vo.board_vo.MemberInfoVO;

@RestController
public class MemberAPIController {
    @Autowired
    MemberService service;
    @PostMapping("/member/join")
    public ResponseEntity<Map<String, Object>> postMemberJoin(@RequestBody MemberInfoVO vo) {
        Map<String, Object> resultMap = service.insertMember(vo);
        if(!(boolean)resultMap.get("status")){
            return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resultMap, HttpStatus.CREATED);
    }

    @GetMapping("/member/id_check")
    public Map<String, Object> getIdCheck(@RequestParam String id){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(service.isDuplicatedId(id) == true){
            // 중복체크 - 실패 (false)
            resultMap.put("status",false);
            resultMap.put("message","["+id+"] 는 이미 사용중입니다.");
            return resultMap;
        }
        resultMap.put("status",true);
        resultMap.put("message","["+id+"] 는 사용하실 수 있습니다.");
        return resultMap;
    }
    @GetMapping("/member/email_check")
    public Map<String, Object> getEmailCheck(@RequestParam String email){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(service.isDuplicatedEmail(email) == true){
            // 중복체크 - 실패 (false)
            resultMap.put("status",false);  
            resultMap.put("message","["+email+"] 은 이미 사용중입니다.");
            return resultMap;
        }
        resultMap.put("status",true);
        resultMap.put("message","["+email+"] 은 사용하실 수 있습니다.");
        return resultMap;
    }
}
