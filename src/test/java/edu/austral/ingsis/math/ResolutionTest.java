package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.operatortypes.DivisionOperator;
import edu.austral.ingsis.math.operators.operatortypes.PowerOperator;
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

    final Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertThat(result.get(), equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function twelve = new Constant(12);
    Function two = new Constant(2);
    OperatorType divOperator = new DivisionOperator();

    Function div = new Operator(twelve, two, divOperator);

    MathResolver mathResolver = new MathResolver(div);

    final Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertThat(result.get(), equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function nine = new Constant(9);
    Function two = new Constant(2);
    Function three = new Constant(3);
    OperatorType divOperator = new DivisionOperator();
    OperatorType prodOperator = new ProductOperator();

    Function div = new Operator(nine, two, divOperator);
    Function prod = new Operator(div, three, prodOperator);

    MathResolver mathResolver = new MathResolver(prod);

    final Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertThat(result.get(), equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function twentySeven = new Constant(27);
    Function six = new Constant(6);
    Function two = new Constant(2);
    OperatorType divOperator = new DivisionOperator();
    OperatorType powOperator = new PowerOperator();

    Function div = new Operator(twentySeven, six, divOperator);
    Function pow = new Operator(div, two, powOperator);

    MathResolver mathResolver = new MathResolver(pow);

    final Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertThat(result.get(), equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function thirtySix = new Constant(36);
    Function one = new Constant(1);
    Function two = new Constant(2);
    OperatorType powOperator = new PowerOperator();
    OperatorType divOperator = new DivisionOperator();

    Operator div = new Operator(one, two, divOperator);
    Function pow = new Operator(thirtySix, div, powOperator);

    MathResolver mathResolver = new MathResolver(pow);

    final Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertThat(result.get(), equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = 136d;

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = 136d;

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = 0d;

    assertThat(result, equalTo(0d));
  }
}
