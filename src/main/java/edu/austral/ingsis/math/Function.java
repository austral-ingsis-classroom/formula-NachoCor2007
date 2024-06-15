package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface Function {
  Optional<Double> resolve(Map<String, Double> variables);
  Set<String> getVariables();
}
