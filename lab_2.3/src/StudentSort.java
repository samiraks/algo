import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        if (students == null || students.size() < 2) {
            return;
        }

        // 1. Сортируем по возрасту.
        mergeSort(students, 0, students.size() - 1,
                (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));

        // 2. Сортируем по имени.
        // compareTo — это ссылка на метод, который сравнивает строки лексикографически.
        mergeSort(students, 0, students.size() - 1,
                (s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    // Универсальный метод деления (один для всех)
    private void mergeSort(List<Student> students, int start, int end, Comparator<Student> comp) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;

        mergeSort(students, start, middle, comp);
        mergeSort(students, middle + 1, end, comp);

        merge(students, start, middle, end, comp);
    }

    // Универсальный метод слияния (один для всех)
    private void merge(List<Student> students, int start, int middle, int end, Comparator<Student> comp) {
        List<Student> temp = new ArrayList<>(end - start + 1);
        int i = start;
        int j = middle + 1;

        while (i <= middle && j <= end) {
            // Используем comp.compare вместо жесткого условия
            if (comp.compare(students.get(i), students.get(j)) <= 0) {
                temp.add(students.get(i));
                i++;
            } else {
                temp.add(students.get(j));
                j++;
            }
        }

        while (i <= middle) {
            temp.add(students.get(i));
            i++;
        }

        while (j <= end) {
            temp.add(students.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            students.set(start + k, temp.get(k));
        }
    }
}