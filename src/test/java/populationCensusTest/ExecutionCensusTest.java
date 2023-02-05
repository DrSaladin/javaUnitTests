package populationCensusTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import populationCensus.CensusExecution;
import populationCensus.Person;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static populationCensus.Education.ELEMENTARY;
import static populationCensus.Education.HIGHER;
import static populationCensus.Sex.MAN;
import static populationCensus.Sex.WOMAN;


public class ExecutionCensusTest {
  private CensusExecution censusExecution;
  private ArrayList<Person> underagePeopleList;
  private ArrayList<Person> militaryServiceLiableList;
  private ArrayList<Person> workforceList;

  @BeforeEach
  public void getClassInstance() {
    censusExecution = new CensusExecution();
    underagePeopleList = new ArrayList<Person>(Arrays.asList(
      new Person("placeholder", "placeholder", 19, WOMAN, ELEMENTARY),
      new Person("placeholder", "placeholder", 18, WOMAN, ELEMENTARY),
      new Person("placeholder", "placeholder", 17, WOMAN, ELEMENTARY)
    ));
    militaryServiceLiableList = new ArrayList<Person>(Arrays.asList(
      new Person("placeholder", "placeholder", 19, MAN, ELEMENTARY),
      new Person("placeholder", "placeholder", 18, MAN, ELEMENTARY),
      new Person("placeholder", "placeholder", 17, MAN, ELEMENTARY),
      new Person("placeholder", "placeholder", 28, MAN, ELEMENTARY)
    ));
    workforceList = new ArrayList<Person>(Arrays.asList(
      new Person("placeholder", "placeholder", 64, MAN, HIGHER),
      new Person("placeholder", "placeholder", 66, MAN, ELEMENTARY),
      new Person("placeholder", "placeholder", 59, WOMAN, HIGHER),
      new Person("placeholder", "placeholder", 61, WOMAN, ELEMENTARY)
    ));
  }

  @AfterEach
  public void nullifyClassInstance() {
    censusExecution = null;
    underagePeopleList = null;
    militaryServiceLiableList = null;
    workforceList = null;
  }

  @Test
  public void getUnderagePeopleNumberCheck() {
    assertTrue(0 < censusExecution.getUnderagePeopleNumber(),
      "Некорректный подсчет количества лиц до 18 лет. Возвращает нуль или меньше нуля");
   }

  @Test
  public void getUnderagePeopleNumberQuantityCheck() {
    assertEquals(1, censusExecution.getUnderagePeopleNumber(underagePeopleList),
      "Некорректный подсчет количества лиц до 18 лет. Должен вернуть 1");
  }

  @Test
  public void getMilitaryServiceLiableListCheck() {
    assertFalse(censusExecution.getMilitaryServiceLiableList().isEmpty(),
      "Некорректная подготовка списка военнообязаных. Список пустой");
  }

  @Test
  public void getMilitaryServiceLiableListSizeCheck() {
    assertEquals(2, censusExecution.getMilitaryServiceLiableList(militaryServiceLiableList).size(),
      "Некорректный размер списка военнообязаных. В списке должен быть один человек");
  }

  @Test
  public void getWorkforceCheck() {
    assertFalse(censusExecution.getWorkforce().isEmpty(),
      "Некорректная подготовка списка трудоспособных. Список пустой");
  }

  @Test
  public void getWorkforceSizeCheck() {
    assertEquals(2, censusExecution.getWorkforce(workforceList).size(),
      "Некорректный размер списка трудоспособных. В списке должно быть два человека");
  }
}

