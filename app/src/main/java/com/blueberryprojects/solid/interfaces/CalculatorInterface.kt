package com.blueberryprojects.solid.interfaces

interface CalculatorInterface : MathematicsInterface {

    override fun compute(inputOne: Int, inputTwo: Int): Int
}