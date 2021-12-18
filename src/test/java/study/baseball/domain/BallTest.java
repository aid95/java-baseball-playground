package study.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {

  @Test
  void 두_공을_비교한다() {
    Ball ball1 = new Ball(1);
    Ball ball2 = new Ball(1);

    boolean result = ball1.isMatch(ball2);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 10})
  void 공은_1_부터_9_까지의_수를_가진다(int value) {
    assertThatThrownBy(() -> new Ball(value)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1~9");
  }
}
