package study.baseball.domain;

import java.util.Collections;
import java.util.List;

public class BaseballGame {

    private final Balls computerBalls;

    public BaseballGame(Balls initBalls) {
        this.computerBalls = initBalls;
    }

    public GameResult play(Balls userBalls) {
        int strike = computerBalls.matchStrike(userBalls);
        int ball = computerBalls.matchBall(userBalls);
        return new GameResult(strike, ball);
    }
}
