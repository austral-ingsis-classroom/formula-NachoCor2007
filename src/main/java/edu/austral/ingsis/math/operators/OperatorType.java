package edu.austral.ingsis.math.operators;

import java.util.Optional;

public interface OperatorType {
  Optional<Double> applyOperator(Double left, Double right);
}
