package com.jobs.domain;

public class Mid extends Employee {
	
	public Mid(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone,salaryPerMonth,paymentRate);
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
	}
	
	@Override
	public String toString() {
		return "Mid [name = " + super.name + " address: " + super.address + " phone: " + super.phone + " salary/month: " + salaryPerMonth + " total paid/month: " + super.totalPaidMonth + "]\n";
	}
}
