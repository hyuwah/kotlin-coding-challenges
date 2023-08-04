package com.igorwojda.list.product

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun product(list: List<Int>, caseId: String = ""): Int {
    return logExecutionTimeNano("$caseId|SolutionB") { SolutionB.product(list) }
    }

/**
 * using `reduce` from kotlin stdlib
 */
private object SolutionA {
    fun product(list: List<Int>): Int {
        return list.reduce { acc, i -> acc * i }
    }
}

/**
 * Recursive approach
 */
private object SolutionB {
    fun product(list: List<Int>): Int {
        if (list.isEmpty()) return 1
        return (list.firstOrNull() ?: 0) * product(list.drop(1))
    }
}

private class Test {
    @Test
    fun `product 0 returns 0`() {
        product(listOf(0), "Case 1") shouldBeEqualTo 0
    }

    @Test
    fun `product 1, 2, 3 returns 6`() {
        product(listOf(1, 2, 3), "Case 2") shouldBeEqualTo 6
    }

    @Test
    fun `product 4, 2, 10 returns 80`() {
        product(listOf(2, 4, 10), "Case 3") shouldBeEqualTo 80
    }
}
