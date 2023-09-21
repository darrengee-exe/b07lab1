import java.lang.Math;

public class Polynomial {

	// one field 
	double coefficients[]; // array declaration, only a reference to an array is created 
	
	// constructors
	public Polynomial() {
		// set polynomial coefficients to 0
		coefficients = new double[1]; // array instantiation, memory is allocated to the array
	}

	public Polynomial(double coefficients[]) {
		// set polynomial coefficients

		this.coefficients = new double[coefficients.length];

		for(int i = 0; i < coefficients.length ; i++) {
			this.coefficients[i] = coefficients[i];
		}
	}

	public Polynomial add(Polynomial p) {
		// add two polynomials

		int newSize = Math.max(this.coefficients.length, p.coefficients.length); // size of new coefficient array
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
		// evaluate the polynomial with given x

		double result = 0;
		
		for(int i = 0; i < this.coefficients.length; i++) {
			result += this.coefficients[i] * Math.pow(x, i);
		}
		return result;
	}

	public boolean hasRoot(double x) {
		// returns whether or not x is a root of Polynomial

		boolean isRoot = false;
		double result = evaluate(x);

		if(result == 0) 
			isRoot = true;

		return isRoot;
	}
}