package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operands.Constant;
import edu.austral.ingsis.math.operands.Variable;
import edu.austral.ingsis.math.operators.ModuleOperator;
import edu.austral.ingsis.math.operators.Operator;
import edu.austral.ingsis.math.operators.OperatorType;
import edu.austral.ingsis.math.operators.binaryoperations.*;
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
    Function variable = new Variable("value");
    Function eight = new Constant(8);
    OperatorType subOperator = new SubOperator();

    ModuleOperator mod = new ModuleOperator(variable);
    Function sub = new Operator(mod, eight, subOperator);

    MathResolver mathResolver = new MathResolver(sub);

    assertThat(mathResolver.toString(), equalTo("|value| - 8"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    Function variable = new Variable("value");
    Function eight = new Constant(8);
    OperatorType subOperator = new SubOperator();

    ModuleOperator mod = new ModuleOperator(variable);
    Function sub = new Operator(mod, eight, subOperator);

    MathResolver mathResolver = new MathResolver(sub);

    assertThat(mathResolver.toString(), equalTo("|value| - 8"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    Function five = new Constant(5);
    Function i = new Variable("i");
    Function eight = new Constant(8);
    OperatorType subOperator = new SubOperator();
    OperatorType prodOperator = new ProductOperator();

    Function sub = new Operator(five, i, subOperator);
    Function prod = new Operator(sub, eight, prodOperator);

    MathResolver mathResolver = new MathResolver(prod);

    assertThat(mathResolver.toString(), equalTo("(5 - i) * 8"));
  }
}
