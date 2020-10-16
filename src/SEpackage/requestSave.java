package SEpackage;

import java.io.FileWriter;
import java.io.IOException;


//!~
//////////////////////////////----------------------|
/*///												|
* 													|
* @Author: Rio Bérénos								|
*													|
*///												|
//////////////////////////////----------------------|
//!~


public class requestSave {

	public static void toFile(int[] data, String user, int slot) throws IOException {
		
		// preps
		String path = ".\\user_data\\saves\\" + user + ".data";
		FileWriter file = new FileWriter(path);
			
		// make it so data is saved to a diff line each time
		
		
	}
	
}
