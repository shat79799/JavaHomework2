package service;

import model.MyOrder;

public interface MyOrderService {
	
	void createOrder(MyOrder order);
	
	MyOrder readOrderById(int id);
	
	void updateOrder(MyOrder order);
	
	void deleteOrderById(int id);

}
