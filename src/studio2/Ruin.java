package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a smart amount: ");
		int startAmount = in.nextInt();
		
		System.out.println("Enter a win chance: ");
		double winChance = in.nextDouble();
		
		System.out.println("Enter the winLimit: ");
		int winLimit = in.nextInt();
		
		System.out.println("Enter the total simulations: ");
		int simulations = in.nextInt();
		
		int numberofLosses = 0;
		int totalSimulations = 0;
		boolean result = false;
		for (int i=1;i<=simulations; i++) {
			int numberofRounds = 0;
			int currentAmount = startAmount;
			while (currentAmount >= 0 && currentAmount <= winLimit) {
				numberofRounds+=1;
				if(currentAmount ==0) {
					numberofLosses++;
					currentAmount-=1;
					result = false;
				}
				else if(Math.random()>= winChance){
					currentAmount-=1;
				}
				else if(currentAmount== winLimit){
					currentAmount+=1;
					result = true;
				}
				else {
					currentAmount+=1;
				}
			}
			totalSimulations++;
			if(result == true) {
				System.out.println("Simulation " + totalSimulations + ": " +numberofRounds + " WIN");
			}
			else {
				System.out.println("Simulation " + totalSimulations + ": " +numberofRounds + " LOSE");
			}
		}
		System.out.println("Losses: " + numberofLosses + " Simulations: " + simulations);
		double ruinRate = numberofLosses *1.0 / simulations ;
		double expectedRuinRate;
		double a = (1-winChance)/winChance;
		if( winChance==0.5) {
			expectedRuinRate = 1 - (startAmount*1.0/winLimit); 
		}
		else {
			expectedRuinRate = (Math.pow(a, startAmount*1.0)-Math.pow(a,winLimit*1.0))/(1-Math.pow(a, winLimit*1.0));
		}
		System.out.print("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuinRate);
	}

}
