package ch.hslu.pcp.stack;

public class Stack {
    private Element top;
    private int index;

    public Stack() {
        this.top = null;
        this.index = 0;
    }

    public void push(Element e) {
        index++;
        if (this.top != null) {
            e.setNext(this.top);
        }
        this.top = e;
    }

    public Element top() {
        return top;
    }

    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        index--;
        this.top = top.getNext();
        return true;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("print = Stack is empty");
            return;
        }

        System.out.print("print = Stack contains: ");
        Element e = top;
        while (e != null) {
            System.out.print(e.getValue() + ", ");
            e = e.getNext();
        }
        System.out.println("top Element = " + top.getValue());
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return index;
    }

    /**
     * b) Clear makes sense here. Only way to clear manually would be to pop in a loop
     */
    public void clear() {
        this.top = null;
        this.index = 0;
    }
}
