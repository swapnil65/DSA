
public class CubicRoot {
	
	public double getAbsoluteDiff(double n, double mid){
		
		if(n > mid * mid * mid)
			return (n - mid * mid * mid);
		else
			return (mid * mid  * mid - n);
	}
	
	public double getCubeRoot(int n){
		
		double start = 0;
		double end = n;
		
		double e = 0.0000001;
		while(true){
		double mid = (start+end)/2;
		double error = getAbsoluteDiff(n, mid);
		
		if(error <= e)
			return mid;
		else if(mid*mid*mid > n)
			end = mid;
		else
			start = mid;
		}
	}

	public static void main(String[] args) {

		CubicRoot c = new CubicRoot();
		System.out.println(c.getCubeRoot(25));
	}

}
