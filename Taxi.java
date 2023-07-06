package com.booking;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
	private static int taxiCount = 0;
	private boolean booked = false;
	private int id;
	private char currentLocation;
	private int earning;
	private List<String> tripDetails;
	private int freeTime;
	
	public Taxi() 
	{
		booked = false;
		setCurrentLocation('A');
		setEarning(0);
		setFreeTime(6);
		setTripDetails(new ArrayList<>());
		taxiCount++;
		id = taxiCount;
		
	}
	
	public void setDetails(boolean booked,char currentLocation,int freeTime,int earning,String tripDetail) {
		this.booked=booked;
		this.setCurrentLocation(currentLocation);
		this.setFreeTime(freeTime);
		this.setEarning(earning);
		this.getTripDetails().add(tripDetail);
	}

	public int getFreeTime() {
		return freeTime;
	}

	public void setFreeTime(int freeTime) {
		this.freeTime = freeTime;
	}

	public char getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(char currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getTripDetails() {
		return tripDetails;
	}

	public void setTripDetails(List<String> tripDetails) {
		this.tripDetails = tripDetails;
	}
}

