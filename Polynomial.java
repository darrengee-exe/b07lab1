import java.lang.Math;

public class Polynomial {

	double coefficients[];  
	
	public Polynomial() {
		coefficients = new double[1]; 
	}

	public Polynomial(double coefficients[]) {
		this.coefficients = new double[coefficients.length];

		for(int i = 0; i < coefficients.length ; i++) {
			this.coefficients[i] = coefficients[i];
		}
	}

	public Polynomial add(Polynomial p) {
		int newSize = Math.max(this.coefficients.length, p.coefficients.length); 
		double newCoefficients[] = new double[newSize];

		for(int i = 0; i < newSize; i++) {
			if(i < this.coefficients.length) {
				newCoefficients[i] += this.coefficients[i];
			}
			
			if(i < p.coefficients.length) {
				newCoefficients[i] += p.coefficients[i];
			}
		}

		this.coefficients = null;
		this.coefficients = newCoefficients;
		return this;
	}

	public double evaluate(double x) {
		double result = 0;
		
		for(int i = 0; i < this.coefficients.length; i++) {
			result += this.coefficients[i] * Math.pow(x, i);
		}
		return result;
	}

	public boolean hasRoot(double x) {
		boolean isRoot = false;
		double result = evaluate(x);

		if(result == 0) 
			isRoot = true;

		return isRoot;
	}
}