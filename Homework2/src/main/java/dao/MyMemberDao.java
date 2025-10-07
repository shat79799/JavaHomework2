package dao;

import model.MyMember;

public interface MyMemberDao {
	
	void insert(MyMember member);
	
	boolean selectUsername(String username);
	MyMember selectMemberByUsernameAndPassword(String username, String password);
	
	void update(String name, String password, int id);
	
	void delete(int id);

}
