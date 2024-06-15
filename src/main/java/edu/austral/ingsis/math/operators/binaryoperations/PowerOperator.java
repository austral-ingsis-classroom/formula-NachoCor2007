package edu.austral.ingsis.math.operators.binaryoperations;

import edu.austral.ingsis.math.operators.OperatorType;
import java.util.Optional;

public class PowerOperator implements OperatorType {
  @Override
  public Optional<Double> applyOperator(Double left, Double right) {
    return Optional.of(Math.pow(left, right));
  }

  @Override
  public String toString() {
    return " ^ ";
  }
}
