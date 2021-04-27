package Bhaskara;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BhaskaraResult {
	private double firstResult;
	private double secondResult;
	private DecimalFormat formatter;
	
	public BhaskaraResult(double firstResult, double secondResult) {
		super();
		this.firstResult = firstResult;
		this.secondResult = secondResult;
		formatter = new DecimalFormat("#.#####");
	}

	public double getFirstResult() {
		return Double.parseDouble(formatter.format(firstResult));
	}

	public double getSecondResult() {
		return Double.parseDouble(formatter.format(secondResult));
	}
}
