package kz.akello.bitlab.FirstSpring.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "prototype")//делает так, что бы конструктор вызывался каждому по отдельности
//@Scope(value = "singleton")//делает так, что бы конструктор вызывался только один раз каждому(default)
@Getter
@Setter
public class TestA {

    public TestA(){
        System.out.println("Creating an object of Test A");
        this.name = "Any Possible Name";
        this.price = 1500;
    }

    public TestA(String name){
        System.out.println("Creating an parametrized constructor");
        this.name = "Any Possible Name";
    }

    private String name;
    private int price;
}
