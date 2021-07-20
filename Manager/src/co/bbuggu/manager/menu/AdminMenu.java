package co.bbuggu.manager.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.bbuggu.manager.board.service.BoardService;
import co.bbuggu.manager.board.serviceImpl.BoardServiceImpl;
import co.bbuggu.manager.board.vo.BoardVO;
import co.bbuggu.manager.member.service.MemberService;
import co.bbuggu.manager.member.serviceImpl.MemberServiceImpl;
import co.bbuggu.manager.member.vo.MemberVO;

public class AdminMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memdao = new MemberServiceImpl();
	private BoardService bodao = new BoardServiceImpl();

	private void title() {
		System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 관리자 메뉴 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗ 1. 사용자 관리 ❗❗❗❗❗");
		System.out.println("❗❗❗❗❗ 2. 게시판 관리 ❗❗❗❗❗");
		System.out.println("❗❗❗❗❗ 3. 종     료 ❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
		System.out.println("원하는 작업을 선택해 주세요");

	}

	private void adminMenu(MemberVO vo) {
		System.out.println(vo.getName() + "관리자님, 환영합니다");
		boolean b = false;
		do {
			title(); // 주메뉴 출력
			int choice;
			switch (choice = sc.nextInt()) {
			case 1:
				userManager();
				break;
			case 2:
				boardManager();
				break;
			case 3:
				b = true;
				System.out.println("작업종료.");
				break;

			}
		} while (!b);
	}

	private void userManager() {
		// TODO 사용자 관리
		boolean b = false;
		do {
			int chk;
			subMemberTitle(); // 사용자 메뉴 호출
			switch (chk = sc.nextInt()) {
			case 1:
				memberSelectList(); // 멤버목록 조회
				break;
			case 2:
				sc.nextLine();
				memberSelect(); // 멤버 조회
				break;
			case 3:
				sc.nextLine();
				memberDelete(); // 멤버 삭제
				break;
			case 4:
				b = true;
				System.out.println("목록으로 돌아갑니다.");
				break;
			}
		} while (!b);

	}

	private void boardManager() {
		// TODO 게시판 관리
		boolean b = false;
		do {
			int chk;
			subBoardTitle();
			switch (chk = sc.nextInt()) {
			case 1:
				boardSelectList(); // 글 목록 조회
				break;
			case 2:
				boardInsert(); // 글 쓰기
				break;
			case 3:
				boardUpdate(); // 글 수정
				break;
			case 4:
				boardDelete(); // 글 삭제
				break;
			case 5:
				b = true;
				System.out.println("목록으로 돌아갑니다.");
				break;
			}
		} while (!b);
	}

	private void subMemberTitle() {
		System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 사용자 관리 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗ 1. 멤버 정보 목록 ❗❗❗");
		System.out.println("❗❗❗ 2. 멤버 정보 조회 ❗❗❗");
		System.out.println("❗❗❗ 3. 멤버 정보 삭제 ❗❗❗");
		System.out.println("❗❗❗❗❗❗ 4. 돌아가기 ❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
		System.out.println("원하는 작업을 선택해 주세요");
	}

	private void memberSelectList() {
		// TODO 멤버 목록 조회
		System.out.println("🌺 사용자 목록 🌺");
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = memdao.memberSelectList();
		for (MemberVO member : members) {
			member.toString();
		}
	}

	public void run(MemberVO vo) {
		adminMenu(vo);
	}

	private void memberSelect() {
		// TODO 멤버 조회
		MemberVO member = new MemberVO();
		System.out.println("검색할 ID를 입력하세요");
		member.setId(sc.nextLine());

		member = memdao.memberSelect(member);

		member.toString();
	}

	private void memberDelete() {
		// TODO 멤버 삭제
		MemberVO member = new MemberVO();
		System.out.println("삭제할 ID를 입력하세요");
		member.setId(sc.nextLine());
		int n = memdao.memberDelete(member);
		if (n != 0) {
			System.out.println("정상 처리되었습니다.");
		} else {
			System.out.println("처리에 실패하였습니다.");
		}
	}

	private void subBoardTitle() {
		System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 게시판 관리 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 1. 글 목록 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 2. 글 쓰기 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 3. 글 수정 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 4. 글 삭제 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗ 5. 돌아가기 ❗❗❗❗❗❗❗");
		System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
		System.out.println("원하는 작업을 선택해 주세요");
	}

	private void boardSelectList() {
		// TODO 글 목록 조회
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = bodao.boardSelectList();
		for (BoardVO vo : list) {
			vo.toString();
		}
	}

	private void boardInsert() {
		// TODO 글 쓰기
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

	private void boardUpdate() {
		// TODO 글 수정
		BoardVO vo = new BoardVO();
		System.out.println("ID > ");
		vo.setBoardid(sc.next());
		sc.nextLine();
		System.out.println("SUBJECT >");
		vo.setSubject(sc.nextLine());
	
		int n = bodao.boardUpdate(vo);
		if (n != 0) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
	}

	private void boardDelete() {
		// TODO 글 삭제
		BoardVO vo = new BoardVO();
		System.out.println("삭제할 ID를 입력하세요");
		vo.setBoardid(sc.next());
		int n = bodao.boardDelete(vo);
		if (n != 0) {
			System.out.println("정상 처리되었습니다.");
		} else {
			System.out.println("처리에 실패하였습니다.");
		}
	}
}
