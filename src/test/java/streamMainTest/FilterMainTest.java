package streamMainTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streamMain.FilterMain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterMainTest {
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final PrintStream standardOut = System.out;

  @BeforeEach
  public void beforeEach() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void afterEach() {
    System.setOut(standardOut);
  }

  @Test
  public void main() {
    List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
    FilterMain.main(intList);
    assertEquals("[2, 4, 8, 16, 32]", outputStreamCaptor.toString().trim());
  }
}
