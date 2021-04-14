package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;
	protected double IRPF_percent;

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate, double IRPF_percent) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(IRPF_percent<0.0 || IRPF_percent>1.0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
		this.IRPF_percent=IRPF_percent;
	}

	@Override
	public void pay() {
		totalPaidGrossMonth=paymentRate.pay(salaryPerMonth);
		totalPaidGrossAnnual=totalPaidGrossMonth*14;
		totalPaidNetMonth=totalPaidGrossMonth*(1.0-IRPF_percent);
		totalPaidNetAnnual=totalPaidNetMonth*14;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", phone=" + phone + ", totalPaidGrossMonth="
				+ totalPaidGrossMonth + ", totalPaidNetMonth=" + totalPaidNetMonth + ", totalPaidGrossAnnual="
				+ totalPaidGrossAnnual + ", totalPaidNetAnnual=" + totalPaidNetAnnual + ", IRPF_percent=" + IRPF_percent
				+ "]";
	}

	

}
