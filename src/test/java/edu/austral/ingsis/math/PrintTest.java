package edu.austral.ingsis.math;


import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operators.Sum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    Function sum = new Sum(new Constant(1), new Constant(6));
    MathResolver mathResolver = new MathResolver(sum);

    assertEquals(mathResolver.toString(), "1 + 6");
  }

//  /** Case 12 / 2 */
//  @Test
//  public void shouldPrintFunction2() {
//    final String expected = "12 / 2";
//    final String result = expected;
//
//    assertThat(result, equalTo(expected));
//  }
//
//  /** Case (9 / 2) * 3 */
//  @Test
//  public void shouldPrintFunction3() {
//    final String expected = "(9 / 2) * 3";
//    final String result = expected;
//
//    assertThat(result, equalTo(expected));
//  }
//
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
