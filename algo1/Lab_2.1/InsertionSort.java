import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            int key = nums.get(i); // запоминаем текущий элемент, вставляемый

            int j = i - 1;
            while(j >= 0 && nums.get(j) > key) {
                nums.set(j + 1, nums.get(j)); // сдвигаем больший элемент вправо, освобождая место
                j--; //
            }
            nums.set(j + 1, key); // вставка
        }
    }
}
