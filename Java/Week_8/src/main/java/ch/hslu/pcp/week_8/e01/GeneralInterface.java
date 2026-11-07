package ch.hslu.pcp.week_8.e01;

public interface GeneralInterface {
    default void doIt() {
        System.out.println("Do it the GENERAL way.");
    }
}
