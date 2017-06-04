import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class St {
	public static void main(String[] args) {
			HashMap<Long,Integer> res = new HashMap<Long,Integer>();
			ArrayList<Long> arr = new ArrayList<Long>();
			Scanner in = new Scanner(System.in);
			Long uid;
			int i;
			while (in.hasNext()) {
				int n = 0;
				uid = in.nextLong();
				if (uid == 0) 
					break;
				else if (!res.containsKey(uid)){ 
						res.put(uid, 0);
						arr.add(uid);
						}	
				
			}
			 System.out.print(arr.size());		         
	}
}
