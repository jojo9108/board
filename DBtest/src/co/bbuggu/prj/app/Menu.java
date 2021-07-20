package co.bbuggu.prj.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.bbuggu.prj.service.MemberService;
import co.bbuggu.prj.serviceImpl.MemberServiceImpl;
import co.bbuggu.prj.vo.MemberVO;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private MemberService dao = new MemberServiceImpl();

	private void menuTitle() {
		System.out.println("💧💧💧💧💧💧💧=💧💧💧💧💧💧💧");
		System.out.println("💧 회원정보 관리 시스템 💧");
		System.out.println("💧💧1. 회원 목록 조회💧💧");
		System.out.println("💧💧2. 회원 정보 조회💧💧");
		System.out.println("💧💧3. 회원 정보 등록💧💧");
		System.out.println("💧💧4. 회원 정보 수정💧💧");
		System.out.println("💧💧5. 회원 정보 삭제💧💧");
		System.out.println("💧💧💧💧💧6. 종료💧💧💧💧💧");
		System.out.println("💧💧💧💧💧💧💧=💧💧💧💧💧💧💧");
		System.out.println("원하시는 작업 번호를 선택하세요");
	}

	private void mainMenu() {
		int jobNo;
		boolean b = false;

		do {
			menuTitle();
			switch (jobNo = sc.nextInt()) {

			case 1:
				memberSelectList();
				break;
			case 2:
				memberSelect();
				break;
			case 3:
				memberInsert();
				break;
			case 4:
				memberUpdate();
				break;
			case 5:
				memberDelete();
				break;
			case 6:
				b = true;
				System.out.println("프로그램을 종료합니다");
				break;

			}
		} while (!b);

	}

	private void memberSelectList() {
		// TODO 전체 조회
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = dao.memberSelectList();
		for (MemberVO member : members) {
			member.toString();
		}
	}

	private void memberSelect() {
		// TODO 한명 조회
		MemberVO vo = new MemberVO();
		System.out.println("조회하실 ID를 입력하세요");
		vo.setId(sc.next());
		sc.nextLine();
		vo = dao.memberSelect(vo);
		vo.toString();
	}

	private void memberInsert() {
		// TODO 데이터 삽입
		MemberVO vo = new MemberVO();
		System.out.println("Id > ");
		vo.setId(sc.next());
		sc.nextLine();
		System.out.println("Password > ");
		vo.setPassword(sc.next());
		sc.nextLine();
		System.out.println("Name > ");
		vo.setName(sc.next());
		sc.nextLine();
		System.out.println("Address > ");
		vo.setAddress(sc.next());
		sc.nextLine();
		System.out.println("Tel > ");
		vo.setTel(sc.next());
		sc.nextLine();
		System.out.println("Age > ");
		vo.setAge(sc.nextInt());
		int n = dao.memberInsert(vo);
		if (n != 0) {
			System.out.println("회원 등록 완료");
		} else {
			System.out.println("회원 등록 실패");
		}

	}

	private void memberUpdate() {
		// TODO 데이터 수정
		System.out.println("수정하실 ID를 입력하세요");
		MemberVO vo = new MemberVO();
		vo.setId(sc.next());
		sc.nextLine();
		System.out.println("Name > ");
		vo.setName(sc.next());
		sc.nextLine();
		System.out.println("Address > ");
		vo.setAddress(sc.next());
		sc.nextLine();
		System.out.println("Tel > ");
		vo.setTel(sc.next());
		int n = dao.memberUpdate(vo);
		if (n != 0) {
			System.out.println("회원 수정 완료");
		} else {
			System.out.println("회원 수정 실패");
		}

	}

	private void memberDelete() {
		// TODO 데이터 삭제
		MemberVO vo = new MemberVO();
		System.out.println("삭제하실 ID를 입력하세요");
		vo.setId(sc.next());
		int n = dao.memberDelete(vo);
		if (n != 0) {
			System.out.println("회원 삭제 완료");
		} else {
			System.out.println("회원 삭제 실패");
		}
		

	}

	public void run() {
		mainMenu();
	}
}