package model;

import java.io.Serializable;

public class MyOrder implements Serializable {
	
	private Integer id;
	private Integer blackTea;
	private Integer greenTea;
	private Integer oolongTea;
	private Integer milkTea;
	private Integer userId;
	
	public MyOrder() {
		super();
	}

	public MyOrder(Integer blackTea, Integer greenTea, Integer oolongTea, Integer milkTea, Integer userId) {
		super();
		this.blackTea = blackTea;
		this.greenTea = greenTea;
		this.oolongTea = oolongTea;
		this.milkTea = milkTea;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlackTea() {
		return blackTea;
	}

	public void setBlackTea(Integer blackTea) {
		this.blackTea = blackTea;
	}

	public Integer getGreenTea() {
		return greenTea;
	}

	public void setGreenTea(Integer greenTea) {
		this.greenTea = greenTea;
	}

	public Integer getOolongTea() {
		return oolongTea;
	}

	public void setOolongTea(Integer oolongTea) {
		this.oolongTea = oolongTea;
	}

	public Integer getMilkTea() {
		return milkTea;
	}

	public void setMilkTea(Integer milkTea) {
		this.milkTea = milkTea;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
