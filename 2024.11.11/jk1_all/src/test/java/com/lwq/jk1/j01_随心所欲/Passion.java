package com.lwq.jk1.j01_随心所欲;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class Passion {

    @Test
    public void a2() {
        long t1 = System.currentTimeMillis();
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (int i = 0; i < 10000000; i++) {
            arrayList.add(0.2);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    @Test
    public void a1() {

        long t3 = System.currentTimeMillis();
        ArrayList<Double> list = new ArrayList<Double>(10000000);
        for (int i = 0; i < 10000000; i++) {
            list.add(0.2);
        }
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);

    }

    @Test
    public void name4() {

        System.out.println("888");

        Optional<String> o = Optional.of("23");
        System.out.println(o.get());
        o.orElseThrow(() -> new RuntimeException(""));
    }

}
