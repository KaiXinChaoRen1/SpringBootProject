package com.lwq.springboot02_init;

import org.cheffo.jeplite.JEP;
import org.cheffo.jeplite.util.DoubleStack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import parsii.tokenizer.ParseException;

@SpringBootTest
class Springboot02InitApplicationTests {

    @Test
    void name1() throws ParseException, org.cheffo.jeplite.ParseException {

        String exp = "2 * x^2+x^3";

// compile
        JEP jep = new JEP();
        jep.addVariable("x", 3);
        jep.parseExpression(exp);
        DoubleStack jepStack = new DoubleStack();

// evaluate
        double result = jep.getValue(jepStack);

        System.out.println(result);//-> 2.0
    }
}
