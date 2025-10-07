package service.impl;

import dao.impl.MyMemberDaoImpl;
import model.MyMember;
import service.MyMemberService;

public class MyMemberServiceImpl implements MyMemberService {
	
	private MyMemberDaoImpl mdi = new MyMemberDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean registerIfNotExist(MyMember member) {
		// TODO Auto-generated method stub
		return !mdi.selectUsername(member.getUsername());
	}

	@Override
	public MyMember login(String username, String password) {
		// TODO Auto-generated method stub
		return mdi.selectMemberByUsernameAndPassword(username, password);
	}

}
