package Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Scanner;

class Employee implements Serializable
{
	int id;
	String name;
	String address;
	float salary;
	long contactno;
	String emailid;
	String dob;
	
	public Employee(int id, String name, String address,float salary,long contactno,String emailid, String dob2 ) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary=salary;
		this.contactno=contactno;
		this.emailid=emailid;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", contactno="
				+ contactno + ", emailid=" + emailid + ", dob=" + dob + "]";
	}
	
}
public class EmployeeManagement {
	static void display1(ArrayList<Employee> al)
	{
		System.out.println("\n    ---------------Employee List------------   \n");
		System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s","ID","Name","Address","Salary","ContactNo","DOB"));
		for(Employee e:al)
		{
		System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s",e.id,e.name,e.address,e.salary,e.contactno,e.emailid,e.dob));
		}
	}
	
	

	public static void main(String[] args)  {
		
		int id;
		String name;
		String address;
		float salary;
		long contactno;
		String emailid;
		String dob;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n     ---------------  Employee Details  ------------------\n");
		ArrayList<Employee> al=new ArrayList<Employee>();
		
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		try {
			f=new File("6269-Employee Management System1/src/Employee/src/Employee/Employee Management");
					if(f.exists())
					{
						fis= new FileInputStream(f);
						ois= new ObjectInputStream(fis);
						al=(ArrayList<Employee>)ois.readObject();
					}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		do
		{
		
		System.out.println("*\n*********Welcome to the employee management System ********\n");
		
		System.out.println("1).Add Employee to the DataBase \n"+
		                   "2).sreach for Employee\n"+
				           "3).Edit Employee Details\n"+
		                   "4).Delete Employee Details\n"+
		                   "5).Display all Employee Working in this Company\n"+
		                   "6).Exit\n");
		System.out.println("Enter your Choice: ");
		int ch=sc.nextInt();
		
		switch(ch){
		case 1:System.out.println("\n Enter the Following details to ADD list: \n");
		
		System.out.println("Enter ID :");
		id=sc.nextInt();
		System.out.println("Enter Name:");
		name=sc.next();
		System.out.println("Enter Address:");
		address=sc.next();
		System.out.println("Enter Salary:");
		salary=sc.nextFloat();
		System.out.println("Enter ContactNo:");
		contactno=sc.nextLong();
		System.out.println("Enter Emailid");
		emailid=sc.next();
		System.out.println("DOB");
		dob=sc.next();
		al.add(new Employee(id,name,address,salary,contactno,emailid,dob));
		display1(al);
		break;
		
		case 2:System.out.println("Enter the Employee ID to search:");
		id=sc.nextInt();
		int i=0;
		for(Employee e:al)
		{
			if(id==e.id)
			{
				System.out.println(e+"\n");
				i++;
			}
		}
		if(i==0)
		{
			System.out.println("\n Employee Details are not available,please enter a valid ID!!");
		}
		break;
		
		case 3:
			System.out.println("\n Enter the Employee ID to Edit the details");
			id=sc.nextInt();
			int j=0;
			for(Employee e:al)
			{
				if(id==e.id)
				{
					j++;
					do {
						int ch1=0;
						System.out.println("\nEDIT Employee Details :\n"+
						                   "1).Employee ID\n"+
								           "2).Name\n"+
						                   "3).Address\n"+
						                   "4).Salary\n"+
								           "5).ContactNo\n"+
						                   "6).Emailid\n"+
								           "7).DOB\n"+
								           "8)GO BACK\n");
						System.out.println("Enter your choice : ");
						ch1=sc.nextInt();
						switch(ch1)
						{
						case 1:
							System.out.println("\n Enter new Employee ID");
							e.id=sc.nextInt();
							System.out.println(e+"\n");
							break;
						case 2:
							System.out.println("\n Enter new Employee Name");
							e.name=sc.next();
							System.out.println(e+"\n");
							break;
						case 3:
							System.out.println("\n Enter new Employee Address");
							e.address=sc.next();
							System.out.println(e+"\n");
							break;
						case 4:
							System.out.println("\n Enter new Employee Salary");
							e.salary=sc.nextFloat();
							System.out.println(e+"\n");
							break;
						case 5:
							System.out.println("\n Enter new Employee ContactNo");
							e.contactno=sc.nextLong();
							System.out.println(e+"\n");
							break;
						case 6:
							System.out.println("\n Enter new Employee Emailid");
							e.emailid=sc.next();
							System.out.println(e+"\n");
							break;
						case 7:
							System.out.println("\n Enter new Employee Dob");
							e.dob=sc.next();
							System.out.println(e+"\n");
							break;
						case 8:
							j++;
							break;
							default :System.out.println("\n Enter a correct choice from the List :");
							break;
						}
					}
					while(j==1);
				}
			}
			if(j == 0)
			{
				System.out.println("\n Enter Details are not available,please enter a valid ID!!");
			}
			break;
		case 4:
			System.out.println("\n Enter Employee ID to DELETE from the Database:");
			id=sc.nextInt();
			int k=0;
			try {
				for(Employee e:al)
				{
					if(id==e.id)
					{
						al.remove(e);
						display1(al);
						k++;
					}
				}
				if(k ==0)
				{
					System.out.println("\nEmployee Details are not available,please enter a valid ID!!");
					
				
			
						}
					}
			catch(Exception e) {
				System.out.println(e);
			}
			break;
		case 5:
			try {
				al=(ArrayList<Employee>)ois.readObject();
			}
			catch(ClassNotFoundException e2)
			{
				System.out.println(e2);
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
			display1(al);
			break;
			
		case 6:try {
			
		
			fos=new FileOutputStream(f);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(al);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
			
		}
		finally
		{
			try {
				fis.close();
				ois.close();
				fos.close();
				oos.close();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("\n you have chosen Exit !! saving Files and closing the tool.");
		sc.close();
		System.exit(0);
		break;
		
		default: System.out.println("\n Enter a correct choice from the list :");
		break;
		}	
	
	}
 while(true);
	
		
	}
}

			
		
		
		
		
		
		

	

	
	


