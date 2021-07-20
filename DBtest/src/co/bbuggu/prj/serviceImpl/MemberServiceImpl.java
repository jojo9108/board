package co.bbuggu.prj.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.bbuggu.prj.DAO;
import co.bbuggu.prj.service.MemberService;
import co.bbuggu.prj.vo.MemberVO;

//									   ⬇⬇ 상속 Connection
public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql); // psmt 초기화
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO(); // vo 객체 초기화
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAge(rs.getInt("age"));
				members.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "select * from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO 데이터 삽입
		int n = 0;
		String sql = "insert into member values(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setInt(6, vo.getAge());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO 데이터 수정
		int n = 0;
		String sql = "update member set address = ?, tel = ?, name = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getAddress());
			psmt.setString(2, vo.getTel());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO 데이터 삭제
		int n = 0;
		String sql = "delete from member where id = ?"; // id가 유일한 key (primary key <- PK)
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
