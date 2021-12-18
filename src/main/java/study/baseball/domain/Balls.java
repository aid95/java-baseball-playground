package study.baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Balls {

    private final List<Ball> balls;
    private final int ballsNum;

    public Balls(List<Ball> balls) {
        this.balls = Collections.unmodifiableList(balls);
        this.ballsNum = getBallsNum(balls);

        if (validate()) {
            throw new IllegalArgumentException("3");
        }
    }

    public static Balls fromString(String s) {
        List<Ball> balls = new ArrayList<>();
        for (Character ch : s.toCharArray()) {
            balls.add(new Ball(ch - '0'));
        }
        return new Balls(balls);
    }

    private int getBallsNum(List<Ball> balls) {
        return (new HashSet<>(balls)).size();
    }

    private boolean validate() {
        return this.balls.size() != 3;
    }

    public int matchStrike(Balls other) {
        int result = 0;
        for (int i = 0; i < ballsNum; i++) {
            if (isBallMatch(other, i, i)) {
                result++;
            }
        }
        return result;
    }

    public int matchBall(Balls other) {
        int result = 0;
        for (int i = 0; i < ballsNum; i++) {
            for (int j = 0; j < ballsNum; j++) {
                if (i == j) continue;
                if (isBallMatch(other, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isBallMatch(Balls other, int pos, int otherPos) {
        return this.balls.get(pos).isMatch(other.balls.get(otherPos));
    }
}
