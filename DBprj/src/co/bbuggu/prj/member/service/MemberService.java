package co.bbuggu.prj.member.service;

import java.util.List;

import co.bbuggu.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); // 전체 회원정보 가져오기

	MemberVO memberSelect(MemberVO vo); // 한명 데이터 조회

	int memberInsert(MemberVO vo); // 한명 데이터 추가

	int memberUpdate(MemberVO vo); // 한명 데이터 수정

	int memberDelete(MemberVO vo); // 한명 데이터 삭제

}
