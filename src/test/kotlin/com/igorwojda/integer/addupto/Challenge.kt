package com.igorwojda.integer.addupto

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun addUpTo(n: Int, caseId: String = ""): Int {
    return logExecutionTimeNano("$caseId|SolutionC") { SolutionC.addUpTo(n) }
}

/**
 * #idiomatic
 * Using built-in function `sum()` on List from Kotlin Stdlib
 * Slowest
 */
private object SolutionA {
    fun addUpTo(n: Int): Int {
        return (1..n).sum()
    }
}

/**
 * Naive iterative
 * O(n)
 * Faster than [SolutionA]
 */
private object SolutionB {
    fun addUpTo(n: Int): Int {
        var sum = 0
        (1..n).forEach { sum += it }
        return sum
    }
}

/**
 * #recursive
 * On par with Math formula
 */
private object SolutionC {
    fun addUpTo(n: Int): Int {
        if (n == 1) return 1
        return n + addUpTo(n - 1)
    }
}

/**
 * Math formula
 * O(1)
 */
private object SolutionD {
    fun addUpTo(n: Int): Int {
       return n * ( n + 1 ) / 2
    }
}

private class Test {
    @Test
    fun `add up to 1`() {
        addUpTo(1, "Case 1") shouldBeEqualTo 1
    }

    @Test
    fun `add up to 3`() {
        addUpTo(3, "Case 2") shouldBeEqualTo 6
    }

    @Test
    fun `add up to 10`() {
        addUpTo(10, "Case 3") shouldBeEqualTo 55
    }

    @Test
    fun `add up to 1000`() {
        addUpTo(1000, "Case 4") shouldBeEqualTo 500_500
    }
}
