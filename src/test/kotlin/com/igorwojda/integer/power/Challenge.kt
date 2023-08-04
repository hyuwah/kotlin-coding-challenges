package com.igorwojda.integer.power

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun power(base: Int, exponent: Int, caseId: String = ""): Int {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.power(base, exponent) }
}

private object SolutionA {
    fun power(base: Int, exponent: Int): Int {
        if (exponent == 0) return 1
        return base * power(base, exponent - 1)
    }
}

private class Test {
    @Test
    fun `power 2^1 returns 2`() {
        power(2, 1, "Case 1") shouldBeEqualTo 2
    }

    @Test
    fun `power 2^2 returns 2`() {
        power(2, 2, "Case 2") shouldBeEqualTo 4
    }

    @Test
    fun `power 2^3 returns 8`() {
        power(2, 3, "Case 3") shouldBeEqualTo 8
    }

    @Test
    fun `power 3^4 returns 81`() {
        power(3, 4, "Case 4") shouldBeEqualTo 81
    }

    @Test
    fun `power 3^0 returns 1`() {
        power(3, 0, "Case 5") shouldBeEqualTo 1
    }
}
