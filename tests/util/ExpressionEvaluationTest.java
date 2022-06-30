package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluationTest {

    @Test
    void evaluateTest() {
        String[] expressions = new String[] {"=1+1", "=1+(2-6)/4", "3*3/9", "", "2-5/2"};
        Double[] answers = new Double[] {2.0, 0.0, 1.0, 0.0, -0.5 };
        for (int i = 0; i < expressions.length; i++) {
            assertEquals(answers[i], ExpressionEvaluation.evaluate(expressions[i]));
        }
    }
}