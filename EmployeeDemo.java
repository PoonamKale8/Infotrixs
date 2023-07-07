package ems1;

import java.io.*;
import java.util.*;

public class EmployeeDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int choice = -1;
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		
		ArrayList<employee> al = new ArrayList<employee>();
		File f=new File("employee.txt");
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		ListIterator li=null;
		
		if(f.isFile()) {
			ois=new  ObjectInputStream(new FileInputStream(f));
			al=(ArrayList<employee>)ois.readObject();
			ois.close();
		}
		
		do {
			System.out.println("-------------------------------------------");
			System.out.println("1. INSERT");
			System.out.println("2. DISPLAY");
			System.out.println("3. SEARCH");
			System.out.println("4. DELETE");
			System.out.println("5. UPDATE");
			System.out.println("6. SORT DATA");
			System.out.println("0. EXIT");
			System.out.println("-------------------------------------------");

			System.out.println("Enter Your Choice:");
			
			choice = s.nextInt();
			switch(choice) {
				case 1:
					System.out.println("-------------------------------------------");
					System.out.println("Enter How Many Employee You Want:");
					
					System.out.println("-------------------------------------------");

					int n=s.nextInt();
					for(int i=0;i<n;i++) {
						System.out.print("Enter Employee ID : ");
						int empid=s.nextInt();
						System.out.print("Enter Employee NAME : ");
						String ename=s1.nextLine();
						System.out.print("Enter Employee SALARY : ");
						int salary=s.nextInt();
						al.add(new employee(empid,ename,salary));
					}
					oos=new ObjectOutputStream(new FileOutputStream(f));
					oos.writeObject(al);
					oos.close();
					break;
				case 2:
					if(f.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(f));
						al = (ArrayList<employee>)ois.readObject();
						ois.close();
						
						System.out.println("-------------------------------------------");
						li=al.listIterator();
						while(li.hasNext())
							System.out.println(li.next());
						System.out.println("-------------------------------------------");
						}
					else {
						System.out.println("File Not Exists....!");
					}
					break;
				case 3:
					if(f.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(f));
						al = (ArrayList<employee>)ois.readObject();
						ois.close();
						
						boolean found=false;
						System.out.println("Enter Employee ID to SEARCH: ");
						int empid = s.nextInt();
						System.out.println("-------------------------------------------");

						li=al.listIterator();
						while(li.hasNext()) {
							employee e =(employee)li.next();
							if(e.empid == empid) {
								System.out.println(e);
								found=true;
							}
						}
						if(!found)
							System.out.println("Record Not Found....!");
						System.out.println("-------------------------------------------");
					}
					else {
						System.out.println("File Not Exists....!");
					}
					break;
				case 4:
					if(f.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(f));
						al = (ArrayList<employee>)ois.readObject();
						ois.close();
						
						boolean found=false;
						System.out.print("Enter Employee ID to DELETE: ");
						int empid = s.nextInt();
						System.out.println("-------------------------------------------");

						li=al.listIterator();
						while(li.hasNext()) {
							employee e =(employee)li.next();
							if(e.empid == empid) {
								System.out.println(e);
								li.remove();
								found=true;
							}
						}
						if(found)
						{
							oos=new ObjectOutputStream(new FileOutputStream(f));
							oos.writeObject(al);
							oos.close();
							System.out.println("Record Deleted Successfully....! ");

						}
						else{
							System.out.println("Record Not Found....!");
						}
						System.out.println("-------------------------------------------");
					}
					else {
						System.out.println("File Not Exists....!");
					}
					break;
				case 5:
					if(f.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(f));
						al = (ArrayList<employee>)ois.readObject();
						ois.close();
						boolean found=false;
						System.out.print("Enter Employee ID to UPDATE : ");
						int empid = s.nextInt();
						System.out.println("-------------------------------------------");

						li=al.listIterator();
						while(li.hasNext()) {
							employee e =(employee)li.next();
							if(e.empid == empid) {
								System.out.println("Enter New Employee Name :");
								String ename = s1.nextLine();
								
								System.out.println("Enter New Salary :");
								int salary = s.nextInt();
								
								li.set(new employee(empid,ename,salary));
								found=true;
							}
						}
						if(found)
						{
							oos=new ObjectOutputStream(new FileOutputStream(f));
							oos.writeObject(al);
							oos.close();
							System.out.println("Record Updated Successfully....! ");

						}
						else{
							System.out.println("Record Not Found....!");
						}
						System.out.println("-------------------------------------------");
					}
					else {
						System.out.println("File Not Exists....!");
					}
					break;
				case 6:
					if(f.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(f));
						al = (ArrayList<employee>)ois.readObject();
						ois.close();
						
						Collections.sort(al, new Comparator<employee>() {
							public int compare(employee e1, employee e2) {
								return e1.empid - e2.empid;
							}
						});
						
						oos = new ObjectOutputStream(new FileOutputStream(f));
						oos.writeObject(al);
						oos.close();
						
						System.out.println("-------------------------------------------");
						li=al.listIterator();
						while(li.hasNext())
							System.out.println(li.next());
						System.out.println("-------------------------------------------");
						}
					else {
						System.out.println("File Not Exists....!");
					}
					break;
			}
		}while(choice!=0);
	}
}
