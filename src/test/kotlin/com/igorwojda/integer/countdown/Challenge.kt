package com.igorwojda.integer.countdown

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun countDown(n: Int, caseId: String = ""): List<Int> {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.countDown(n) }
}

/**
 * #idiomatic
 * Range to list
 */
private object SolutionA {
    fun countDown(n: Int): List<Int> {
        return (n downTo 0).toList()
    }
}

/**
 * #idiomatic
 * List constructor
 * Faster than [SolutionA]
 */
private object SolutionB {
    fun countDown(n: Int): List<Int> {
        return List(n + 1) { index -> n - index }
    }
}

/**
 * #recursive
 */
private object SolutionC {
    fun countDown(n: Int): List<Int> {
        if (n == 0) return listOf(0) // Stop condition
        return listOf(n) + countDown(n - 1) // return recursively
    }
}

private class Test {
    @Test
    fun `count down 0`() {
        countDown(0, "Case 1") shouldBeEqualTo listOf(0)
    }

    @Test
    fun `count down 1`() {
        countDown(1, "Case 2") shouldBeEqualTo listOf(1, 0)
    }

    @Test
    fun `count down 5`() {
        countDown(5, "Case 3") shouldBeEqualTo listOf(5, 4, 3, 2, 1, 0)
    }
}
