package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.operatortypes.DivisionOperator;
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

    assertEquals(mathResolver.toString(), "1 + 6");
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    Function twelve = new Constant(12);
    Function two = new Constant(2);
    OperatorType divisionOperator = new DivisionOperator();

    Function division = new Operator(twelve, two, divisionOperator);
    MathResolver mathResolver = new MathResolver(division);

    assertEquals(mathResolver.toString(), "12 / 2");
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Function nine = new Constant(9);
    Function two = new Constant(2);
    Function three = new Constant(3);
    OperatorType divisionOperator = new DivisionOperator();
    OperatorType productOperator = new ProductOperator();

    Function division = new Operator(nine, two, divisionOperator);
    Function product = new Operator(division, three, productOperator);
    MathResolver mathResolver = new MathResolver(product);

    assertEquals(mathResolver.toString(), "(9 / 2) * 3");
  }

//  /** Case (27 / 6) ^ 2 */
//  @Test
//  public void shouldPrintFunction4() {
//    final String expected = "(27 / 6) ^ 2";
//    final String result = expected;
//
//    assertThat(result, equalTo(expected));
//  }
//
//  /** Case |value| - 8 */
//  @Test
//  public void shouldPrintFunction6() {
//    final String expected = "|value| - 8";
//    final String result = expected;
//
//    assertThat(result, equalTo(expected));
//  }
//
//  /** Case |value| - 8 */
//  @Test
//  public void shouldPrintFunction7() {
//    final String expected = "|value| - 8";
//    final String result = expected;
//
//    assertThat(result, equalTo(expected));
//  }
//
//  /** Case (5 - i) * 8 */
//  @Test
//  public void shouldPrintFunction8() {
//    final String expected = "(5 - i) * 8";
//    final String result = expected;
//
//    assertThat(result, equalTo(expected));
//  }
}
