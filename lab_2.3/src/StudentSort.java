import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        // Первый проход: сортируем по возрасту
        mergeSort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });

        // Второй проход: сортируем по имени (слияние стабильно, возраст сохранится)
        mergeSort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    // Тот самый метод слияния
    private void mergeSort(List<Student> list, Comparator<Student> cmp) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        List<Student> left = new ArrayList<>(list.subList(0, mid));
        List<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, cmp);
        mergeSort(right, cmp);

        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            // <= гарантирует стабильность сортировки
            if (cmp.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }
}