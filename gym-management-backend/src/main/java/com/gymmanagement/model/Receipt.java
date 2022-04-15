package com.gymmanagement.model;

import lombok.Getter;
import lombok.Setter;

public class Receipt {
	
	private Customer customer;
	private PackageDetail packageDetail;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public PackageDetail getPackageDetail() {
		return packageDetail;
	}
	public void setPackageDetail(PackageDetail packageDetail) {
		this.packageDetail = packageDetail;
	}
	
	

}
