package lotto.view;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import lotto.Money;
import lotto.Number;

public class TestInputView extends InputView {

  private Money money;
  private List<Number> winNumbers;

  public TestInputView(Money money) {
    this.money = money;
  }

  public TestInputView(List<Number> winNumbers) {
    this.winNumbers = winNumbers;
  }

  @Override
  public Money inputPurchaseAmount() {
    return money;
  }

  @Override
  public List<Number> inputWinNumbers() {
    return winNumbers;
  }
}
