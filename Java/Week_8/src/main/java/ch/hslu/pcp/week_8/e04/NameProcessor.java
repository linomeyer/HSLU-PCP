package ch.hslu.pcp.week_8.e04;

import java.util.Arrays;

public class NameProcessor {
    void main() {
        System.out.println(processNames(new String[]{"Susanna", "Joe", "Lu", "Timmy", "Rafael", "Lisa"}));
    }

    public String processNames(String[] names) {
        return Arrays.stream(names)
                .filter(name -> name.length() >= 3 && name.length() <= 4)
                .map(String::toUpperCase)
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }
}
