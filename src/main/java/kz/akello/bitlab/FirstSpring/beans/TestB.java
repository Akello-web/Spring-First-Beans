package kz.akello.bitlab.FirstSpring.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestB {

    public TestB(){
        System.out.println("Using default of Test B");
    }

    public TestB(String code, double volume){
        this.code = code;
        this.volume = volume;
        System.out.println("Using parametrized of Test B");
    }

    private double volume;
    private String code;
}
