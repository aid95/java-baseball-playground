package study.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    @Test
    void 플레이어가_입력한_공_묶음에_대한_결과를_반환한다() {
        BaseballGame baseballGame = new BaseballGame(Balls.fromString("123"));
        GameResult gameResult = baseballGame.play(Balls.fromString("132"));
        assertThat(gameResult.toString()).isEqualTo("스트라이크 : 1, 볼 : 2");
    }
}
