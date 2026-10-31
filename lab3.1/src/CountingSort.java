import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int MAX = 128;
        int[] count = new int[MAX];

        // 1. Подсчёт вхождений
        for (int x : nums) {
            count[x]++;
        }

        // 2. Заполнение списка по возрастанию
        int idx = 0;
        for (int value = 0; value < MAX; value++) {
            for (int k = 0; k < count[value]; k++) {
                nums.set(idx++, value);
            }
        }
    }
}