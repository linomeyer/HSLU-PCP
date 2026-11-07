package ch.hslu.pcp.week_8.e01;

public interface SpecificInterface extends GeneralInterface {
    default void doIt() {
        System.out.println("Do it the SPECIFIC way.");
    }
}
