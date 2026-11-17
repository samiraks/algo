import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Блок 1: Чтение N
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        // Блок 2: Чтение массива и инициализация дерева
        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int[] tree = new int[2 * n];
        for (int i = 0; i < n; i++) {
            // Используем StringTokenizer, он быстрее split()
            tree[n + i] = Integer.parseInt(st.nextToken());
        }

        // Блок 3: Построение дерева
        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        // Блок 4: Обработка запросов
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) break;

            st = new StringTokenizer(line);
            if (st.countTokens() < 2) break;

            int l = Integer.parseInt(st.nextToken()) + n;
            int r = Integer.parseInt(st.nextToken()) + n;

            int min = Integer.MAX_VALUE;
            while (l < r) {
                if ((l & 1) == 1) min = Math.min(min, tree[l++]);
                if ((r & 1) == 1) min = Math.min(min, tree[--r]);
                l >>= 1;
                r >>= 1;
            }
            sb.append(min).append('\n');
        }

        // Блок 5: Вывод
        System.out.print(sb);
    }
}
