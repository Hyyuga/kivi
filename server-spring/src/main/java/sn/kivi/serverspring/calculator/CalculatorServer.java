/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.calculator;

import com.canoo.dolphin.server.spring.DolphinPlatformApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//@EnableAutoConfiguration(exclude = {JndiConnectionFactoryAutoConfiguration.class,DataSourceAutoConfiguration.class,
//                                    HibernateJpaAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})

@DolphinPlatformApplication
//@ComponentScan("sn.kivi.server.calculator.controller")
public class CalculatorServer extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
//        EmbeddedDriver driver = new EmbeddedDriver();
//        driver.toString();
//       Class.forName("com.apache.derby.jdbc.ClientDriver");
        SpringApplication.run(new Class[]{CalculatorServer.class}, args);
    }
}
