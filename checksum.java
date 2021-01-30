import java.util.Scanner;

class checksum  {  

  public static void main(String args[]) {

    final int max_int = 255;  // The maximum size for the input
    int count = 10;           // The number of integers to read from stdin
    int sum = 0;              // Note that the "sum" might exceed max_int
    int checksum = 0;         // The value of the 6th input integer
    int quotient;             // The result of evaluating the assignment:  quotient   = sum / (max_int + 1);
    int remainder;            // The result of evaluating the assignment:  remainder  = sum % (max_int + 1 );
    int complement = 0;        // The result of evaluationg the assignment: complement = max_int - sum;

    Scanner stdin = new Scanner(System.in);
    while(stdin.hasNext() && count > 0) {
    	int value = stdin.nextInt();
    	
    	//Checking if value is greater than 255 or less than 0(negative). 
    	if(value > max_int || value < 0)  {
    		System.out.println("The current integer " + value + " is not acceptable as it's out of bounds.");
    		break; //exits while loop and returns error as checksum wont match complement
    	}
    	
    	count--;
    	if(count == 4) {
    		checksum = value;
    		value = 0;
    		continue;
    	} else {
    		sum+=value;
    	}
    }
    
    quotient   = sum / (max_int + 1);
    remainder  = sum % (max_int + 1 );
    sum = quotient + remainder;
    complement = max_int - sum;
    
    System.out.printf("Stored Checksum: %d, Computed Checksum: %d\n", checksum, complement);
    if (checksum != complement ) {
    System.err.printf("Error Detected!\n");  
    }
  }
  
}