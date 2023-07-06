package com.booking;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.booking.Booking;
import com.booking.Taxi;

public class Main {
	public static void main(String[] args) {
		
		Booking b = new Booking();
		
		List<Taxi> taxis = b.createTaxi(4);
		
		Scanner sc = new Scanner(System.in);
		int id = 1;
		while(id>=1) {
			System.out.println("0 -> Press to book taxi");
			System.out.println("1 -> press to print taxi details");
			int option = sc.nextInt();
			
			switch(option) {
			case(0):
				int customerId = id;
			
				System.out.print("Enter pickup location : ");
				char pickUpPoint = sc.next().charAt(0);
				System.out.print("Enter drop location : ");
				char dropDownPoint =sc.next().charAt(0);
				System.out.print("Enter pick up time : ");
				int pickUpTime = sc.nextInt();
				
				if(pickUpPoint < 'A' || dropDownPoint > 'F' || pickUpPoint > 'F' || dropDownPoint < 'A')
		        {
		            System.out.println("Valid pickup and drop are A, B, C, D, E, F. Exitting");
		            return;
		        }
				
				List<Taxi> freeTaxis = b.getFreeTaxis(taxis,pickUpTime,pickUpPoint);
				
				if(freeTaxis.size()==0) {
					System.out.println("Taxis are not available... Book later");
				}
				else {
				Collections.sort(freeTaxis,(c,d)->c.getEarning()-d.getEarning());
				
				b.bookTaxi(id,pickUpPoint,dropDownPoint,pickUpTime,freeTaxis);
				id++;
				break;
				}
				break;
			case(1):
			{
				for(Taxi t :taxis) {
					b.printDetails(t);
				}
				break;
			}
			default:
				return;
		}
		}
	}
}

