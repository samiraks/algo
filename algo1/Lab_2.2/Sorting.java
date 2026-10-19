import java.util.List;

// Этот интерфейс будет общим для всех остальных сортировок
public interface Sorting<T extends Comparable<T>> {
    void sort(List<T> nums);
}