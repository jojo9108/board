package co.bbuggu.prj;

import java.util.ArrayList;
import java.util.List;

import co.bbuggu.prj.member.service.MemberService;
import co.bbuggu.prj.member.serviceImpl.MemberServiceImpl;
import co.bbuggu.prj.member.vo.MemberVO;

public class MainApp {
	public static void main(String[] args) {
		// TODO db 연결
		MemberService dao = new MemberServiceImpl(); // db 연결을 위한 객체를 초기화
		List<MemberVO> list = new ArrayList<MemberVO>(); // dao 객체로부터 넘어온 리스트 담기
		
		list = dao.memberSelectList();
		
		for(MemberVO member : list) {
			member.toString();
		}
	}
}

// 1. VO 객체 만들기 (Table 1 : 1), 컬럼명(ID) = 멤버변수명(id)
// 2. DAO 객체 만들기
// 3. 질문지작성 Interface
//	1) 전체 select
//	2) 한개 select
//	3) 한개 insert
//	4) 한개 delete
//	5) 한개 update 