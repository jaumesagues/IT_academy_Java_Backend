package com.jobs.domain;

public class Senior extends Employee {
	
	public Senior(String name, String address, String phone, double salaryPerMonth, 
			IPaymentRate paymentRate, double IRPF_percent) throws Exception {
		super(name, address, phone,salaryPerMonth,paymentRate,IRPF_percent);
	}

	@Override
	public String toString() {
		return "Senior [name=" + name + ", address=" + address + ", phone=" + phone + ", IRPF_percent=" + IRPF_percent
				+ ", totalPaidGrossMonth=" + totalPaidGrossMonth + ", totalPaidNetMonth=" + totalPaidNetMonth
				+ ", totalPaidGrossAnnual=" + totalPaidGrossAnnual + ", totalPaidNetAnnual=" + totalPaidNetAnnual + "]";
	}
	
}
