package com.lwq.precious.p03_RegExp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RegExpTest {

    @Test
    public void name1(){
        String news="特拉法尔加·罗（全名“特拉法尔加·D·瓦铁尔·罗”。“D”是隐名，”瓦铁尔“是讳名），日本漫画《航海王》及其衍生作品中的角色。" +
                "心脏海贼团船长，极恶的世代之一，手术果实能力者，绰号“死亡外科医生”，悬赏金30亿贝里。" +
                "出生于“白色城镇”，小时候感染了珀铅病，经历了至亲惨死的痛楚后为了报复世界而在10岁时加入了唐吉诃德家族，后被恩人唐吉诃德·罗西南迪所救并被其感化，" +
                "13岁时脱离唐吉诃德家族，后创立心脏海贼团而名扬天下。" +
                "两年前在顶上战争中解救了路飞和甚平，顶上战争后两年间成为“王下七武海”，后以挑战四皇中的凯多为目标与草帽一伙结为同盟而被剥夺七武海称号，" +
                "伺机向唐吉诃德家族完成复仇后开始追寻D之一族的真相。在和之国联手基德击败了四皇之一的夏洛特·玲玲。";
        //pattern:样式,范例
        Pattern pattern = Pattern.compile("\\d\\d");
        Matcher matcher = pattern.matcher(news);
        while(matcher.find()){
            System.out.println("找到"+matcher.group(0));
        }


    }

}
