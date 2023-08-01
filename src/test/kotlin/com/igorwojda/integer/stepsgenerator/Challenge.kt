package com.igorwojda.integer.stepsgenerator

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun generateSteps(n: Int): List<String> {
    return logExecutionTimeNano { SolutionA.generateSteps(n) }
}

private object SolutionA {
    fun generateSteps(n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in 0 until n) {
            val row = buildString {
                for (j in 0 until n) {
                    if (j <= i) {
                        append("#")
                    } else {
                        append(" ")
                    }
                }
            }
            result.add(row)
        }
        return result
    }
}

private class Test {
    @Test
    fun `steps n = 1`() {
        val actual = generateSteps(1)
        actual.size shouldBeEqualTo 1
        actual[0] shouldBeEqualTo "#"
    }

    @Test
    fun `steps n = 2`() {
        val actual = generateSteps(2)
        actual.size shouldBeEqualTo 2
        actual[0] shouldBeEqualTo "# "
        actual[1] shouldBeEqualTo "##"
    }

    @Test
    fun `steps n = 3`() {
        val actual = generateSteps(3)
        actual.size shouldBeEqualTo 3
        actual[0] shouldBeEqualTo "#  "
        actual[1] shouldBeEqualTo "## "
        actual[2] shouldBeEqualTo "###"
    }
}
