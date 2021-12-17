package study.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void 두_공_묶음을_비교해_스트라이크_개수를_구한다() {
        Balls balls1 = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));
        Balls balls2 = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));

        assertThat(balls1.matchStrike(balls2)).isEqualTo(3);
    }

    @Test
    void 두_공_묶음을_비교해_볼_개수를_구한다() {
        Balls balls1 = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));
        Balls balls2 = new Balls(Arrays.asList(new Ball(3), new Ball(2), new Ball(1)));

        assertThat(balls1.matchBall(balls2)).isEqualTo(2);
    }

    @Test
    void 공_묶음은_정확히_3개의_공을_가질_수_있다() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Balls(Arrays.asList(
                new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4)));
        }).withMessageMatching("3");
    }

    @Test
    void 공_묶음은_중복된_숫자는_하나로_처리된다() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Balls(Arrays.asList(
                new Ball(1),
                new Ball(1),
                new Ball(2))); // [1, 2]
        }).withMessageMatching("3");
    }

    @Test
    void 문자열을_공_묶음으로_생성() {
        Balls balls1 = Balls.fromString("123");
        Balls balls2 = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));

        assertThat(balls1.matchStrike(balls2)).isEqualTo(3);
    }
}
