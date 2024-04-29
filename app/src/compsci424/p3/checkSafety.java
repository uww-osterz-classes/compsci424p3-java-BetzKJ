package compsci424.p3;

public class checkSafety {

	static boolean checkAlloMax (int r, int P, int max[][], int allocation[][]) {
		
		for (int i = 0; i < P; i++) { 
			for (int j = 0; j < r; j++) {
				if (allocation[i][j] > max[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
		
	static boolean safety(int r, int p, int available[], int max[][], int allocation[][]) {
		if (checkAlloMax(r, p, max, allocation) == false) {
			return false;
		}
		int finishedProcess[] = new int[p];  
	    int copyAvailable[] = new int[r];
	    for (int i = 0; i < r ; i++) {
	        copyAvailable[i] = available[i];
	    }
		int potentialRequests[][] = new int[p][r];
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				potentialRequests[i][j] = max[i][j] - allocation[i][j];
			}
		}
	    int a = 0;
	    while (a < p) {
	        int safe = 0;
	        for (int i = 0; i < p; i++) {
	            if (finishedProcess[i] == 0) {
	                int b = 0;
	                for (int j = 0; j < r; j++) {
	                    if (potentialRequests[i][j] > copyAvailable[j]) {
	                        break;
	                    }
	                    else {
	                    	b++;
	                    }
	                }
	                if (b == r) { 
	                	for (int k = 0; k < r; k++) {
		                     copyAvailable[k] = copyAvailable[k] + allocation[i][k];
		                }
		                finishedProcess[i] = 1;
		                a++;
		                safe = 1;
	                }
	            }
	        }
	        if (safe != 1) {
	            return false;
	        }
	    }
	    return true;
  }
}	