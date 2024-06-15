package edu.austral.ingsis.math.operands;

import edu.austral.ingsis.math.Function;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Variable implements Function {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public Optional<Double> resolve(Map<String, Double> variables) {
    Double value = variables.get(name);
    if (value == null) {
      return Optional.empty();
    }
    return Optional.of(value);
  }

  @Override
  public Set<String> getVariables() {
    return Set.of(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
