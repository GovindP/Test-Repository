/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Govind
 */
public class Person {

    private static Person person;

    private Person() {
    }

    public Person getInstance() {
        if (person == null) {
            person = new Person();
        }
        return person;

    }

}
