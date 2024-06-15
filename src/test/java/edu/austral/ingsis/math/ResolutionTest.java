package edu.austral.ingsis.math;


import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operators.Sum;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function sum = new Sum(new Constant(1), new Constant(6));
    MathResolver mathResolver = new MathResolver(sum);

    Optional<Double> result = mathResolver.resolve();

    assertTrue(result.isPresent());
    assertEquals(result.get(), 7d);
  }

//  /** Case 12 / 2 */
//  @Test
//  public void shouldResolveSimpleFunction2() {
//    final Double result = 6d;
//
//    assertThat(result, equalTo(6d));
//  }
//
//  /** Case (9 / 2) * 3 */
//  @Test
//  public void shouldResolveSimpleFunction3() {
//    final Double result = 13.5;
//
//    assertThat(result, equalTo(13.5d));
//  }
//
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
