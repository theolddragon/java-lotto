package lotto;

import java.util.Objects;

public class Money {

  private int value;

  public Money(int value) {
    this.value = value;
  }

  public void add(Money threeMatchWinMoney) {
    this.value += threeMatchWinMoney.value;
  }

  public Money count(long winCount) {
    this.value *= winCount;
    return this;
  }

  public String division(Money winMoney) {
    return String.format("%.2f", (float)this.value / winMoney.value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return value == money.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value + "";
  }
}
