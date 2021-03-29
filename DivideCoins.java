import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideCoins {
	
	static boolean ifDivisible(int n, int half, int[] coins) {
		if (half == 0) 	return true;
		if (n == 0) 	return false;
		if (coins[n - 1] > half)	return ifDivisible(n - 1, half, coins);
		return (ifDivisible(n - 1, half, coins) || ifDivisible(n-1, half - coins[n - 1], coins));
	}

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int i = 0;
			int sum = 0;
			int[] coins;
			int n = Integer.parseInt(bf.readLine());
			coins = new int[n];
			
			while (i < n) {
				int d = Integer.parseInt(bf.readLine());
				coins[i] = d;
				sum += d;
				i ++;
			}
			if (sum % 2 != 0) {
				System.out.println("F");
			} else {
				boolean divisibility = ifDivisible(n, sum / 2, coins);
				if(divisibility) {
					System.out.println("T");
				} else {
					System.out.println("F");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
