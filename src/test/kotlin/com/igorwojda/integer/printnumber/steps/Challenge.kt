package com.igorwojda.integer.printnumber.steps

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun printNumber(n: Int, step: Int = 1, caseId: String = ""): List<Int> {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.printNumber(n, step) }
}

private object SolutionA {
    fun printNumber(n: Int, step: Int = 1): List<Int> {
        return (n downTo 1 step(step)).toList()
    }
}

private class Test {
    @Test
    fun `printNumber 0 step 1 return listOf()`() {
        printNumber(0, 1, "Case 1") shouldBeEqualTo listOf()
    }

    @Test
    fun `printNumber 1 step 1 return listOf(1)`() {
        printNumber(1, 1, "Case 2") shouldBeEqualTo listOf(1)
    }

    @Test
    fun `printNumber 3 step 2 return listOf(3, 1)`() {
        printNumber(3, 2, "Case 3") shouldBeEqualTo listOf(3, 1)
    }

    @Test
    fun `printNumber 11 step 3 return listOf(1, 8, 5, 2)`() {
        printNumber(11, 3, "Case 4") shouldBeEqualTo listOf(11, 8, 5, 2)
    }
}
