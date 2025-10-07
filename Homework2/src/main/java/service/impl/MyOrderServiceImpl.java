package service.impl;

import dao.impl.MyOrderDaoImpl;
import model.MyOrder;
import service.MyOrderService;

public class MyOrderServiceImpl implements MyOrderService {
	
	private MyOrderDaoImpl odi = new MyOrderDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createOrder(MyOrder order) {
		// TODO Auto-generated method stub
		odi.insert(order);
	}

	@Override
	public MyOrder readOrderById(int id) {
		// TODO Auto-generated method stub
		return odi.selectOrderById(id);
	}

	@Override
	public void updateOrder(MyOrder order) {
		// TODO Auto-generated method stub
		odi.update(order);
	}

	@Override
	public void deleteOrderById(int id) {
		// TODO Auto-generated method stub
		odi.delete(id);
	}

}
