package com.booking;

import java.util.ArrayList;
import java.util.List;

import com.booking.Taxi;

public class Booking {

	public static List<Taxi> createTaxi(int n){
		List<Taxi> taxis = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			Taxi t = new Taxi();
			taxis.add(t);
		}
		return taxis;
	}
	
	public static List<Taxi> getFreeTaxis(List<Taxi> taxis,int pickUpTime,char pickUpPoint){
		List<Taxi> freeTaxis = new ArrayList<>();
		for(Taxi t : taxis) {
			if(t.getFreeTime() <= pickUpTime && Math.abs((t.getCurrentLocation()-'0')-(pickUpPoint-'0')) <= pickUpTime - t.getFreeTime()  ) {
				freeTaxis.add(t);
			}
		}
		return freeTaxis;
	}


	public static void bookTaxi(int customerID, char pickUpPoint, char dropDownPoint, int pickUpTime, List<Taxi> freeTaxis) {
		
		int minDistance = 1000;
		
		int distanceBwPickupAndDrop = 0;
		
		int earnings = 0;
		
		int nextFreeTime = 0;
		
		char nextSpot = 'k';
		
		Taxi bookedTaxi = null;
		
		String tripDetail = "";
		
		for(Taxi t:freeTaxis) {
			
			int distanceBwCustomerAndTaxi = Math.abs((t.getCurrentLocation()-'0')-(pickUpPoint - '0')) *15;
			
			if(distanceBwCustomerAndTaxi < minDistance) {
				bookedTaxi = t;
				
				distanceBwPickupAndDrop = Math.abs((dropDownPoint-'0') - (pickUpPoint-'0')) * 15;
				
				earnings = (distanceBwPickupAndDrop - 5) * 10 + 100;
				
				int dropTime = pickUpTime + distanceBwPickupAndDrop/15;
				
				nextFreeTime = dropTime;
				
				nextSpot = dropDownPoint;
				
				tripDetail = customerID + "               " + customerID + "          " + pickUpPoint +  "      " + dropDownPoint + "       " + pickUpTime + "              " +dropTime + "        " + earnings;
				
				minDistance = distanceBwCustomerAndTaxi;
			}
		}
		
		bookedTaxi.setDetails(true,nextSpot,nextFreeTime,bookedTaxi.getEarning()+earnings,tripDetail);
		
		System.out.println("Taxi"+bookedTaxi.getId()+" is Booked");
	}
	
	public void printDetails(Taxi t) {
		System.out.println("Taxi - "+t.getId()+" Total Earnings - " + t.getEarning());
		System.out.println("TaxiID    BookingID    CustomerID    FROM    TO    PickUpTime    DropTime   Amount");
		for(String s : t.getTripDetails()) {
			System.out.println(t.getId()+"          "+ s);
		}
		System.out.println("----------------------------------------------------------------------------------");
	}

}
