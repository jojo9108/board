package co.bbuggu.manager.menu;

import java.util.Scanner;

import co.bbuggu.manager.member.service.MemberService;
import co.bbuggu.manager.member.serviceImpl.MemberServiceImpl;
import co.bbuggu.manager.member.vo.MemberVO;

public class LoginMenu {
	private MemberService memberDao = new MemberServiceImpl();
	private Scanner sc = new Scanner(System.in);

	// 사용자 메뉴 객체 생성
	private UserMenu user = new UserMenu();
	// 관리자 메뉴 객체 생성
	private AdminMenu admin = new AdminMenu();

	private void loginTitle() {
		System.out.println("✒✒✒✒✒✒✒✒✒✒✒✒✒✒");
		System.out.println("✒✒✒✒✒ 로 그 인 ✒✒✒✒✒");
		System.out.println("✒✒✒✒✒✒✒✒✒✒✒✒✒✒");

	}

	private MemberVO loginCheck() {
		MemberVO vo = new MemberVO();
		boolean b = false;
		int loginCount = 1;
		do {
			loginTitle();
			System.out.println("ID > ");
			vo.setId(sc.next());
			sc.nextLine();
			System.out.println("PASSWORD > ");
			vo.setPassword(sc.next());
			sc.nextLine();
			vo = memberDao.loginCheck(vo);
			if (vo.getName() != null) {
				b = true;
			} else {
				System.out.println("ID 또는 PASSWORD가 틀렸습니다.");
				if (loginCount == 3) {
					b = true;
					System.out.println("로그인시도 " + loginCount + "회 초과. 관리자에게 문의바랍니다.");
					vo = new MemberVO();
				} else {
					loginCount++;
				}
			}
		} while (!b);
//		 return vo; -> 3회초과 시에도 종료가 되지않음  // 그래서 위에 vo = new MemberVO(); 로 vo 초기화.
		return vo;
	}

	public void login() {
		MemberVO vo = new MemberVO();
		vo = loginCheck();
		if (vo.getId() != null) {
			if (vo.getAuthor().equals("ADMIN")) {
				admin.run(vo); // admin 객체의 adminMenu 호출
			} else {
				user.run(vo); // user 객체의 userMenu 호출
			}
			// 여기서 주메뉴 호출하면 된다.
			System.out.println("\n✔");
		}
		sc.close();
	}
	
}