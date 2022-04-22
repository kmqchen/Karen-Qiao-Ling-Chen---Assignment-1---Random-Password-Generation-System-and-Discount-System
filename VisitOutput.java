package DiscountSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class VisitOutput {
	
	//--------------------------------------------------------------------------------------------------
	
	//Assignment 1
	
	//Written by: Qiao Ling Chen, Student #0995426
	
	//For Application Development 2 (Mobile) - Winter 2022
	
	//---------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
				
		Scanner in = new Scanner(System.in);
		int i = 0, j = 0, memberType;
		String name, visitDate, member, type = "", newCustomer;
		double serviceExpense, productExpense;
		boolean tryAgain = true, isMember;
		
		Customer customer;
		Visit visit = new Visit();

		while(tryAgain) {
			//Date entry
			System.out.println("Please enter customer's name");
			name = in.next();
			System.out.println("Customer is a member?\ny for Yes / n for No");
			member = in.next();
			if(member.equalsIgnoreCase("y")) {
				isMember = true;
				System.out.println("Customer's member type:\n1-Premium / 2-Gold / 3-Silver");
				memberType = in.nextInt();
				if(memberType == 1)
					type = "Premium";
				else if(memberType == 2)
					type = "Gold";
				else if(memberType == 3)
					type = "Silver";
				else
					System.out.println("Invalid member type");
			}
			else
				isMember = false;
			System.out.println("Visiting Date:\nDate format: mm/dd/yyyy");
			visitDate = in.next();
			System.out.println("Customer's service expense:");
			serviceExpense = in.nextDouble();
			System.out.println("Customer's product expense:");
			productExpense = in.nextDouble();
			
			//Class objects			
			visit = new Visit(name, type, visitDate, serviceExpense, productExpense);
			customer = new Customer(name);
			
			//Method invoking
			customer = new Customer(name);
			isMember = customer.isMember();
			customer.setMemberType(type);
			
			visit.setName(name);
			visit.setVisitDate(visitDate);
			visit.setServiceExpense(serviceExpense);
			visit.setProductExpense(productExpense);
			visit.getTotalExpense();
			
			//Welcome
			System.out.println();
			System.out.println();
			System.out.println("--------------------  Welcome for visiting our store  --------------------");
			System.out.println();
			System.out.println();
			
			//Output
			visit.toString();
			
			//New customer?
			System.out.println();
			System.out.println("New customer is coming?\ny for Yes, n for No");
			newCustomer = in.next();
			if(newCustomer.equalsIgnoreCase("y")) {
				tryAgain = true;
				i++;
			}
			else {
				tryAgain = false;
				System.exit(0);
			}
		}
	}

}
