import java.util.EmptyStackException;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 */
public class StackGetMin {
    private final Stack<Integer> stack = new Stack<>();
    private Integer min = null;

    public int push(Integer item) {
        if (stack.isEmpty()) {
            min = item;
            return stack.push(item);
        }

        if (item < min) {
            Integer result = stack.push(2 * item - min);
            min = item;
            return result;
        } else {
            return stack.push(item);
        }
    }

    public int pop() {
        Integer pop = stack.pop();
        if (pop < min) {
            int result = min;
            min = 2 * min - pop;
            return result;
        }
        return pop;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return min;
    }
}
