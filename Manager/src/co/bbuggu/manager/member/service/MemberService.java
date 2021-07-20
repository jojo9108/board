package co.bbuggu.manager.member.service;

import java.util.List;

import co.bbuggu.manager.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();   // 전체회원 목록
	MemberVO memberSelect(MemberVO vo);  // 회원 조회
	MemberVO loginCheck(MemberVO vo);    // 로그인 처리
	int memberInsert(MemberVO vo);       // 회원 추가
	int memberDelete(MemberVO vo);       // 회원 삭제
	int membmerUpdate(MemberVO vo);      // 회원 수정
	
}
