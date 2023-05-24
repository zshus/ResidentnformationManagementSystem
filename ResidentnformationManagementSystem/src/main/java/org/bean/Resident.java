package org.bean;

public class Resident {
	private int s_id;
	private String s_name;
	private String s_tel;
	private int s_grade;
	private String s_class;
	
	public Resident() {}
	
	public Resident(int s_id) {
		this.s_id=s_id;
	}

	public Resident(int s_id, String s_name, String s_tel, int s_grade, String s_class) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_tel = s_tel;
		this.s_grade = s_grade;
		this.s_class = s_class;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_tel() {
		return s_tel;
	}

	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}

	public int getS_grade() {
		return s_grade;
	}

	public void setS_grade(int s_grade) {
		this.s_grade = s_grade;
	}

	public String getS_class() {
		return s_class;
	}

	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null||!(o instanceof Resident)) {
			return false;
		}
		Resident other=(Resident)o;
		return s_id==other.getS_id();
	}

}
