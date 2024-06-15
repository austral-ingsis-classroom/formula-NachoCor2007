package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operands.Variable;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.operatortypes.DivisionOperator;
import edu.austral.ingsis.math.operators.operatortypes.ProductOperator;
import edu.austral.ingsis.math.operators.operatortypes.SumOperator;
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

    assertEquals(result, Collections.emptyList());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function twelve = new Constant(12);
    Function div = new Variable("div");
    OperatorType divOperator = new DivisionOperator();

    Function division = new Operator(twelve, div, divOperator);
    MathResolver mathResolver = new MathResolver(division);

    final List<String> result = mathResolver.getVariables();

    assertEquals(result, Collections.singletonList("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function nine = new Constant(9);
    Function x = new Variable("x");
    Variable why = new Variable("y");
    OperatorType divOperator = new DivisionOperator();
    OperatorType prodOperator = new ProductOperator();

    Function division = new Operator(nine, x, divOperator);
    Function product = new Operator(division, why, prodOperator);
    MathResolver mathResolver = new MathResolver(product);

    final List<String> result = mathResolver.getVariables();

    assertEquals(result, List.of("x", "y"));
  }

//  /** Case (27 / a) ^ b */
//  @Test
//  public void shouldListVariablesFunction4() {
//    final List<String> result = Collections.emptyList();
//
//    assertThat(result, containsInAnyOrder("a", "b"));
//  }
//
//  /** Case z ^ (1/2) */
//  @Test
//  public void shouldListVariablesFunction5() {
//    final List<String> result = Collections.emptyList();
//
//    assertThat(result, containsInAnyOrder("z"));
//  }
//
//  /** Case |value| - 8 */
//  @Test
//  public void shouldListVariablesFunction6() {
//    final List<String> result = Collections.emptyList();
//
//    assertThat(result, containsInAnyOrder("value"));
//  }
//
//  /** Case |value| - 8 */
//  @Test
//  public void shouldListVariablesFunction7() {
//    final List<String> result = Collections.emptyList();
//
//    assertThat(result, containsInAnyOrder("value"));
//  }
//
//  /** Case (5 - i) * 8 */
//  @Test
//  public void shouldListVariablesFunction8() {
//    final List<String> result = Collections.emptyList();
//
//    assertThat(result, containsInAnyOrder("i"));
//  }
}
