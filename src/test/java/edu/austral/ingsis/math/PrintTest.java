package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.operatortypes.DivisionOperator;
import edu.austral.ingsis.math.operators.operatortypes.PowerOperator;
import edu.austral.ingsis.math.operators.operatortypes.ProductOperator;
import edu.austral.ingsis.math.operators.operatortypes.SumOperator;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    Function one = new Constant(1);
    Function six = new Constant(6);
    OperatorType sumOperator = new SumOperator();

    Function sum = new Operator(one, six, sumOperator);
    MathResolver mathResolver = new MathResolver(sum);

    assertThat(mathResolver.toString(), equalTo("1 + 6"));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    Function twelve = new Constant(12);
    Function two = new Constant(2);
    OperatorType divOperator = new DivisionOperator();

    Function div = new Operator(twelve, two, divOperator);

    MathResolver mathResolver = new MathResolver(div);

    assertThat(mathResolver.toString(), equalTo("12 / 2"));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Function nine = new Constant(9);
    Function two = new Constant(2);
    Function three = new Constant(3);
    OperatorType divOperator = new DivisionOperator();
    OperatorType prodOperator = new ProductOperator();

    Function div = new Operator(nine, two, divOperator);
    Function prod = new Operator(div, three, prodOperator);

    MathResolver mathResolver = new MathResolver(prod);

    assertThat(mathResolver.toString(), equalTo("(9 / 2) * 3"));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Function twentySeven = new Constant(27);
    Function six = new Constant(6);
    Function two = new Constant(2);
    OperatorType divOperator = new DivisionOperator();
    OperatorType powOperator = new PowerOperator();

    Function div = new Operator(twentySeven, six, divOperator);
    Function pow = new Operator(div, two, powOperator);

    MathResolver mathResolver = new MathResolver(pow);

    assertThat(mathResolver.toString(), equalTo("(27 / 6) ^ 2"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final String result = expected;

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final String result = expected;

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final String result = expected;

    assertThat(result, equalTo(expected));
  }
}
