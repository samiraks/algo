
public class MinStackImpl implements MinStack<Integer> {

    // Узел односвязного списка — вложенный класс
    private static class StackNode {
        int value;
        int minSoFar;   // минимум от дна стека до этого узла включительно
        StackNode next; // ссылка на следующий узел

        StackNode(int value, int minSoFar) {
            this.value = value;
            this.minSoFar = minSoFar;
        }
    }

    private StackNode head;   // вершина стека — голова списка

    @Override
    public void push(Integer value) {
        int newMin = (head == null) ? value : Math.min(value, head.minSoFar);
        StackNode node = new StackNode(value, newMin);
        node.next = head;
        head = node;
    }

    @Override
    public Integer pop() {
        int result = head.value;
        head = head.next;
        return result;
    }

    @Override
    public Integer top() {

        return head.value;
    }

    @Override
    public Integer min() {

        return head.minSoFar;
    }
}