package co.bbuggu.manager;

//import java.awt.Menu;
//import java.util.ArrayList;
//import java.util.List;
//
//import co.bbuggu.manager.member.service.MemberService;
//import co.bbuggu.manager.member.serviceImpl.MemberServiceImpl;
//import co.bbuggu.manager.member.vo.MemberVO;
import co.bbuggu.manager.menu.LoginMenu;

public class MainApp {
	public static void main(String[] args) {
//		MemberService memberDao = new MemberServiceImpl();
//		List<MemberVO> members = new ArrayList<MemberVO>();
//		
//		members = memberDao.memberSelectList();
//		for(MemberVO vo : members) {
//			vo.toString();
//		}
		
		LoginMenu menu = new LoginMenu();
		menu.login();
		
	}
}
