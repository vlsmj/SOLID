package com.blueberryprojects.solid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blueberryprojects.solid.arithmeticfunctions.Addition
import com.blueberryprojects.solid.arithmeticfunctions.Division
import com.blueberryprojects.solid.arithmeticfunctions.Multiplication
import com.blueberryprojects.solid.arithmeticfunctions.Subtraction
import com.blueberryprojects.solid.interfaces.MathematicsInterface
import com.blueberryprojects.solid.ui.theme.SOLIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                SOLIDTheme {
                    var additionAnswer by remember {
                        mutableStateOf(0)
                    }

                    var subtractionAnswer by remember {
                        mutableStateOf(0)
                    }

                    var multiplicationAnswer by remember {
                        mutableStateOf(0)
                    }

                    var divisionAnswer by remember {
                        mutableStateOf(0)
                    }

                    Surface(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp), color = MaterialTheme.colors.background) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Single Responsibility Principle",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold)

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(text = "Single-responsibility Principle (SRP) states: A class should have one and only one reason to change, meaning that a class should have only one job.",
                                fontStyle = FontStyle.Italic)

                            Spacer(modifier = Modifier.height(16.dp))

                            Column {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Box(
                                        modifier = Modifier
                                            .border(1.dp, MaterialTheme.colors.primary, RectangleShape)
                                            .weight(1f)
                                            .clickable {
                                                additionAnswer = getAnswer(1, 1, Addition())
                                            }
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "1 + 1 = ${
                                                if (additionAnswer != 0) {
                                                    additionAnswer
                                                } else {
                                                    ""
                                                }
                                            }"
                                        )
                                    }

                                    Spacer(Modifier.weight(0.5f))

                                    Box(
                                        modifier = Modifier
                                            .border(1.dp, MaterialTheme.colors.primary, RectangleShape)
                                            .weight(1f)
                                            .clickable {
                                                subtractionAnswer = getAnswer(4, 2, Subtraction())
                                            }
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "4 - 2 = ${
                                                if (subtractionAnswer != 0) {
                                                    subtractionAnswer
                                                } else {
                                                    ""
                                                }
                                            }"
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Box(
                                        modifier = Modifier
                                            .border(1.dp, MaterialTheme.colors.primary, RectangleShape)
                                            .weight(1f)
                                            .clickable {
                                                multiplicationAnswer = getAnswer(5, 5, Multiplication())
                                            }
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "5 x 5 = ${
                                                if (multiplicationAnswer != 0) {
                                                    multiplicationAnswer
                                                } else {
                                                    ""
                                                }
                                            }"
                                        )
                                    }

                                    Spacer(Modifier.weight(0.5f))

                                    Box(
                                        modifier = Modifier
                                            .border(1.dp, MaterialTheme.colors.primary, RectangleShape)
                                            .weight(1f)
                                            .clickable {
                                                divisionAnswer = getAnswer(12, 4, Division())
                                            }
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "12 / 4 = ${
                                                if (divisionAnswer != 0) {
                                                    divisionAnswer
                                                } else {
                                                    ""
                                                }
                                            }"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * The Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules; both should depend on abstractions.
     *
     * The ComputerInterface and CalculatorInterface are interchangeable.
     * - Arithmetic class can extend ComputerInterface.
     * - Arithmetic class can extend CalculatorInterface.
     * They both will return the same results.
     */
    private fun getAnswer(inputOne: Int, inputTwo: Int, answerProvider: MathematicsInterface): Int {
        return answerProvider.compute(inputOne, inputTwo)
    }
}