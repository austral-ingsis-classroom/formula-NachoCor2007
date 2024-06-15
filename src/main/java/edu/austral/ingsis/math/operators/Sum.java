package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Function;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Sum implements Function {
  private final Function left;
  private final Function right;

  public Sum(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Optional<Double> resolve(Map<String, Double> variables) {
    Optional<Double> leftResult = left.resolve(variables);
    Optional<Double> rightResult = right.resolve(variables);

    boolean areValuesInvalid = leftResult.isEmpty() || rightResult.isEmpty();
    if (areValuesInvalid) {
      return Optional.empty();
    }

    Double leftValue = leftResult.get();
    Double rightValue = rightResult.get();
    return Optional.of(leftValue + rightValue);
  }

  @Override
  public Set<String> getVariables() {
    Set<String> variables = new HashSet<>(Set.of());
    variables.addAll(left.getVariables());
    variables.addAll(right.getVariables());
    return variables;
  }

  @Override
  public String toString() {
    return left.toString() + " + " + right.toString();
  }
}
