package Bhaskara;

import java.util.Scanner;

public class BhaskaraApp {
	
	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        
        Boolean calculatable = ableToCalculateBhaskara(a, b, c);
        
        if (calculatable) {
        	BhaskaraResult results = bhaskara(a, b, c);
            System.out.printf("First Result = %f\n",results.getFirstResult());
            System.out.printf("Second Result = %f\n",results.getSecondResult());
        } else {
            System.out.println("Impossivel calcular");
        }
    }

    public static Boolean ableToCalculateBhaskara(double a, double b, double c) {
    	Double sqrRootClause = Math.pow(b, 2) - (4 * a * c);
		Double divisor = a * 2;
		if (sqrRootClause >= 0 && divisor != 0) {
			return true;
		}
		return false;
    }
    
	public static BhaskaraResult bhaskara(double a, double b, double c) {
		double sqrRootClause = Math.pow(b, 2) - (4 * a * c);
		double divisor = a * 2;
		double firstResult = (-b + Math.sqrt(sqrRootClause)) / divisor;
		double secondResult = (-b - Math.sqrt(sqrRootClause)) / divisor;
		return new BhaskaraResult(firstResult, secondResult);
	}
}
