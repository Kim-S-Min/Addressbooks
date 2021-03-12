package com.java.addressbook;

public class Field {	
	private String name;
	private String num;
	private String tel;

	
	public Field(String name, String num, String tel) {
		this.name = name;
		this.num = num;
		this.tel = tel;
		
		
	}
	public String getName() {
		return name;
		
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
