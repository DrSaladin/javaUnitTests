package streamMain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterMain {
  public static void main(List<Integer> intList) {
    List<Integer> processedList = new ArrayList<>();

    for(int item : intList) {
      if (item > 0 && item % 2 == 0) {
        processedList.add(item);
      }
    }
    Collections.sort(processedList);
    System.out.println(processedList);
  }
}
