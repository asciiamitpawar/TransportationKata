package com.homedepot.transportation.example;

public class TransportationService {

	public String calculateCoveringHours(int speed, int driverCount, int distance) {
		StringBuffer result = new StringBuffer();
		int dailyMilesLimit = speed * driverCount * 12;
		double dayCount = (double) distance / dailyMilesLimit;
		int hours = getHoursForFullDay(dayCount);
		double partialHours = getHoursForPartialDay(dayCount, driverCount);
		hours += (int) partialHours;
		int minutes = (int) getMinutesForPartialHour(partialHours);
		result.append(String.valueOf(hours));
		result.append("hr");
		result.append(String.valueOf(minutes));
		result.append("m");
		return result.toString();
	}

	public double calculateCostOfTransportation(int speed, int driverCount, int distance, double hourlyCost) {
		double cost = 0;
		String timeTaken = calculateCoveringHours(speed, driverCount, distance);
		timeTaken = timeTaken.replaceAll("hr", ".");
		timeTaken = timeTaken.replaceAll("m", "");
		if (driverCount == 2) {
			cost = Double.valueOf(timeTaken) * hourlyCost * driverCount * 2;
		} else {
			cost = Double.valueOf(timeTaken) * hourlyCost * driverCount;
		}
		return cost;
	}

	public int getHoursForFullDay(double dayCount) {
		int result = 0;
		result = ((int) dayCount) * 24;
		return result;
	}

	public double getHoursForPartialDay(double dayCount, int driverCount) {
		double result = 0;
		result = (dayCount % (int) dayCount) * 12 * driverCount;
		return result;
	}

	public double getMinutesForPartialHour(double partialHours) {
		double result = 0;
		result = (partialHours % (int) partialHours) * 60;
		return result;
	}

}
