package service;

import model.MyMember;

public interface MyMemberService {
	
	boolean registerIfNotExist(MyMember member);

	MyMember login(String username, String password);
	
}
