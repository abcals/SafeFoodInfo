package SafeFoodInfo.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SafeFoodInfo.mapper.MemberMapper;
import SafeFoodInfo.utils.AESAlgorithm;
import SafeFoodInfo.vo.board_vo.MemberInfoVO;

@Service
public class MemberService {
    @Autowired
    MemberMapper mapper;
    public Map<String, Object> insertMember(MemberInfoVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        boolean duplicated = isDuplicatedId(vo.getMi_id());
        if(duplicated){
            resultMap.put("status",false);
            resultMap.put("message","아이디가 중복됩니다.");
            return resultMap;
        }
        boolean email_dup = isDuplicatedEmail(vo.getMi_email());
        if(email_dup){
            resultMap.put("status",false);
            resultMap.put("message","이메일이 중복됩니다.");
            return resultMap;
        }
        String pwd = vo.getMi_pwd();
        try{
        pwd = AESAlgorithm.Encrypt(pwd);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        vo.setMi_pwd(pwd);

        mapper.insertMember(vo);

        resultMap.put("status", true);
        resultMap.put("message", "회원가입이 완료되었습니다.");

        return resultMap;
    }
    public boolean isDuplicatedId(String id){
        return mapper.selectMemberById(id) > 0;
    }
    public boolean isDuplicatedEmail(String email){
        return mapper.selectMemberByEmail(email) > 0;
    }
}
