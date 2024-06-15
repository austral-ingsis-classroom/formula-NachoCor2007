package edu.austral.ingsis.math.operands;

import edu.austral.ingsis.math.Function;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Constant implements Function {
  private final double value;

  public Constant(double value) {
    this.value = value;
  }

  @Override
  public Optional<Double> resolve(Map<String, Double> variables) {
    return Optional.of(this.value);
  }

  @Override
  public Set<String> getVariables() {
    return Set.of();
  }

  @Override
  public String toString() {
    return trimZeroes(this.value);
  }

  private String trimZeroes(Double number) {
    return BigDecimal.valueOf(number).stripTrailingZeros().toPlainString();
  }
}
