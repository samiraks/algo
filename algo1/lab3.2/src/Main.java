import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        List<BigInteger> nums = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer("", " ");
        while (nums.size() < n) {
            if (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line, " ");
            }
            while (st.hasMoreTokens() && nums.size() < n) {
                nums.add(new BigInteger(st.nextToken()));
            }
        }

        new RadixSort().sort(nums);

        // Вывод: каждое число с новой строки
        StringBuilder sb = new StringBuilder();
        for (BigInteger x : nums) {
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }
}