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
		System.out.println("🔸🔹🔸🔹🔸🔹🔸🔹🔸🔹🔸🔹🔸");
		System.out.println("🔸🔹🔸 사용자 메뉴 🔸🔹🔸🔹");
		System.out.println("🔹🔸 1. 나의 정보수정 🔹🔸");
		System.out.println("🔸🔹 2. 게시글 보기 🔸🔹🔸");
		System.out.println("🔹🔸 3. 게시글 작성 🔹🔸🔹");
		System.out.println("🔸🔹 4. 게시글 수정 🔸🔹🔸");
		System.out.println("🔹🔸 5. 종     료 🔹🔸🔹");
		System.out.println("🔸🔹🔸🔹🔸🔹🔸🔹🔸🔹🔸🔹🔸");
	}

	private void userMenu(MemberVO vo) {
		System.out.println(vo.getName() + "님, 환영합니다.");
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
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		} while (!b);
	}

	private void userUpdate() {
		// TODO 나의 정보 수정
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
			System.out.println("정보가 수정되었습니다.");
		} else {
			System.out.println("정보 수정 실패");
		}
	}

	private void boardSelect() {
		// TODO 게시글 보기
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = bodao.boardSelectList();
		for (BoardVO vo : list) {
			vo.toString();
		}

	}

	private void boardInsert() {
		// TODO 게시글 작성
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
			System.out.println("글 작성 완료.");
		} else {
			System.out.println("글 작성 실패.");
		}

	}

	private void boardUpdate(String id) {
		// TODO 게시글 수정
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
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		} else {
			System.out.println("본인의 글만 수정 가능합니다.");
			vo.toString();
		}
	}

	public void run(MemberVO vo) {
		userMenu(vo);

	}
}
