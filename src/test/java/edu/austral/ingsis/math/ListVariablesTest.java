package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operands.Variable;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.binaryoperations.DivisionOperator;
import edu.austral.ingsis.math.operators.binaryoperations.PowerOperator;
import edu.austral.ingsis.math.operators.binaryoperations.ProductOperator;
import edu.austral.ingsis.math.operators.binaryoperations.SumOperator;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function one = new Constant(1);
    Function six = new Constant(6);
    OperatorType sumOperator = new SumOperator();

    Function sum = new Operator(one, six, sumOperator);
    MathResolver mathResolver = new MathResolver(sum);

    final List<String> result = mathResolver.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function twelve = new Constant(12);
    Function variable = new Variable("div");
    OperatorType divOperator = new DivisionOperator();

    Function div = new Operator(twelve, variable, divOperator);

    MathResolver mathResolver = new MathResolver(div);

    final List<String> result = mathResolver.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function nine = new Constant(9);
    Function firstVariable = new Variable("x");
    Function secondVariable = new Variable("y");
    OperatorType divOperator = new DivisionOperator();
    OperatorType prodOperator = new ProductOperator();

    Function div = new Operator(nine, firstVariable, divOperator);
    Function prod = new Operator(div, secondVariable, prodOperator);

    MathResolver mathResolver = new MathResolver(prod);

    final List<String> result = mathResolver.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function twentySeven = new Constant(27);
    Function firstVariable = new Variable("a");
    Function secondVariable = new Variable("b");
    OperatorType divOperator = new DivisionOperator();
    OperatorType powOperator = new PowerOperator();

    Function div = new Operator(twentySeven, firstVariable, divOperator);
    Function pow = new Operator(div, secondVariable, powOperator);

    MathResolver mathResolver = new MathResolver(pow);

    final List<String> result = mathResolver.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function z = new Variable("z");
    Function one = new Constant(1);
    Function two = new Constant(2);
    OperatorType powOperator = new PowerOperator();
    OperatorType divOperator = new DivisionOperator();

    Operator div = new Operator(one, two, divOperator);
    Function pow = new Operator(z, div, powOperator);

    MathResolver mathResolver = new MathResolver(pow);

    final List<String> result = mathResolver.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("i"));
  }
}
