//Steven Huang
//sthuang
//pa6
//Calculates complex number under various methods of arithmetic

class Complex{

   //--------------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
   public double re;
   public double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
 
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);
  
   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }

   Complex(String s){
     s = s.trim();
     String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
     String SGN = "[+-]?";
     String OP =  "\\s*[+-]\\s*";
     String I =   "i";
     String OR =  "|";
     String REAL = SGN+NUM;
     String IMAG = SGN+NUM+"?"+I;
     String COMP = REAL+OR+
                   IMAG+OR+
                   REAL+OP+NUM+"?"+I;
      
     if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
     }
     s = s.replaceAll("\\s","");
     
     s = s.replaceAll("\\s","");     
     if( s.matches(REAL) ){
        re = Double.parseDouble(s);
        im = 0;
     }else if( s.matches(SGN+I) ){
        re = 0;
        im = Double.parseDouble( s.replace( I, "1.0" ) );
     }else if( s.matches(IMAG) ){
        re = 0;
        im = Double.parseDouble( s.replace( I , "" ) );
     }else if( s.matches(REAL+OP+I) ){
        re = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
        im = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
     }else{   
        re = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
        im = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
        }
   }

   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
   Complex copy(){
	   return new Complex (this.re, this.im);

   }
   
   // add()
   // Return a new Complex representing the sum this plus z.
   
   Complex add(Complex z){
     this.re += z.re;
     this.im += z.im;
     
     return new Complex (this.re,this.im);
   }
   
   // negate()
   // Return a new Complex representing the negative of this.
   Complex negate(){
	   
	   return new Complex(-this.re, -this.im);
      
   }
   // sub()
   // Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      
	   return new Complex(this.re - z.re, this.im - z.im);
   }

   // mult()
   // Return a new Complex representing the product this times z.
   Complex mult(Complex z){
      
	   return new Complex(this.re*z.re - this.im*z.im, this.re*z.im + this.im*z.re);
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).
   Complex recip(){
	   if (this.equals(Complex.ZERO)){
		   throw new ArithmeticException(
				   "Cannot take recipricoal of zero");
	   }
	   
      double x = (this.re/(Math.pow(this.re, 2)+Math.pow(this.im,2)));
      double y = (-this.im/(Math.pow(this.re, 2)+Math.pow(this.im,2)));
      
      return new Complex (x, y);
   }
   
   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).
   Complex div(Complex z){
      if (z.equals(Complex.ZERO)){
    	  throw new ArithmeticException(
    			  "Cannot divide by zero");
      }
      double a,b,c;
      
      a = this.re*z.re + this.im*z.im;
      b = z.re*this.im - z.im*this.re;
      c = Math.pow(z.re, 2) + Math.pow(z.im, 2);
    
      return new Complex (a/c, b/c);
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
      return new Complex (this.re,(-this.im));
   }
   
   // Re()
   // Return the real part of this.
   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.
   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).
   double abs(){
      double a = (Math.pow(this.re,2) + Math.pow(this.im,  2));
      
      return Math.sqrt(a);
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)
   public String toString(){
	  String s = null;
      if (re>0 && im>0){
    	  return this.re + "+" + this.im + "i";
      }else if(re>0 && im<0){
    	  return this.re + "-" + (-this.im) + "i";
      }else if(re<0 && im>0){
    	  return (this.re) + "+" + this.im + "i";
      }else if(re<0 && im<0){
    	  return (this.re) + "-" + (-this.im) + "i";
      }else if (this.re == 0){
    	  return this.im + "i";
      }else if (this.im == 0){
    	  return String.valueOf(this.re);  
      }
      return s;
   }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
   public boolean equals(Object obj){
      Complex c;
      boolean equals = false;
      
      if (obj instanceof Complex){
    	  c= (Complex) obj;
    	  equals = this.re == (c.re) &&
    			  this.im == (c.im);
      }
      return equals;
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      return new Complex(a, b);
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
   static Complex valueOf(double a){
      return new Complex(a);
   }

   // valueOf()
   // Return a new Complex constructed from s.
   static Complex valueOf(String s){
      return new Complex(s);
   }
}
   