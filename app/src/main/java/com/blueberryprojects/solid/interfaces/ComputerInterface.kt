package com.blueberryprojects.solid.interfaces

interface ComputerInterface : MathematicsInterface {

    override fun compute(inputOne: Int, inputTwo: Int): Int

    fun login(username: String, password: String) {}

    fun register(username: String, password: String) {}
}