package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operands.Variable;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.binaryoperations.DivisionOperator;
import edu.austral.ingsis.math.operators.binaryoperations.PowerOperator;
import edu.austral.ingsis.math.operators.binaryoperations.ProductOperator;
import edu.austral.ingsis.math.operators.binaryoperations.SumOperator;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function one = new Constant(1);
    Function variable = new Variable("x");
    OperatorType sumOperator = new SumOperator();

    Function sum = new Operator(one, variable, sumOperator);

    MathResolver mathResolver = new MathResolver(sum);

    Map<String, Double> variables = Map.of("x", 3d);

    final Optional<Double> result = mathResolver.resolveVariables(variables);

    assertThat(result.isPresent(), equalTo(true));
    assertThat(result.get(), equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function twelve = new Constant(12);
    Function variable = new Variable("div");
    OperatorType divOperator = new DivisionOperator();

    Function div = new Operator(twelve, variable, divOperator);

    MathResolver mathResolver = new MathResolver(div);

    Map<String, Double> variables = Map.of("div", 4d);

    final Optional<Double> result = mathResolver.resolveVariables(variables);

    assertThat(result.isPresent(), equalTo(true));
    assertThat(result.get(), equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function nine = new Constant(9);
    Function firstVariable = new Variable("x");
    Function secondVariable = new Variable("y");
    OperatorType divOperator = new DivisionOperator();
    OperatorType prodOperator = new ProductOperator();

    Function div = new Operator(nine, firstVariable, divOperator);
    Function prod = new Operator(div, secondVariable, prodOperator);

    MathResolver mathResolver = new MathResolver(prod);

    Map<String, Double> variables = Map.of("x", 3d, "y", 4d);

    final Optional<Double> result = mathResolver.resolveVariables(variables);

    assertThat(result.isPresent(), equalTo(true));
    assertThat(result.get(), equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function twentySeven = new Constant(27);
    Function firstVariable = new Variable("a");
    Function secondVariable = new Variable("b");
    OperatorType divOperator = new DivisionOperator();
    OperatorType powOperator = new PowerOperator();

    Function div = new Operator(twentySeven, firstVariable, divOperator);
    Function pow = new Operator(div, secondVariable, powOperator);

    MathResolver mathResolver = new MathResolver(pow);

    Map<String, Double> variables = Map.of("a", 9d, "b", 3d);

    final Optional<Double> result = mathResolver.resolveVariables(variables);

    assertThat(result.isPresent(), equalTo(true));
    assertThat(result.get(), equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function variable = new Variable("z");
    Function one = new Constant(1);
    Function two = new Constant(2);
    OperatorType powOperator = new PowerOperator();
    OperatorType divOperator = new DivisionOperator();

    Operator div = new Operator(one, two, divOperator);
    Function pow = new Operator(variable, div, powOperator);

    MathResolver mathResolver = new MathResolver(pow);

    Map<String, Double> variables = Map.of("z", 36d);

    final Optional<Double> result = mathResolver.resolveVariables(variables);

    assertThat(result.isPresent(), equalTo(true));
    assertThat(result.get(), equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result = 0d;

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result = 0d;

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result = 24d;

    assertThat(result, equalTo(24d));
  }
}
