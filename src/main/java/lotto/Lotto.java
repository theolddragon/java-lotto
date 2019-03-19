package lotto;

import java.util.List;

public class Lotto {

  private List<Number> numbers;

  public Lotto(List<Number> numbers) {

    this.numbers = numbers;
  }

  public int winMatch(List<Number> winNumbers) {

    int matchCount = 0;

    for (Number lottoNumber : numbers) {
      for (Number winNumber : winNumbers) {
        if (lottoNumber.equals(winNumber)) {
          matchCount++;
        }
      }
    }

    return matchCount;
  }
}
