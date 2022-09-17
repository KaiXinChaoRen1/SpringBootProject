package com.lwq.springboot06_enable;



import com.lwq.config.MyImportSelector;
import com.lwq.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


/**
 * Import4中用法：
 *  1. 导入Bean
 *  2. 导入配置类
 *  3. 导入ImportSelector的实现类。（根据字符串数组，导入多个bean，所以我们可以利用外部配置文件，去动态加载）也是springboot底层的实现
 *  4. 导入ImportBeanDefinitionRegistrar实现类
 */
@SpringBootApplication      //只能扫其所在包及其子包
//@Import(User.class)   //可以直接把类加载进iod容器，id一般是全类名
//@Import(UserConfig.class)
@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
public class Springboot06EnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot06EnableApplication.class, args);

        User user = context.getBean(User.class);
        System.out.println(user);

    }

}
