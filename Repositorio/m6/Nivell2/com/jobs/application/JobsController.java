package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Junior;
import com.jobs.domain.Mid;
import com.jobs.domain.Senior;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		repository=new EmployeeRepository();
	}
	
	// Exceptions to check the limits of salary have been implemented here because 
	// Categories are manage in this class and they are not known in employee class 
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		if (salaryPerMonth<=8000) throw new Exception();
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}
	
	public void createJunior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		if (salaryPerMonth<=900 || salaryPerMonth>=1600) throw new Exception();
		Junior junior = new Junior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateJunior());
		repository.addMember(junior);
	}
	
	public void createMid(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		if (salaryPerMonth<=1800 || salaryPerMonth>=2500) throw new Exception();
		Mid mid = new Mid(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateMid());
		repository.addMember(mid);
	}
	
	public void createSenior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		if (salaryPerMonth<=2700 || salaryPerMonth>=4000) throw new Exception();
		Senior senior = new Senior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateSenior());
		repository.addMember(senior);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		if (salaryPerMonth<=3000 || salaryPerMonth>=5000) throw new Exception();
		Employee manager= new Employee(name,address,phone,salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	public void payAllEmployeers() {
		List<AbsStaffMember> list_all_members=repository.getAllMembers();
		
		for(AbsStaffMember member:list_all_members) {
			member.pay();
		}
	}

	public String getAllEmployees() {
		String all_employees_str="";
		List<AbsStaffMember> list_all_members=repository.getAllMembers();
		
		for(AbsStaffMember member:list_all_members) {
				all_employees_str+=member.toString()+"\n";
		}
		
		return all_employees_str;
	}

	public void createVolunteer(String name, String address, String phone) throws Exception{
		Volunteer volunteer= new Volunteer(name,address,phone,"No cobra");
		repository.addMember(volunteer);	
	}
	
	
	
}
