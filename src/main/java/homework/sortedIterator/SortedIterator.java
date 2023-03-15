package homework.sortedIterator;

import java.util.*;

public class SortedIterator<T> implements Iterator {

    private List<T> elements;
    private int count;

    public SortedIterator(List<T> elements) {
        this.elements = elements;
    }

    public static <T> SortedIterator<T> fromList(T[] array) {
        Arrays.sort(array);
        return new SortedIterator<>(Arrays.asList(array));
    }

    public static <T> SortedIterator<T> fromList(T[] array, Comparator<T> comparator) {
        Arrays.sort(array, comparator);
        return new SortedIterator<>(Arrays.asList(array));
    }

    @Override
    public boolean hasNext() {
        return count < elements.size();
    }

    @Override
    public T next() {
        if (count >= elements.size()) {
            return null;
        }
        T t = elements.get(count);
        count++;
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SortedIterator<?> that = (SortedIterator<?>) o;

        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SortedIterator{" +
                "elements=" + elements +
                '}';
    }
}
