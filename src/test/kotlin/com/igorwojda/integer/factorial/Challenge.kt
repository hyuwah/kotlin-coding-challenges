package com.igorwojda.integer.factorial

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun factorial(n: Int, caseId: String = ""): Int {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.factorial(n) }
}

private object SolutionA {

    fun factorial(n: Int): Int {
        return if (n == 0) 1
        else n * factorial(n - 1)
    }
}

private class Test {
    @Test
    fun `factorial 0 should equal 1`() {
        factorial(0, "Case 1") shouldBeEqualTo 1
    }

    @Test
    fun `factorial 3 should equal 6`() {
        factorial(3, "Case 2") shouldBeEqualTo 6
    }

    @Test
    fun `factorial 5 should equal 120`() {
        factorial(5, "Case 3") shouldBeEqualTo 120
    }

    @Test
    fun `factorial 10 should equal 3628800`() {
        factorial(10, "Case 4") shouldBeEqualTo 3628800
    }
}
