package homework.sortedIterator;

import java.util.Comparator;

import static homework.sortedIterator.SortedIterator.fromList;

public class SortedIteratorDemo {
    public static void main(String[] args) {
        SortedIterator<Integer> integerSortedIterator = fromList(new Integer[]{1, 2, 5, 4, 9, 6}, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        while (integerSortedIterator.hasNext()) {
            System.out.println(integerSortedIterator.next());
        }

    }
}
