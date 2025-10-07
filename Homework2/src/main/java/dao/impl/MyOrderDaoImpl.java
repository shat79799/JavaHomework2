package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MyOrderDao;
import model.MyOrder;
import util.DbConnection;

public class MyOrderDaoImpl implements MyOrderDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static Connection c = DbConnection.getDb();

	@Override
	public void insert(MyOrder order) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO myorder(blackTea, greenTea, oolongTea, milkTea, userId) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, order.getBlackTea());
			ps.setInt(2, order.getGreenTea());
			ps.setInt(3, order.getOolongTea());
			ps.setInt(4, order.getMilkTea());
			ps.setInt(5, order.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert failed!");
			e.printStackTrace();
		}
	}

	@Override
	public MyOrder selectOrderById(int id) {
		// TODO Auto-generated method stub
		MyOrder o = null;
		String sql = "SELECT * FROM myorder WHERE id = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				o = new MyOrder();
				o.setId(rs.getInt("id"));
				o.setBlackTea(rs.getInt("blackTea"));
				o.setGreenTea(rs.getInt("greenTea"));
				o.setOolongTea(rs.getInt("oolongTea"));
				o.setMilkTea(rs.getInt("milkTea"));
				o.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}

	@Override
	public void update(MyOrder order) {
		// TODO Auto-generated method stub
		String sql = "UPDATE myorder SET blackTea = ?, greenTea = ?, oolongTea = ?, milkTea = ?, userId = ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, order.getBlackTea());
			ps.setInt(2, order.getGreenTea());
			ps.setInt(3, order.getOolongTea());
			ps.setInt(4, order.getMilkTea());
			ps.setInt(5, order.getUserId());
			ps.setInt(6, order.getId());
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
		String sql = "DELETE FROM myorder WHERE id = ?";
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
