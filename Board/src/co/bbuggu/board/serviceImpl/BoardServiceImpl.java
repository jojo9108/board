package co.bbuggu.board.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.bbuggu.board.dao.DAO;
import co.bbuggu.board.service.BoardService;
import co.bbuggu.board.vo.BoardVO;

public class BoardServiceImpl extends DAO implements BoardService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> boardSelectList() {
		List<BoardVO> boards = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "select * from board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardId(rs.getString("boardId"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));				
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setHit(rs.getInt("hit"));
				boards.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO 글 조회
		String sql = "select subject from board where boardid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setSubject(rs.getString("subject"));
				hitUpdate(vo.getBoardId());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO 글 쓰기
		int n = 0;
		String sql = "insert into board(boardid,writer,title,subject) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardId());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getSubject());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO 글 삭제
		int n = 0;
		String sql = "delete from board where boardid = ?"; // id가 유일한 key (primary key <- PK)
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	private void hitUpdate(String boardId) {
		String sql = "update board set hit = hit + 1 where boardid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boardId);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
