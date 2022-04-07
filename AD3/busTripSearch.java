import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/** @author micahdarcy
 * 
 * searching for all trips with a given arrival time 
 * 
 *
 */
public class busTripSearch {
	
	public static void deleteTrip() {
		//delete invalid times 
	}
	
	public static HashMap<String, ArrayList<String>> busTrip = new HashMap<String,ArrayList<String>>();
	
	busTripSearch(String inputFile){
		try {
			Scanner scannerInput = new Scanner(new FileInputStream(inputFile));
			scannerInput.nextLine();
			
			while(scannerInput.hasNextLine()) {
				String stringInput = scannerInput.nextLine();
				String arrivalTime = stringInput.split("\\,")[1];
				arrivalTime = arrivalTime.trim();
				
				
				
						
			}
			
				
			/**int l =0;
			String d;
			while(scannerInput.hasNextLine()) {
				if(l ==0) {
				d=scannerInput.nextLine();
				l++;
				}
				String[] lineD  = scannerInput.nextLine().trim().split(",");
			*/
			}
			
		}
		catch(FileNotFoundException ){
			
			
		}
		
		
		
	}
		

	public static void main (String[] args) throws IOException{
	// call constructor 
		
	}

}
