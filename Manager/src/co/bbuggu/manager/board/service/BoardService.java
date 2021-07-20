package co.bbuggu.manager.board.service;

import java.util.List;

import co.bbuggu.manager.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList(); // 게시글 목록
	BoardVO boardSelect(BoardVO vo); // 회원 조회
	int boardInsert(BoardVO vo);     // 회원 추가
	int boardDelete(BoardVO vo);     // 회원 삭제
	int boardUpdate(BoardVO vo);     // 회원 수정
}
