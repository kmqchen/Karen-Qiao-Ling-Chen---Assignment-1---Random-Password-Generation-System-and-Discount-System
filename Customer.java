package DiscountSystem;

/**
 Discount system for a beauty salon, which provides services and sells beauty products.
 The system offers 3 types of membership respectively for all services provided:
 Premium with discount: 20%
 Gold with discount: 15%
 Silver with discount: 10%
 Customers without membership with discount: 0%
 Discount on products purchased: 10% (flat)
 */
 
/**
 Steps: to create 3 classes to compute the total bill if a customer purchases $x of products and $y of services for a visit:
 1. Customer
 	Customer name
 	Is a member?
 	Member type?
 2. Discount
 	To contain only static variables and methods (underlined in the class diagram)
 3. Visit
 	Customer information from Customer class
 	Date of visit
 	Service expense
 	Product expense
 4. Test program to exercise all the classes
 */

public class Customer {
	
	//--------------------------------------------------------------------------------------------------
	
		//Assignment 1
		//Written by: Qiao Ling Chen, Student #0995426
		//For Application Development 2 (Mobile) - Winter 2022
		
	//---------------------------------------------------------------------------------------------------
	
	public static String name;
	public static boolean member;
	public static String memberType;
	
	public Customer() {
		this.name = "";
		this.member = false;
		this.memberType = "";		
	}
	
	public Customer(String name) {
		this.name = name;		
	}
	
	private String getName() {
		return this.name;
	}
	
	public boolean isMember() {
		if(this.memberType.equalsIgnoreCase("Premium")) {
			this.member = true;
		}
		else if(this.memberType.equalsIgnoreCase("Gold")) {
			this.member = true;
		}
		else if(this.memberType.equalsIgnoreCase("Silver")) {
			this.member = true;
		}
		else
			this.member = false;
		return this.member;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private String getMemberType() {
		return this.memberType;
	}
	
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	public String toString() {
		return "Customer: " + getName().substring(0,1).toUpperCase()+getName().substring(1) + "\nThe customer is a member? " + isMember() 
		+ "\nMember type: " + getMemberType() + "\n";
	}
}
