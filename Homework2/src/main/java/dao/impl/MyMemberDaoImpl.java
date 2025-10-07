package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MyMemberDao;
import model.MyMember;
import util.DbConnection;

public class MyMemberDaoImpl implements MyMemberDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static Connection c = DbConnection.getDb();

	@Override
	public void insert(MyMember member) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO mymember(name, username, password, address, phone) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert failed!");
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean selectUsername(String username) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "SELECT * FROM mymember WHERE username = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select failed!");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public MyMember selectMemberByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		MyMember m = null;
		String sql = "SELECT * FROM mymember WHERE username = ? AND password = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				m = new MyMember();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public void update(String name, String password, int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE mymember SET name = ?, password = ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("update failed!");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM mymember WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("delete failed!");
			e.printStackTrace();
		}
	}

}
