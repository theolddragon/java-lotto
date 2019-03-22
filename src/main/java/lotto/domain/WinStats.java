package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinStats {

  private List<WinCount> winCounts;

  private final List<Lotto> lottos;
  private final List<Integer> winNumbers;

  public WinStats() {
    this.lottos = new ArrayList<>();
    this.winNumbers = new ArrayList<>();
  }

  public WinStats(List<Lotto> lottos, List<Integer> winNumbers) {
    this.lottos = lottos;
    this.winNumbers = winNumbers;
  }

  public void total() {

    this.winCounts = Arrays.stream(Prizes.values())
        .map(prizes -> new WinCount(prizes, winCount(prizes)))
        .collect(Collectors.toList());
  }

  public List<WinCount> getWinCounts() {
    return this.winCounts;
  }

  private long winCount(Prizes prizes) {

    return this.lottos.stream()
        .filter(lotto -> lotto.winMatch(this.winNumbers) == prizes.getMatchCount())
        .count();
  }

  public Money getTotalWinMoney() {

    return this.winCounts.stream()
        .map(WinCount::getWinMoney)
        .reduce(Money::sum)
        .get();
  }

  public String yield(Money purchaseMoney) {
    return getTotalWinMoney().division(purchaseMoney);
  }

}
