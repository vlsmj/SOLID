package com.blueberryprojects.solid.arithmeticfunctions

import com.blueberryprojects.solid.Arithmetic

/**
 * The Single Responsibility Principle (SRP) states that every class, module, or function in a program should have one responsibility/purpose in a program.
 *
 * The Addition class has one single responsibility, it is to return the sum of inputOne and inputTwo.
 */
class Addition : Arithmetic() {

    /**
     * Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of its subclasses without breaking the application.
     *
     * The Addition class is a subclass of Arithmetic class, which then overrides compute function without changing Arithmetic class' compute function itself.
     */
    override fun compute(inputOne: Int, inputTwo: Int): Int {
        return inputOne + inputTwo
    }
}