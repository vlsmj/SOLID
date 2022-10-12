package com.blueberryprojects.solid

import com.blueberryprojects.solid.interfaces.ComputerInterface

/**
 * Open-closed Principle (OCP) states: Objects or entities should be open for extension but closed for modification.
 *
 * Make Arithmetic class open so it can be inherited by subclasses.
 */
open class Arithmetic : ComputerInterface {

    override fun compute(inputOne: Int, inputTwo: Int): Int {
        return 0
    }

    /**
     * The Interface Segregation Principle (ISP) states that a client should not be exposed to methods it doesn't need.
     *
     * Do not override login and register functions since they are not needed to compute arithmetic functions.
     */
    /* override fun login(username: String, password: String) {

    }

    override fun register(username: String, password: String) {

    } */
}