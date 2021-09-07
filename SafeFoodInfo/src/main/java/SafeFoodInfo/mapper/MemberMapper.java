package SafeFoodInfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import SafeFoodInfo.vo.board_vo.LoginVO;
import SafeFoodInfo.vo.board_vo.MemberInfoVO;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberInfoVO vo);
    public Integer selectMemberById(String id);
    public Integer selectMemberByEmail(String email);

    public Integer loginMember(LoginVO vo);
    public MemberInfoVO selectMemberInfo(String id);
}
