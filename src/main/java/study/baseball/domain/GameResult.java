package study.baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return "Nothing";
        }
        return getReport();
    }

    private String getReport() {
        List<String> result = new ArrayList<>();
        if (strike != 0) {
            result.add(getRowResult("스트라이크", this.strike));
        }
        if (ball != 0) {
            result.add(getRowResult("볼", this.ball));
        }
        return String.join(", ", result);
    }

    private String getRowResult(String type, int score) {
        return String.format("%s : %d", type, score);
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
