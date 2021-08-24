import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _210824_BOJ_G4_1339_단어_수학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		Integer[] alphabetValue = new Integer[26];
		Arrays.fill(alphabetValue, 0);

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			//value A에 대해서: AAA->111, ABCD->1000, AAAAB->11110
			for (int index = word.length() - 1, value = 1; index >= 0; index--, value *= 10)
				alphabetValue[word.charAt(index) - 'A'] += value;
		}
		Arrays.sort(alphabetValue, Collections.reverseOrder());
		for (int index = 0, value = 9; alphabetValue[index] != 0; index++, value--) {
			result += value * alphabetValue[index];
		}
		System.out.println(result);
	}
}
