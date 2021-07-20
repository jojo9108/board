package co.bbuggu.board.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.bbuggu.board.service.BoardService;
import co.bbuggu.board.serviceImpl.BoardServiceImpl;
import co.bbuggu.board.vo.BoardVO;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private BoardService dao = new BoardServiceImpl();

	private void menuTitle() {
		boardSelectList();
		System.out.println("🖋🖋🖋🖋🖋🖋🖋🖋🖋🖋");
		System.out.println("1.글 조회 | 2.글 작성 | 3. 글 삭제 | 4. 종료");
}
	private void mainMenu() {
		int text;
		boolean b = false;

		do {
			menuTitle();
			switch (text = sc.nextInt()) {

			case 1:
				boardSelect();
				break;
			case 2:
				boardInsert();
				break;
			case 3:
				boardDelete();
				break;
			case 4:
				b = true;
				System.out.println("EXIT🏃‍♂️");
				break;
			}
		} while (!b);
	}

	private void boardSelectList() {
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = dao.boardSelectList();
		for (BoardVO board : boards) {
		System.out.println(board.toString());
		}
	}

	private void boardSelect() {
		// TODO 글 조회
		BoardVO vo = new BoardVO();
		System.out.println("조회하실 글 번호를 선택하세요");
		vo.setBoardId(sc.next());
		sc.nextLine();
		vo = dao.boardSelect(vo);
		System.out.println(vo.getSubject());

	}

	private void boardInsert() {
		// TODO 글 작성
		BoardVO vo = new BoardVO();
		System.out.println("번호 > ");
		vo.setBoardId(sc.next());
		sc.nextLine();
		System.out.println("작성자 > ");
		vo.setWriter(sc.nextLine());
		sc.nextLine();
		System.out.println("제목 > ");
		vo.setTitle(sc.nextLine());
		sc.nextLine();
		System.out.println("내용 > ");
		vo.setSubject(sc.nextLine());	
		int n = dao.boardInsert(vo);
		if (n != 0) {
			System.out.println("글 등록 완료");
		} else {
			System.out.println("글 등록 실패");
		}

	}

	private void boardDelete() {
		// TODO 글 삭제
		BoardVO vo = new BoardVO();
		System.out.println("삭제하실 ID를 입력하세요");
		vo.setBoardId(sc.next());
		int n = dao.boardDelete(vo);
		if (n != 0) {
			System.out.println("글 삭제 완료");
		} else {
			System.out.println("글 삭제 실패");
		}
		
	}

	public void run() {
		mainMenu();
		sc.close();
		
	}
}
