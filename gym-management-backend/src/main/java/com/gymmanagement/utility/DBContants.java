package com.gymmanagement.utility;

public class DBContants {
	
	public enum PackageName {
		MONTHLY("Monthly"),
		QUARTERLY("Quarterly"),
		SEMI_ANNUALLY("Semi-Annually"),
		ANUALLY("Anually");
		
		private String status;

	    private PackageName(String status) {
	      this.status = status;
	    }

	    public String value() {
	      return this.status;
	    }

	    public boolean equals(String status) {
	      return this.status.equals(status.toUpperCase());
	    }
	}
	
	public enum IsPresent {
		YES("Yes"),
		NO("No");
		
		private String status;

	    private IsPresent(String status) {
	      this.status = status;
	    }

	    public String value() {
	      return this.status;
	    }

	    public boolean equals(String status) {
	      return this.status.equals(status.toUpperCase());
	    }
	}
	
	public enum Sex {
		MALE("Male"),
		FEMALE("Female");
		
		private String sex;

	    private Sex(String sex) {
	      this.sex = sex;
	    }

	    public String value() {
	      return this.sex;
	    }

	    public boolean equals(String sex) {
	      return this.sex.equals(sex.toUpperCase());
	    }
	}
	
	public enum IsPaymentDone{
		YES("Yes"),
		NO("No");
		
		private String status;

	    private IsPaymentDone(String status) {
	      this.status = status;
	    }

	    public String value() {
	      return this.status;
	    }

	    public boolean equals(String status) {
	      return this.status.equals(status.toUpperCase());
	    }
	}

}
