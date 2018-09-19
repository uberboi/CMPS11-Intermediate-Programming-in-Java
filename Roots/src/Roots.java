import java.util.Scanner;

class Roots {
	
	public static void main ( String[] args ){
		Scanner sc = new Scanner(System.in);
		
		boolean rootFound = false;
		double resolution = Math.pow(10, -2), tolerance = Math.pow(10,  -7), threshold = Math.pow(10, -3), L, R, root, x;
		double [] C;
		double [] D;
		int n, i, z;
		
		System.out.print("Enter the degree: ");
		n = sc.nextInt();
		z = n + 1;
		
		C = new double[z];
		System.out.print("Enter " + z + " coefficients: ");
		for (i=0; i<z; i++){
			C[i] = sc.nextDouble();
		}
		System.out.print("Enter the left and right endpoints: ");
		L = sc.nextDouble();
		R = sc.nextDouble();
		
		System.out.print("\n");
		
		D = diff(C);
		
		for(double j = L; j< R; j += resolution){
			x = j + resolution;
			if (poly(C,j)*poly(C,x)<0){
				root = findRoot(C, j, x, tolerance);
				System.out.printf("Root found at %.5f%n", root);
				rootFound = true;
			}else if (poly(D,j)*poly(D,x)<0){
				root = findRoot(D, j, x, tolerance);
				if (Math.abs(poly(C, root)) < threshold){
					System.out.printf("Root found at %.5f%n", root);
					rootFound = true;
				}
			}
		}
		
		//for(double k = L; k < R; k += resolution){
			//x = k + resolution;
			//if(poly(D,k)*poly(D,(k += resolution))<0){
				//root = findRoot(D, k, (x += resolution), tolerance);
				//if( Math.abs(poly(C, root)) < threshold ){
				//System.out.printf("Root found at %.5f%n", root);
				//}
			//}
		//}

		if (rootFound == false){
			System.out.println("No roots were found in the specified range. ");
		}
	}
	
	static double poly (double[] C, double x){
		double sum = 0;
		int n;
		n = C.length;
		for (int i=0; i<n; i++){
			sum += Math.pow(x, i)*C[i];
		}
		return sum;
		
	}
		
	static double[] diff(double[] C){
		int z = C.length-1;
		double [] D = new double[z];
		for (int j = 0, i = 1; j<z; j++, i++){
			D[j]=C[i]*i;	
		}
		return D;
	}
	
	static double findRoot (double [] C, double a, double b, double tolerance){
	    double width, midpoint = 0.0;
		width = b-a;
		while ( width>tolerance){
			 midpoint = (a+b)/2;
			 if (poly(C, a)*poly(C, midpoint)<0){
				 b = midpoint;
			 }else{
				 a = midpoint;
			 }
			 width = b-a;
		 }
		return midpoint;
	}
}
		

