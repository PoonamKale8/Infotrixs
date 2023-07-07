package ems1;

import java.io.Serializable;

public class employee implements Serializable{
	int empid;
	String ename;
	int salary;
	
	employee(int empid, String ename, int salary){
		this.empid=empid;
		this.ename=ename;
		this.salary=salary;
		
	}
	public String toString() {
		return empid+" "+ename+" "+salary;
	}
}
