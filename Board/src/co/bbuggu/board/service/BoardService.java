package co.bbuggu.board.service;

import java.sql.Date;
import java.util.List;

import co.bbuggu.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();	
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardDelete(BoardVO vo);

}
