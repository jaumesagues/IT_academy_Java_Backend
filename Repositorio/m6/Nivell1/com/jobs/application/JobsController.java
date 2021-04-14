package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		repository=new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
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
