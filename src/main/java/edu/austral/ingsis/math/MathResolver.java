package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record MathResolver(Function function) {

  public Optional<Double> resolve() {
    return this.resolveVariables(Map.of());
  }

  public Optional<Double> resolveVariables(Map<String, Double> variables) {
    return function.resolve(variables);
  }

  public List<String> getVariables() {
    return function.getVariables().stream().toList();
  }

  @Override
  public String toString() {
    return function.toString();
  }
}
