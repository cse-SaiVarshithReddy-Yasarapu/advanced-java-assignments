package junitdemo;

public class Student {
	private int id;
	private String name;
	private int mark1;
	private int mark2;
	private int mark3;
	public Student(int id, String name, int mark1, int mark2, int mark3) {
		super();
		this.id = id;
		this.name = name;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final int getMark1() {
		return mark1;
	}
	public final void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public final int getMark2() {
		return mark2;
	}
	public final void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public final int getMark3() {
		return mark3;
	}
	public final void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	
	
}
