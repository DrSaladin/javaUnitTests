import populationCensus.CensusExecution;
import streamMain.FilterMain;
import streamMain.StreamMain;
import java.util.*;

public class Main {
  public static List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
  public static long underagePeopleNumber;
  public static List<String> militaryServiceLiableList = new ArrayList<>();
  public static List<String> workforce = new ArrayList<>();

  public static void main(String[] args) {
    FilterMain.main(intList);
    StreamMain.main(intList);

    CensusExecution censusExecution = new CensusExecution();
    underagePeopleNumber = censusExecution.getUnderagePeopleNumber();
    militaryServiceLiableList = censusExecution.getMilitaryServiceLiableList();


    System.out.println(underagePeopleNumber);
    System.out.println(militaryServiceLiableList);
    System.out.println(workforce);
  }
}
