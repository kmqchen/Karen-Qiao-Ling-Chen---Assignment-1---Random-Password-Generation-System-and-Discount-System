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

public class DiscountRate {
	
	//--------------------------------------------------------------------------------------------------
	
		//Assignment 1
		//Written by: Qiao Ling Chen, Student #0995426
		//For Application Development 2 (Mobile) - Winter 2022
		
	//---------------------------------------------------------------------------------------------------
	
	static final double SERVICE_DISCOUNT_PREMIUM = 0.2;
	static final double SERVICE_DISCOUNT_GOLD = 0.15;
	static final double SERVICE_DISCOUNT_SILVER = 0.1;
	static final double PRODUCT_DISCOUNT_PREMIUM = 0.1;
	static final double PRODUCT_DISCOUNT_GOLD = 0.1;
	static final double PRODUCT_DISCOUNT_SILVER = 0.1;
	
}
