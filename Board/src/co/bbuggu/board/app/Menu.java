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
		System.out.println("ππππππππππ");
		System.out.println("1.κΈ μ‘°ν | 2.κΈ μμ± | 3. κΈ μ­μ  | 4. μ’λ£");
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
				System.out.println("EXITπββοΈ");
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
		// TODO κΈ μ‘°ν
		BoardVO vo = new BoardVO();
		System.out.println("μ‘°ννμ€ κΈ λ²νΈλ₯Ό μ ννμΈμ");
		vo.setBoardId(sc.next());
		sc.nextLine();
		vo = dao.boardSelect(vo);
		System.out.println(vo.getSubject());

	}

	private void boardInsert() {
		// TODO κΈ μμ±
		BoardVO vo = new BoardVO();
		System.out.println("λ²νΈ > ");
		vo.setBoardId(sc.next());
		sc.nextLine();
		System.out.println("μμ±μ > ");
		vo.setWriter(sc.nextLine());
		sc.nextLine();
		System.out.println("μ λͺ© > ");
		vo.setTitle(sc.nextLine());
		sc.nextLine();
		System.out.println("λ΄μ© > ");
		vo.setSubject(sc.nextLine());	
		int n = dao.boardInsert(vo);
		if (n != 0) {
			System.out.println("κΈ λ±λ‘ μλ£");
		} else {
			System.out.println("κΈ λ±λ‘ μ€ν¨");
		}

	}

	private void boardDelete() {
		// TODO κΈ μ­μ 
		BoardVO vo = new BoardVO();
		System.out.println("μ­μ νμ€ IDλ₯Ό μλ ₯νμΈμ");
		vo.setBoardId(sc.next());
		int n = dao.boardDelete(vo);
		if (n != 0) {
			System.out.println("κΈ μ­μ  μλ£");
		} else {
			System.out.println("κΈ μ­μ  μ€ν¨");
		}
		
	}

	public void run() {
		mainMenu();
		sc.close();
		
	}
}
