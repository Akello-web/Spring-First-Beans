package kz.akello.bitlab.FirstSpring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(value = "testB-one")//если два одинаковых метода для тест Б, то нужно прописать значение
    public TestB testB(){//но, название метода по умолчанию и есть название объекта
        TestB testB = new TestB("Aqyl", 56.5);
        testB.setCode("Akello");
        return testB;
    }

    @Bean(value = "testB-two")
    public TestB testBa(){
        TestB testB = new TestB("Akyl", 70.5);
        return testB;
    }

}
