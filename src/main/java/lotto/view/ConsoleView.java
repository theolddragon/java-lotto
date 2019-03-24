package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinNumbers;
import lotto.domain.WinStats;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    int insertMoney = consoleInputView.inputPurchaseAmount();
    MyLottos myLottos = buyLottos(insertMoney);

    String inputWinNumbers = consoleInputView.inputWinNumbers();
    String inputAdditionNumber = consoleInputView.inputWinNumbers();
    WinNumbers winNumbers = winNumbers(inputWinNumbers, inputAdditionNumber);

    winState(myLottos, winNumbers);
  }

  private static void winState(MyLottos myLottos, WinNumbers winNumber) {

    ConsoleResultView.printResultTitle();

    WinStats winStats = myLottos.winStats(winNumber);
    ConsoleResultView.printMatchWinCount(winStats);

    String yield = winStats.yield();
    ConsoleResultView.printYield(yield);
  }

  private static MyLottos buyLottos(int insertMoney) {

    Money buyMoney = new Money(insertMoney);
    List<Lotto> lottos = LottoStore.buy(buyMoney);
    for (Lotto lotto : lottos) {
      ConsoleResultView.printIssueLottoNumbers(lotto);
    }

    return new MyLottos(buyMoney, lottos);

  }

  private static WinNumbers winNumbers(String inputWinNumbers, String inputAdditionNumber) {

    String[] winNumberArray = inputWinNumbers.split(",");
    Set<LottoNumber> winNumbers = Arrays.stream(winNumberArray)
        .map(winNumber -> LottoNumber.getInstance(Integer.parseInt(winNumber.trim())))
        .collect(Collectors.toSet());

    LottoNumber additionalNumber = LottoNumber.getInstance(Integer.parseInt(inputAdditionNumber.trim()));
    return new WinNumbers(winNumbers, additionalNumber);
  }
}
