package study.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallTest {

  @Test
  void testCompareTwoSlot() {
    Ball ball1 = new Ball(1);
    Ball ball2 = new Ball(1);

    boolean result = ball1.equals(ball2);

    assertThat(result).isTrue();
  }

  @Test
  void testInvalidValueSlot() {
    assertThatThrownBy(() -> {
      new Ball(10);
    }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1~9");
  }
}
