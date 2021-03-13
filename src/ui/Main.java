package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		int books, money;
		int[] prices;
		
		while(line != null) {
			
			books = Integer.parseInt(line);
			prices = getPrices(br.readLine());
			money = Integer.parseInt(br.readLine());
			
			Arrays.sort(prices);
			
			int[] solutions = getSolutions(prices, books, money);
			
			br.readLine();
			line = br.readLine();
			
			int i = 0;
			int j = 1;
			
			//Output format
			String output = String.format("Peter should buy books whose prices are %d and %d.\n\n", solutions[i], solutions[j]);
			bw.write(output);
		}

		long time = System.currentTimeMillis() - start;
		bw.write(time + "");
		
		br.close();
		bw.close();
	}



	private static int[] getSolutions(int[] prices, int books, int money) {
		
		int i = 0;
		int j = 1;
		int maxIdx = getMaxIdx(prices, books, money);
		int[] values = new int[2];
		
		int diff = money;
		
		for (int k = 0; k < maxIdx + 1; k++) {
			
			int tempPrice = prices[k];
			
			for (int l = k + 1; l < maxIdx + 1; l++) {
				
				if(tempPrice + prices[l] == money && diff > Math.abs(tempPrice - prices[l])) {
					
					diff = Math.abs(tempPrice - prices[l]);
					values[i] = tempPrice;
					values[j] = prices[l];
				}
			}
		}
		
		return values;
	}

	//Gets the index of a value greater or equal than the money peter could pay.
	private static int getMaxIdx(int[] prices, int books, int money) {
		
		int low = 0;
		int top = books - 1;	
		int maxIdx = top;
		
		while(low < top) {
			
			int mid = (top + low)/2;		
			if (prices[mid] > money) {
				top = mid;
			} else {
				low = mid + 1;
			}
			maxIdx = top;
		}
		
		return maxIdx;
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
