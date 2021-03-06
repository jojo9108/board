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
		System.out.println("π§π§π§π§π§π§π§=π§π§π§π§π§π§π§");
		System.out.println("π§ νμμ λ³΄ κ΄λ¦¬ μμ€ν π§");
		System.out.println("π§π§1. νμ λͺ©λ‘ μ‘°νπ§π§");
		System.out.println("π§π§2. νμ μ λ³΄ μ‘°νπ§π§");
		System.out.println("π§π§3. νμ μ λ³΄ λ±λ‘π§π§");
		System.out.println("π§π§4. νμ μ λ³΄ μμ π§π§");
		System.out.println("π§π§5. νμ μ λ³΄ μ­μ π§π§");
		System.out.println("π§π§π§π§π§6. μ’λ£π§π§π§π§π§");
		System.out.println("π§π§π§π§π§π§π§=π§π§π§π§π§π§π§");
		System.out.println("μνμλ μμ λ²νΈλ₯Ό μ ννμΈμ");
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
				System.out.println("νλ‘κ·Έλ¨μ μ’λ£ν©λλ€");
				break;

			}
		} while (!b);

	}

	private void memberSelectList() {
		// TODO μ μ²΄ μ‘°ν
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = dao.memberSelectList();
		for (MemberVO member : members) {
			member.toString();
		}
	}

	private void memberSelect() {
		// TODO νλͺ μ‘°ν
		MemberVO vo = new MemberVO();
		System.out.println("μ‘°ννμ€ IDλ₯Ό μλ ₯νμΈμ");
		vo.setId(sc.next());
		sc.nextLine();
		vo = dao.memberSelect(vo);
		vo.toString();
	}

	private void memberInsert() {
		// TODO λ°μ΄ν° μ½μ
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
			System.out.println("νμ λ±λ‘ μλ£");
		} else {
			System.out.println("νμ λ±λ‘ μ€ν¨");
		}

	}

	private void memberUpdate() {
		// TODO λ°μ΄ν° μμ 
		System.out.println("μμ νμ€ IDλ₯Ό μλ ₯νμΈμ");
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
			System.out.println("νμ μμ  μλ£");
		} else {
			System.out.println("νμ μμ  μ€ν¨");
		}

	}

	private void memberDelete() {
		// TODO λ°μ΄ν° μ­μ 
		MemberVO vo = new MemberVO();
		System.out.println("μ­μ νμ€ IDλ₯Ό μλ ₯νμΈμ");
		vo.setId(sc.next());
		int n = dao.memberDelete(vo);
		if (n != 0) {
			System.out.println("νμ μ­μ  μλ£");
		} else {
			System.out.println("νμ μ­μ  μ€ν¨");
		}
		

	}

	public void run() {
		mainMenu();
	}
}