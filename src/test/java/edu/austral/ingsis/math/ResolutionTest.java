package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.operatortypes.DivisionOperator;
import edu.austral.ingsis.math.operators.operatortypes.ProductOperator;
import edu.austral.ingsis.math.operators.operatortypes.SumOperator;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function one = new Constant(1);
    Function six = new Constant(6);
    OperatorType sumOperator = new SumOperator();

    Function sum = new Operator(one, six, sumOperator);
    MathResolver mathResolver = new MathResolver(sum);

    Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertEquals(result.get(), 7d);
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function twelve = new Constant(12);
    Function two = new Constant(2);
    OperatorType divisionOperator = new DivisionOperator();

    Function division = new Operator(twelve, two, divisionOperator);
    MathResolver mathResolver = new MathResolver(division);

    Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertEquals(result.get(), 6d);
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function nine = new Constant(9);
    Function two = new Constant(2);
    Function three = new Constant(3);
    OperatorType divisionOperator = new DivisionOperator();
    OperatorType productOperator = new ProductOperator();

    Function division = new Operator(nine, two, divisionOperator);
    Function product = new Operator(division, three, productOperator);
    MathResolver mathResolver = new MathResolver(product);

    Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertEquals(result.get(), 13.5d);
  }

//  /** Case (27 / 6) ^ 2 */
//  @Test
//  public void shouldResolveSimpleFunction4() {
//    final Double result = 20.25;
//
//    assertThat(result, equalTo(20.25d));
//  }
//
//  /** Case 36 ^ (1/2) */
//  @Test
//  public void shouldResolveSimpleFunction5() {
//    final Double result = 6d;
//
//    assertThat(result, equalTo(6d));
//  }
//
//  /** Case |136| */
//  @Test
//  public void shouldResolveSimpleFunction6() {
//    final Double result = 136d;
//
//    assertThat(result, equalTo(136d));
//  }
//
//  /** Case |-136| */
//  @Test
//  public void shouldResolveSimpleFunction7() {
//    final Double result = 136d;
//
//    assertThat(result, equalTo(136d));
//  }
//
//  /** Case (5 - 5) * 8 */
//  @Test
//  public void shouldResolveSimpleFunction8() {
//    final Double result = 0d;
//
//    assertThat(result, equalTo(0d));
//  }
}
