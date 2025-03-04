import java.util.Arrays;
import java.util.Comparator;

public class NaturalSort<T> implements Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        Arrays.sort(arr, comparator);
    }
}
