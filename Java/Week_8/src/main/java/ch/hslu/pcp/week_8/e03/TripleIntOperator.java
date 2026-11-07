package ch.hslu.pcp.week_8.e03;

@FunctionalInterface // Compiler checks: exactly 1 SAM method
public interface TripleIntOperator<A, B, C> {
    // Operator = gleicher Typ beim Input wie als auch Output => int, int, int -> int
    int applyAsInt(int a, int b, int c); // Naming convention: applyAs{Type} or apply if generic
}
