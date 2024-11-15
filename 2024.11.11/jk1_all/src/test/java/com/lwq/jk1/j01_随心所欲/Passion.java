package com.lwq.jk1.j01_随心所欲;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class Passion {

    @Test
    public void name4() {

        System.out.println("888");

        Optional<String> o = Optional.of("23");
        System.out.println(o.get());
        o.orElseThrow(() -> new RuntimeException(""));
    }

}
