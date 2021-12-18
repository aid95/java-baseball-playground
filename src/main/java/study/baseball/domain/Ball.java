package study.baseball.domain;

import java.util.Objects;

public class Ball {

  private final int value;

  public Ball(int value) {
    this.value = value;

    validate();
  }

  private void validate() {
    if (this.value < 1 || 9 < this.value) {
      throw new IllegalArgumentException("1~9");
    }
  }

  public boolean isMatch(Ball other) {
    return this.value == other.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
