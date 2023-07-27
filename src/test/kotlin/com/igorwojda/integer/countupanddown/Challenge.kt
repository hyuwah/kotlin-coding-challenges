package com.igorwojda.integer.countupanddown

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun countUpAndDown(n: Int, caseId: String = ""): List<Int> {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.countUpAndDown(n) }
}

private object SolutionA {
    fun countUpAndDown(n: Int): List<Int> {
        return (0 until n).toList() + (n downTo 0).toList()
    }
}

private class Test {
    @Test
    fun `count up and down 0`() {
        countUpAndDown(0, "Case 1") shouldBeEqualTo listOf(0)
    }

    @Test
    fun `count up and down 1`() {
        countUpAndDown(1, "Case 2") shouldBeEqualTo listOf(0, 1, 0)
    }

    @Test
    fun `count up and down 2`() {
        countUpAndDown(2, "Case 3") shouldBeEqualTo listOf(0, 1, 2, 1, 0)
    }

    @Test
    fun `count up and down 3`() {
        countUpAndDown(3, "Case 4") shouldBeEqualTo listOf(0, 1, 2, 3, 2, 1, 0)
    }

    @Test
    fun `count up and down 4`() {
        countUpAndDown(4, "Case 5") shouldBeEqualTo listOf(0, 1, 2, 3, 4, 3, 2, 1, 0)
    }

    @Test
    fun `count up and down 9`() {
        countUpAndDown(9, "Case 6") shouldBeEqualTo listOf(
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            8,
            7,
            6,
            5,
            4,
            3,
            2,
            1,
            0,
        )
    }
}
