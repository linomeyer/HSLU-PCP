package ch.hslu.pcp.week_8.e03;

public class Main {
    void main() {
        TripleIntOperator<Integer, Integer, Integer> tio = (a, b, c) -> a + b + c;

        System.out.println(tio.applyAsInt(1, 2, 3));
    }
}
