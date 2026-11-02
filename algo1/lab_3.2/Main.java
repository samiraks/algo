import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Читаем количество чисел
    int n = sc.nextInt();

    // Создаем список и резервируем место
    ArrayList<BigInteger> nums = new ArrayList<>(n);

    // Чтение массива
    for (int i = 0; i < n; i++) {
      // Читаем число как строку и сразу превращаем в BigInteger
      String numberStr = sc.next();
      nums.add(new BigInteger(numberStr));
    }

    // Сортировка
    new RadixSort().sort(nums);

    // Вывод (каждое число с новой строки, как в условии задачи)
    StringBuilder sb = new StringBuilder();
    for (BigInteger num : nums) {
      sb.append(num).append("\n");
    }
    System.out.print(sb.toString());

    sc.close();
  }
}
