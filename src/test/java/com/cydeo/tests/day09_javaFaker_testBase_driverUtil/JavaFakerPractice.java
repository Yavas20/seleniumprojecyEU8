package com.cydeo.tests.day09_javaFaker_testBase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){

        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"544-###-####\") = " + faker.numerify("544-###-####"));

        System.out.println("faker.letterify(\"???????\") = " + faker.letterify("a??-a???"));
        System.out.println("faker.bothify(\"##-??-??-##??-##\") = " + faker.bothify("##-??-??-##??-##"));

        System.out.println("faker.letterify(\"aa???x??\", true) = " + faker.letterify("aa???x??", true));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replaceAll("-", ""));

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());


    }


}
