import java.util.Scanner; 
import java.util.Random; 

public class Test {
	
	public Test (){
		
		
	}
	
	public String comparenumber (int givenNumber, int trueNumber)
	{String givenString = givenNumber + "";
	 String trueString = trueNumber + "";
	 String result="";
		for (int i=0;i<4;i++)
			{   if (trueString.indexOf(givenString.charAt(i))==-1)
				{    // if its doesn't exist , add "." to the result
					result+=".";
				}
				// otherwise append either w or b 
				else 
				{  if ( givenString.charAt(i)==trueString.charAt(i) )
					result+="b";

				  else 
						result+="w";
				}
				
			}
			return result;
	}
	
	
	/* check if the given number is valid ;
	   length should be 4. should contains only values between 1 and 6
	  
	   @param number : given number 
	   @return       : true if the number is valid ,otherwise false 
	*/
	public boolean checkNumber (int number) 
	{   // convert the number to a String
		String value = number + "";
		// check the value length
		if (value.length()==4) {
			// parse the input and check if it's valid ( should contains only values between 1 and 6)
			for (int i=0;i<4;i++)
			{    // convert char to Integer
				int r=(Integer.parseInt(String.valueOf(value.charAt(i))));
				// check if the integer is between 1 and 6 
				if (r <1  || r>6)
					return false;
			}
			return true;
			
		}
		else {
			throw new IllegalArgumentException("length should be between 1 and 4");
		}
		
	}
	
	/* generate random integer
	   @param  
	   @return   : integer , length is 4 , contains only values between  1 and 6
	*/
	public static int randInt() {
		final int RADIX = 10;
    Random random=new Random();
	  char[] c = new char[4];
	int max= 6;
	int  min =1;
	c[0]= Character.forDigit(( random.nextInt(max - min + 1) + min), RADIX);
	c[1]= Character.forDigit(( random.nextInt(max - min + 1) + min), RADIX);
	c[2]= Character.forDigit(( random.nextInt(max - min + 1) + min), RADIX);
	c[3]= Character.forDigit(( random.nextInt(max - min + 1) + min), RADIX);
	System.out.println(c);
	 return Integer.parseInt(new String(c));
}
	
	// computer is the code maker ! 
	public boolean checkresult (int correctinteger, int userinput ) {
		String result=this.comparenumber(userinput,correctinteger);
		if (result.equals ("bbbb")==false) {
			System.out.println(" result for "+userinput +" is : "+result );
           return false;
		}
		return true;
	}
	// computer is the code breaker
	public void codebreaker (){
		
		System.out.println(" Ok ! I'm the code breaker , please enter a number and let me guess it ..... " );
		Scanner reader = new Scanner(System.in);
	    int correctinteger = reader.nextInt();
		int userinput= this.randInt();
		while (this.checkresult(correctinteger,userinput )==false){
			userinput= this.randInt();
			
		}
		System.out.println(correctinteger);
		
		
		
				System.out.println("congratulation" );
	//	}
	//	else {
	//		throw new IllegalArgumentException("Number is not valid!");
	//	}
	}
	
	// computer is the code breaker
	public void codemaker (){
		int correctinteger= this.randInt();
		System.out.println(" Ok ! I'm the code maker , please enter a number ..... " );
		Scanner reader = new Scanner(System.in);
	    int userinput = reader.nextInt();
		
		while (this.checkresult(correctinteger,userinput )==false){
		System.out.println("repeat please " );
	     userinput = reader.nextInt();
			
		}
		
				System.out.println("congratulation" );
	//	}
	//	else {
	//		throw new IllegalArgumentException("Number is not valid!");
	//	}
	}
	
	public static void main (String args[])
	{
		Scanner reader = new Scanner(System.in);
		Test test=new Test();
		
         int n =0;
		while (n != 1 && n !=2  )
		{
		System.out.println("do you want me to be the code maker or breaker ? answer with either 1 or 2");
		
        n = reader.nextInt();
		}
		switch (n) {
			
			case 1:  {
				test.codemaker();
				
				 break;
			}
			case 2:  {
				test.codebreaker();
				
				 break;
			}
		    default: System.out.println(" Your input is false , it should be either 1 or 2");
                     break;
		
		}
	
		
		
	}
	
}