package dao;

import model.MyOrder;

public interface MyOrderDao {

	void insert(MyOrder order);
	
	MyOrder selectOrderById(int id);
	
	void update(MyOrder order);
	
	void delete(int id);
	
}
