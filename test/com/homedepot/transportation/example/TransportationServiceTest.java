package com.homedepot.transportation.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TransportationServiceTest {

	TransportationService ts = new TransportationService();

	@Test
	public void testValidaityOfCalculationForSingleDriver() {
		String calculatedHours = ts.calculateCoveringHours(60, 1, 2500);
		String str = "77hr40m";
		assertTrue(str.equals(calculatedHours));
	}

	@Test
	public void testValidaityOfCalculationForTeamOfDriver() {
		String calculatedHours = ts.calculateCoveringHours(60, 2, 2500);
		String str = "41hr40m";
		assertTrue(str.equals(calculatedHours));
	}

	@Test
	public void testCostRunningWithSingleDriver() {
		double calculatedCost = ts.calculateCostOfTransportation(60, 1, 2500, 120.70);
		double cost = 9342.18;
		assertTrue(calculatedCost == cost);
	}

	@Test
	public void testCostRunningWithTeamOfDriver() {
		double calculatedCost = ts.calculateCostOfTransportation(60, 2, 2500, 90.50);
		double cost = 14986.80;
		assertTrue(calculatedCost == cost);
	}

}
