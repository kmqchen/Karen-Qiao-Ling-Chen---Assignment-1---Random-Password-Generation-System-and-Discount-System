package DiscountSystem;

public class Visit extends Customer{
	
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
	
	//--------------------------------------------------------------------------------------------------
	
		//Assignment 1
		//Written by: Qiao Ling Chen, Student #0995426
		//For Application Development 2 (Mobile) - Winter 2022
		
	//---------------------------------------------------------------------------------------------------
	
	Customer customer;
	DiscountRate discount = new DiscountRate();
	
	private String name;
	private String memberType;
	private String date;
	private  double serviceExpense;
	private  double productExpense;
	private String visitDate;
	private double total = 0;
	
	public Visit() {
		this.name = "";
		this.memberType = "";
		this.visitDate = "";
		this.serviceExpense = 0;
		this.productExpense = 0;
	}
	
	public Visit(String name, String memberType, String visitDate, double serviceExpense, 
			double productExpense) {
		this.name = name;
		this.memberType = memberType;
		this.visitDate = visitDate;
		this.serviceExpense = serviceExpense;
		this.productExpense = productExpense;
	}
	
	public String getName() {
		return this.name;
	}
	
	private double getServiceExpense() {
		return this.serviceExpense;
	}
	
	private double getProductExpense() {
		return this.productExpense;
	}
	
	private String getVisitDate() {
		return this.visitDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	void setServiceExpense(double serviceExpense) {
		this.serviceExpense = serviceExpense;
	}
	
	void setProductExpense(double productExpense) {
		this.productExpense = productExpense;
	}
	
	void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
	double getTotalExpense() {
		if(super.memberType.equalsIgnoreCase("Premium"))
			total += (getServiceExpense() + getProductExpense()) - getServiceExpense() * discount.SERVICE_DISCOUNT_PREMIUM
			- getProductExpense() * discount.PRODUCT_DISCOUNT_PREMIUM;
		else if(super.memberType.equalsIgnoreCase("Gold"))
			total += (getServiceExpense() + getProductExpense()) - getServiceExpense() * discount.SERVICE_DISCOUNT_GOLD
			- getProductExpense() * discount.PRODUCT_DISCOUNT_GOLD;
		else if(super.memberType.equalsIgnoreCase("Silver"))
			total += (getServiceExpense() + getProductExpense()) - getServiceExpense() * discount.SERVICE_DISCOUNT_SILVER
			- getProductExpense() * discount.PRODUCT_DISCOUNT_SILVER;
		else
			total += (getServiceExpense() + getProductExpense());
		return total;
	}
	
	public String toString() {
		System.out.println(super.toString() + "Visit Date: " + getVisitDate() + "\nService expense: " + getServiceExpense()
		+ "\nProduct Expense: " + getProductExpense() + "\nTotal Sales: " + total 
		+ "\n\nThank you for your visiting!\nLooking forward to serving you again!\n\n\n--------------------------------------");
		return super.toString() + "Visit Date: " + getVisitDate() + "\nService expense: " + getServiceExpense()
		+ "\nProduct Expense: " + getProductExpense() + "\nTotal Sales: " + total;
	}
}
