import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int max = 128;
        int[] count = new int[max];

        // 1. Подсчёт вхождений
        for (int x : nums) {
            count[x]++;
        }

        // 2. Заполнение списка по возрастанию
        int idx = 0;
        for (int i = 0; i < max; i++) {
            for (int k = 0; k < count[i]; k++) {
                nums.set(idx++, i);
            }
        }
    }
}