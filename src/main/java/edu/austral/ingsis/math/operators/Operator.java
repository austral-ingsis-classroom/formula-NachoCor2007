package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Function;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Operator implements Function {
  private final Function left;
  private final Function right;
  private final OperatorType operation;

  public Operator(Function left, Function right, OperatorType operation) {
    this.left = left;
    this.right = right;
    this.operation = operation;
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
    return operation.applyOperator(leftValue, rightValue);
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
    String leftString = formatString(left);
    String rightString = formatString(right);

    return leftString + operation.toString() + rightString;
  }

  private String formatString(Function function) {
    String stringFunction = function.toString();
    if (function instanceof Operator) {
      return "(" + stringFunction + ")";
    }
    return stringFunction;
  }
}
