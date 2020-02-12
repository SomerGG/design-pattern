package cn.xysomer.create.prototype;

import cn.xysomer.create.prototype.simple.Prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {

    public static void main(String[] args) throws Exception {
        Prototype prototype = new Prototype();
        prototype.setName("Somer");
        prototype.setAge(25);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("sleep");
        hobbies.add("computer");
        prototype.setHobbies(hobbies);

        Prototype copy = prototype.clone();

        System.out.println(prototype.getAge() == copy.getAge());
        System.out.println(prototype.getHobbies() == copy.getHobbies());
    }
}
