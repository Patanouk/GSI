import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * https://www.geeksforgeeks.org/goldman-sachs-interview-experience-for-1-5-years-experienced/
 * See iterator for list of list
 */
public class NestedListIterator<T> implements Iterator<T> {

    private final List<List<T>> elements;
    private int listIndex = 0;
    private int nestedListIndex = 0;

    public NestedListIterator(List<List<T>> elements) {
        if (elements == null) {
            this.elements = new ArrayList<>();
        } else {
            this.elements = elements;
        }
    }

    @Override
    public boolean hasNext() {
        return listIndex < elements.size() && nestedListIndex < elements.get(listIndex).size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T result = elements.get(listIndex).get(nestedListIndex);

        if (++nestedListIndex == elements.get(listIndex).size()) {
            nestedListIndex = 0;
            listIndex++;
        }
        return result;
    }
}
