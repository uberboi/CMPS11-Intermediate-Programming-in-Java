import java.util.Scanner;

class Queens {
	public static void main(String[] args){
		
		int x = 0;
		int y = 0;
		
		boolean verbose = false;
		if (args.length == 1){
			try{
				x = Integer.parseInt(args[0]);
			}catch (NumberFormatException e){
				Usage();
			}
		}else if(args.length == 2){
			if (args[0].equals("-v")){
				verbose = true;
				try{
					x = Integer.parseInt(args[1]);
				}catch (NumberFormatException e){
					Usage();
				}
			}else{
				Usage();
			}
		}else{
			Usage();
		}
		
		long f = factorial(x);
		
		int[] A = new int [x+1];
		initializeArray(A);

		for(int i=0; i<f; i++){
		nextPermutation(A); 
			if(isSolution(A) == true){
				y++;
				if(verbose == true){
				printArray(A);
				}
			}
		}
		
		System.out.println(x + "-Queens has " + y + " solutions");
	}	
	
	static void Usage(){
		System.err.println("Usage: Queens [-v] number");
		System.err.println("Option: -v verbose output, print all solutions");
		System.exit(1);
	}
	
	static void nextPermutation (int[] A){
		boolean foundPivot = false;
		int pivot = 0;
		int successor = 0;
		int x = A.length;
		for (int i = x-2; i > 0; i--){
			if (A[i]<A[i+1]){
				pivot = i;
				foundPivot = true;
				break;
			}
		}
		if(foundPivot == false){	
			reverse(A, 1);
			return;
		}
		
		for (int j = x-1; j > 0; j--){
			if (A[j] > A[pivot]){
				successor = j;
				break;
			}
		}
		
		swap(A, pivot, successor);
		reverse(A, pivot+1);
	}
	
	static void initializeArray (int[] A){
		for (int i = 1; i<A.length; i++){
			A[i] = i;
		}
	}
	
	static void swap(int[] A, int i, int j){
		
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	static void reverse(int[] A, int i){
		int j = A.length - 1;
		while(i<j){
		swap(A, i, j);
		i++;
		j--;
		}
		
	}
	
	static long factorial(long n){
		long product = 1;
		for(int i=1; i<=n; i++){
			product *= i;
		}
		return product;		
	}
	
	static boolean isSolution(int[] A){
		for(int i = 1; i<(A.length-1); i++){
			for(int j = i + 1; j<=(A.length-1); j++){
				int x = Math.abs(A[j]-A[i]);
				int y = Math.abs(j-i);
				
				if (x == y){
					return false;
				}
			}
		}
		return true;
	}
	
	 static void printArray(int[] A){
	      System.out.print("( ");
	      for(int i=1; i<A.length; i++)
	         System.out.print(A[i]+" ");
	      System.out.println(")");
	   }
}