package leetcode.y2020m05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiana  2020-05-06 17:54
 */
public class TestFilter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "abc", "abd", "av");
        list.stream()
                .filter(t->{
                    System.out.println(t);
                    return true;
                }).filter("abc"::equals).collect(Collectors.toList());
    }
}
