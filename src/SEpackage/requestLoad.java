package SEpackage;

import java.io.FileWriter;

public class requestLoad {

	public static int[] getFromFile(String user, int slot) {
		
		int[] voided = {};
		
		try {
			
			int[] data = {1, 2, 3};
			
			
			// get data from file
			String path = ".\\user_data\\saves\\" + user + ".data";
			FileWriter file = new FileWriter(path);
			
			return data;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return voided;

	}
	
}
