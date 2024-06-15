package edu.austral.ingsis.math.operators.binaryoperations;

import edu.austral.ingsis.math.operators.OperatorType;

import java.util.Optional;

public class SubOperator implements OperatorType {
  @Override
  public Optional<Double> applyOperator(Double left, Double right) {
    return Optional.of(left - right);
  }

  @Override
  public String toString() {
    return " - ";
  }
}
