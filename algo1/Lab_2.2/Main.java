import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Чтение массива
        ArrayList<Integer> nums = new ArrayList<>(n); //создаем пустой список nums, сразу резервируя в памяти место под n элементов
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt()); //добавление в лист
        }

        // Сортировка
        new MergeSort().sort(nums);

        // Вывод
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums.get(i));
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

        sc.close();
    }
}