package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Function;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ModuleOperator implements Function {
  private final Function displacement;

  public ModuleOperator(Function displacement) {
    this.displacement = displacement;
  }

  @Override
  public Optional<Double> resolve(Map<String, Double> variables) {
    Optional<Double> displacementResult = displacement.resolve(variables);

    if (displacementResult.isEmpty()) {
      return Optional.empty();
    }

    Double displacementValue = displacementResult.get();
    return applyOperation(displacementValue);
  }

  private Optional<Double> applyOperation(Double displacementValue) {
    return Optional.of(Math.abs(displacementValue));
  }

  @Override
  public Set<String> getVariables() {
    return displacement.getVariables();
  }

  @Override
  public String toString() {
    return "|" + displacement.toString() + "|";
  }
}
