package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		int books;
		int money;
		int[] prices;
		
		while(line != null) {
			
			books = Integer.parseInt(line);
			prices = getPrices(br.readLine());
			money = Integer.parseInt(br.readLine());
			
			bw.write("books: " + books + "\n" + 
					 "prices: " + Arrays.toString(prices) + "\n" +
					 "money: " + money + "\n\n");
			
			br.readLine();
			line = br.readLine();
		}

		
		br.close();
		bw.close();
	}

	private static int[] getPrices(String line) {
		
		String[] strings = line.split(" ");
		int[] nums = new int[strings.length];
		
		for (int i = 0; i < strings.length; i++) {
			nums[i] = Integer.parseInt(strings[i]);
		}
		
		return nums;
	}

}
