package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.MyMember;
import model.MyOrder;

public class Tool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void saveMyMember(MyMember member) {
		try {
			FileOutputStream fos = new FileOutputStream("MyMember.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(member);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MyMember readMyMember() {
		MyMember m = null;
		
		try {
			FileInputStream fis = new FileInputStream("MyMember.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			m = (MyMember)ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public static void saveMyOrder(MyOrder order) {
		try {
			FileOutputStream fos = new FileOutputStream("MyOrder.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(order);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MyOrder readMyOrder() {
		MyOrder o = null;
		
		try {
			FileInputStream fis = new FileInputStream("MyOrder.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = (MyOrder)ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}

}
