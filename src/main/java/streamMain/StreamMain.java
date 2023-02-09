package streamMain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

  public StreamMain() {}
  public static void main(List<Integer> intList) {
    filterByStream(intList);
  }

  public static void filterByStream(List<Integer> intList) {
    System.out.println(intList.stream()
      .filter(x -> x > 0)
      .filter(x -> x % 2 == 0)
      .sorted(Comparator.naturalOrder())
      .collect(Collectors.toList())
    );
  }
}
