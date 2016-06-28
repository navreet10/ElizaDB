package ElizaApp;

import java.util.Random;
import java.util.Scanner;


public class ElizaApp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ElizaDao dao = new ElizaDao();
				
		StringBuilder output;
		String[] input;
		System.out.println("Hi, How are you today?");
		in.nextLine();
		System.out.println("Why is that?");
		Random rnd = new Random();
		while (true) {
			input = in.nextLine().split(" ");
			int randomNum = rnd.nextInt(2);
			if (randomNum == 0) {
				output = new StringBuilder(dao.getHedgeset());
				if (output.toString().contains("getting late")) {
					System.out.println(output);
					break;
				}
					
			} else {
				output = new StringBuilder(dao.getQualifierSet()+ " ");
				for (String x: input) {
					if (dao.existsInReplacmentMap(x)) {
						output.append(dao.getReplaceMent(x) + " ");
					} else {
						output.append(x + " ");
					}
				}
			}
			
			System.out.println(output);
		}
		System.out.println("Bye. See you again!!");
		in.close();
		
	}
	
}
