package com.jobs.domain;

public class Mid extends Employee {
	
	public Mid(String name, String address, String phone, double salaryPerMonth, 
			IPaymentRate paymentRate, double IRPF_percent) throws Exception {
		super(name, address, phone,salaryPerMonth,paymentRate,IRPF_percent);
	}

	@Override
	public String toString() {
		return "Mid [name=" + name + ", address=" + address + ", phone=" + phone + ", IRPF_percent=" + IRPF_percent
				+ ", totalPaidGrossMonth=" + totalPaidGrossMonth + ", totalPaidNetMonth=" + totalPaidNetMonth
				+ ", totalPaidGrossAnnual=" + totalPaidGrossAnnual + ", totalPaidNetAnnual=" + totalPaidNetAnnual + "]";
	}
	
}
