package com.lwq.precious.p03_RegExp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RegExpTest {

    @Test
    public void name1(){
        String news=
                "两年前在顶上战争中解救了路飞和甚平，顶上战争后两年间成为“王下七武海”，后以挑战四皇中的凯多为目标与草帽一伙结为同盟而被剥夺七武海称号，" +
                "伺机向唐吉诃德家族完成复仇后开始追寻D之一族的77真相。在和之国联手基德击败了四皇之一的夏洛特·玲玲。";
        //pattern:样式,范例
        Pattern pattern = Pattern.compile("\\d\\d");
        Matcher matcher = pattern.matcher(news);
        while(matcher.find()){
            System.out.println("找到"+matcher.group(0));
        }


    }

}
