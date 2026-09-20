package ch.hslu.pcp.stack;

public class Element {
    private final int value;
    private Element next;

    public Element(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
