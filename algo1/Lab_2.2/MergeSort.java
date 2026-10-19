import java.util.ArrayList;
import java.util.List;
public class MergeSort implements Sorting<Integer> {

    private void slice(List<Integer> nums, int start, int end) {
        // деление списка
        if (start >= end) { //Если в части списка остался один элемент или не осталось ни одного, делить её дальше не нужно
            return;
        }
        int middle = start + (end - start)/2; //находим середину
        slice(nums, start, middle); //сортируем левую половину
        slice (nums, middle + 1, end); //сортируем правую половину

        merge (nums, start, middle, end); //соединяет сортировки обеих половин

    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        // слияние частей
        List<Integer> temp = new ArrayList<>(); //временный список
        int i = start;
        int j = middle + 1;

        while (i <= middle && j <= end) {
            if (nums.get(i) <= nums.get(j)) {
                temp.add(nums.get(i));
                i++;
            }
            else {
                temp.add(nums.get(j));
                j++;
            }
        }

        while (i <= middle) {
            temp.add(nums.get(i));
            i++;
        }

        while (j <= end) {
            temp.add(nums.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            nums.set(start + k, temp.get(k));
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}