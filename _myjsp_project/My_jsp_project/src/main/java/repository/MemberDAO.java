package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	int logout(String id);

	List<MemberVO> getList();

	int memberUpdate(MemberVO mvo);

	int deleteMember(String id);

}