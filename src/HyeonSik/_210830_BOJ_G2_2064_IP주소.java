import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210830_BOJ_G2_2064_IP주소 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] IPs = new int[N][4];
		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			String[] bits = string.split("\\.");
			for (int j = 0; j < 4; j++)
				IPs[i][j] = Integer.parseInt(bits[j]);
		}
		// bitIndex: 네트워크 주소가 끝나는 bit의 인덱스
		int bitIndex = 0;
		int[] ipBit = new int[4];
		int[] maskBit = new int[4];
		// 네트워크 주소 구하기
		for (int bit = (1 << 7); bitIndex < 32; bitIndex++, bit >>= 1) {
			if (bit == 0)
				bit = (1 << 7);
			// N개의 IP의 현재 bit(curBit)가 같아야 한다.
			int curBit = (IPs[0][bitIndex / 8] & bit);
			boolean isSame = true;
			for (int i = 0; i < N; i++) {
				if (curBit != (IPs[i][bitIndex / 8] & bit)) {
					isSame = false;
					break;
				}
			}
			// 다르면, 네트워크 주소 탐색 그만
			if (!isSame)
				break;
			// 같으면, 현재 bit를 or 연산
			else
				ipBit[bitIndex / 8] |= curBit;
		}
		// 네트워크 마스크 구하기
		for (int maskIndex = 0, bit = (1 << 7); maskIndex < bitIndex; maskIndex++, bit >>= 1) {
			if (bit == 0)
				bit = (1 << 7);
			maskBit[maskIndex / 8] |= bit;
		}
		System.out.println(ipBit[0] + "." + ipBit[1] + "." + ipBit[2] + "." + ipBit[3]);
		System.out.println(maskBit[0] + "." + maskBit[1] + "." + maskBit[2] + "." + maskBit[3]);
	}
}
