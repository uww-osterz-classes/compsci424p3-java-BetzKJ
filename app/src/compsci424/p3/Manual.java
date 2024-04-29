package compsci424.p3;

import java.util.Scanner;

public class Manual {
	
	public static void manual(int r, int p, int available[], int max[][], int allocation[][]) {
	Scanner typeCommand = new Scanner(System.in);
	while(true) {	
		int I = 0;
		int J = 0;
		int K = 0;
		System.out.println("\nWhat is your command?" + "\n1. request I of J for K" + "\n2. release I of J for K" + "\n3. end");
		String command = typeCommand.nextLine();
		System.out.println(command);
		String c[] = command.split(" ");
		if (c[0].equals("end")) {
			break;
		}
		else if (c[0].equals("request")) {
			try {
				I = Integer.parseInt(c[1]);
				J = Integer.parseInt(c[3]);
				K = Integer.parseInt(c[5]);
			} catch (Exception n) {
				System.out.println("Command is not formatted correctly. Try again");
				
			}
			if (c[2].equals("of") && c[4].equals("for")) {
				int copyAvailable[] = new int[r];
			    for (int i = 0; i < r ; i++) {
			        copyAvailable[i] = available[i];
			    }   
			    int copyAllocation[][] = new int[p][r];
			    for (int i = 0; i < p ; i++) {
			    	for (int j = 0; j < r; j++) {
			    		copyAllocation[i][j] = allocation[i][j];
			    	}
			    } 
			    try {
			    	copyAvailable[J] = copyAvailable[J] - I;
				    copyAllocation[K][J] = copyAllocation[K][J] + I;
			    } catch (ArrayIndexOutOfBoundsException a) {
			    	System.out.println("request is out of bounds. Try again");
			    	
			    }
			    if (copyAvailable[J] < 0) {
			    	System.out.println("request is negative. Try again");
			    }
			    else {
			    	 boolean safe = checkSafety.safety(r, p, copyAvailable, max, copyAllocation);
			    	if (safe == true) {
				    	System.out.println("Process " + K + " requests " + I + " units of resource " + J + ": granted");
				    	available[J] = copyAvailable[J];
				    	allocation[K][J] = copyAllocation[K][J];
				    }
			    	else {
			    		System.out.println("Process " + K + " requests " + I + " units of resource " + J + ": declined");
			    	}
			    }
			}
			else {
				System.out.println("Command is not formatted correctly. Try again");
				
			}
			
		}
		else if (c[0].equals("release")) {
			try {
				I = Integer.parseInt(c[1]);
				J = Integer.parseInt(c[3]);
				K = Integer.parseInt(c[5]);
			} catch (NumberFormatException n) {
				System.out.println("Command is not formatted correctly. Try again");
				
			}
			if (c[2].equals("of") && c[4].equals("for")) {
				int copyAvailable[] = new int[r];
			    for (int i = 0; i < r ; i++) {
			        copyAvailable[i] = available[i];
			    }   
			    int copyAllocation[][] = new int[p][r];
			    for (int i = 0; i < p ; i++) {
			    	for (int j = 0; j < r; j++) {
			    		copyAllocation[i][j] = allocation[i][j];
			    	}
			    } 
			    try {
			    	copyAvailable[J] = copyAvailable[J] + I;
				    copyAllocation[K][J] = copyAllocation[K][J] - I;
			    } catch (ArrayIndexOutOfBoundsException a) {
			    	System.out.println("request is out of bounds. Try again");
			    	
			    }
			    System.out.println(copyAvailable[J]);
			    System.out.println(copyAllocation[K][J]);
			    if (copyAllocation[K][J] < 0) {
			    	System.out.println("request is negative. Try again");
			    }
			  
			    else {
				    System.out.println("Process " + K + " releases " + I + " units of resource " + J);
				    available[J] = copyAvailable[J];
				    allocation[K][J] = copyAllocation[K][J];
				    
			    }
			}
			else {
				System.out.println("Command is not formatted correctly. Try again");
				
			}
			
		}
		else {
			System.out.println("Command is not formatted correctly. Try again");
			
		}
		
		
		
	} 
	typeCommand.close();
	System.out.println("Program Shutdown!");
	}

}
