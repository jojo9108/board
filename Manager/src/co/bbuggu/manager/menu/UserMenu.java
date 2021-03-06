package co.bbuggu.manager.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.bbuggu.manager.board.service.BoardService;
import co.bbuggu.manager.board.serviceImpl.BoardServiceImpl;
import co.bbuggu.manager.board.vo.BoardVO;
import co.bbuggu.manager.member.service.MemberService;
import co.bbuggu.manager.member.serviceImpl.MemberServiceImpl;
import co.bbuggu.manager.member.vo.MemberVO;

public class UserMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memdao = new MemberServiceImpl();
	private BoardService bodao = new BoardServiceImpl();

	private void title() {
		System.out.println("πΈπΉπΈπΉπΈπΉπΈπΉπΈπΉπΈπΉπΈ");
		System.out.println("πΈπΉπΈ μ¬μ©μ λ©λ΄ πΈπΉπΈπΉ");
		System.out.println("πΉπΈ 1. λμ μ λ³΄μμ  πΉπΈ");
		System.out.println("πΈπΉ 2. κ²μκΈ λ³΄κΈ° πΈπΉπΈ");
		System.out.println("πΉπΈ 3. κ²μκΈ μμ± πΉπΈπΉ");
		System.out.println("πΈπΉ 4. κ²μκΈ μμ  πΈπΉπΈ");
		System.out.println("πΉπΈ 5. μ’     λ£ πΉπΈπΉ");
		System.out.println("πΈπΉπΈπΉπΈπΉπΈπΉπΈπΉπΈπΉπΈ");
	}

	private void userMenu(MemberVO vo) {
		System.out.println(vo.getName() + "λ, νμν©λλ€.");
		boolean b = false;
		do {
			title();
			int choice;
			switch (choice = sc.nextInt()) {
			case 1:
				userUpdate();
				break;
			case 2:
				boardSelect();
				break;
			case 3:
				boardInsert();
				break;
			case 4:
				boardUpdate(vo.getId());
				break;
			case 5:
				b = true;
				System.out.println("νλ‘κ·Έλ¨μ μ’λ£ν©λλ€.");
				break;
			}

		} while (!b);
	}

	private void userUpdate() {
		// TODO λμ μ λ³΄ μμ 
		MemberVO vo = new MemberVO();
		System.out.println("ID > ");
		vo.setId(sc.next());
		sc.nextLine();
		System.out.println("ADDRESS > ");
		vo.setAddress(sc.nextLine());
		System.out.println("TEL > ");
		vo.setTel(sc.next());
		int n = memdao.membmerUpdate(vo);
		if (n != 0) {
			System.out.println("μ λ³΄κ° μμ λμμ΅λλ€.");
		} else {
			System.out.println("μ λ³΄ μμ  μ€ν¨");
		}
	}

	private void boardSelect() {
		// TODO κ²μκΈ λ³΄κΈ°
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = bodao.boardSelectList();
		for (BoardVO vo : list) {
			vo.toString();
		}

	}

	private void boardInsert() {
		// TODO κ²μκΈ μμ±
		BoardVO vo = new BoardVO();
		System.out.println("ID >");
		vo.setBoardid(sc.next());
		sc.nextLine();
		System.out.println("TITLE > ");
		vo.setTitle(sc.nextLine());
		System.out.println("SUBJECT > ");
		vo.setSubject(sc.nextLine());
		System.out.println("WRITER");
		vo.setWriter(sc.next());
		int n = bodao.boardInsert(vo);
		if (n != 0) {
			System.out.println("κΈ μμ± μλ£.");
		} else {
			System.out.println("κΈ μμ± μ€ν¨.");
		}

	}

	private void boardUpdate(String id) {
		// TODO κ²μκΈ μμ 
		BoardVO vo = new BoardVO();
		System.out.println("ID > ");
		String boardid = sc.next();
		sc.nextLine();
		vo.setBoardid(boardid);
		vo = bodao.boardSelect(vo);
		if (vo.getWriter().equals(id)) {
			vo = new BoardVO();
			System.out.println("SUBJECT >");
			vo.setSubject(sc.nextLine());
			vo.setWriter(id);
			vo.setBoardid(boardid);
			int n = bodao.boardUpdate(vo);
			if (n != 0) {
				System.out.println("μμ  μλ£");
			} else {
				System.out.println("μμ  μ€ν¨");
			}
		} else {
			System.out.println("λ³ΈμΈμ κΈλ§ μμ  κ°λ₯ν©λλ€.");
			vo.toString();
		}
	}

	public void run(MemberVO vo) {
		userMenu(vo);

	}
}
