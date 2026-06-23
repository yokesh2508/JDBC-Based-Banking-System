package com.demo.BankDetails;

public class BankDetails {
       private String name;
       private String acc_type;
       private double balance;
       private long acc_id;
       private String phone;
       private java.util.Date createdAt;
       private java.util.Date updatedAt;

      public BankDetails(String name,String acc_type,double balance,long acc_id,String phone,java.util.Date createdAt,java.util.Date updatedAt)
      {
    	   super();
    	   this.name=name;
    	   this.acc_type=acc_type;
    	   this.balance=balance;
    	   this.acc_id=acc_id;
    	   this.setPhone(phone);
    	   this.setCreatedAt(createdAt);
    	   this.setUpdatedAt(updatedAt);
       }
       public BankDetails(String name,String acc_type,double balance,String phone) {
    	   super();
    	   this.name=name;
    	   this.acc_type=acc_type;
    	   this.balance=balance;
    	   this.phone=phone;
       }

	   public String getName() {
		return name;
	   }

	   public void setName(String name) {
		this.name = name;
	   }

	   public String getAcc_type() {
		return acc_type;
	   }

	   public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	   }

	   public double getBalance() {
		return balance;
	   }

	   public void setBalance(double balance) {
		this.balance = balance;
	   }

	   public long getAcc_id() {
		return acc_id;
	   }

	   public void setAcc_id(long acc_id) {
		this.acc_id = acc_id;
	   }
	   public java.util.Date getCreatedAt() {
			return createdAt;
	   }
	   
	   public String getPhone() {
			return phone;
		   }
		   public void setPhone(String phone) {
			this.phone = phone;
		   }

	   public void setCreatedAt(java.util.Date createdAt) {
		this.createdAt = createdAt;
	   }
	   public java.util.Date getUpdatedAt() {
			return updatedAt;
	   }

		   public void setUpdatedAt(java.util.Date updatedAt) {
			this.updatedAt = updatedAt;
	   }
	   
	   
	   
	   @Override
	public String toString()
	{
	   return "---BankDetails---\nName:" + name + ",\nAccount Type:" + acc_type + ",\nCurrent Balance:" + balance + ",\nAccount ID:" + acc_id
				+ ",\nPhone Number:" + phone + ",\nAccount Created At:" + createdAt + ",\nAccount Updated At:" + updatedAt + "";
	}    
}
