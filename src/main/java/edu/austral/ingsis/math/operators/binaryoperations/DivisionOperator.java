package edu.austral.ingsis.math.operators.binaryoperations;

import edu.austral.ingsis.math.operators.OperatorType;

import java.util.Optional;

public class DivisionOperator implements OperatorType {
  @Override
  public Optional<Double> applyOperator(Double left, Double right) {
    if (right == 0) {
      return Optional.empty();
    }

    return Optional.of(left / right);
  }

  @Override
  public String toString() {
    return " / ";
  }
}
