package com.igorwojda.integer.getodd

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun filterOdd(list: List<Int>, caseId: String = ""): List<Int> {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.filterOdd(list) }
}

/**
 * #idiomatic
 * Using built in `filter` on List from kotlin stdlib
 */
private object SolutionA {
    fun filterOdd(list: List<Int>): List<Int> {
        if (list.isEmpty()) return emptyList()
        return list.filter { it % 2 == 1 }
    }
}

/**
 * #recursive
 * Without using built in `filter` on List from kotlin stdlib
 * Slower than [SolutionA]
 */
private object SolutionB {
    fun filterOdd(list: List<Int>): List<Int> {
        if (list.isEmpty()) return list // Recursive stopper
        val currentNumber = list.first()
        val isCurrentNumberOdd = currentNumber % 2 == 1
        return if (isCurrentNumberOdd) { // Odd
            mutableListOf(currentNumber) + filterOdd(list.drop(1)) // Recursively assemble the odd list
        } else { // even
            filterOdd(list.drop(1)) // Skip the even number
        }
    }
}

private class Test {
    @Test
    fun `empty list returns empty list`() {
        filterOdd(listOf(), "Case 1") shouldBeEqualTo emptyList()
    }

    @Test
    fun `1, 2, 3 returns 1, 3`() {
        filterOdd(listOf(1, 2, 3), "Case 2") shouldBeEqualTo listOf(1, 3)
    }

    @Test
    fun `2, 9, 2, 5, 4 returns 9, 5`() {
        filterOdd(listOf(2, 9, 2, 5, 4), "Case 3") shouldBeEqualTo listOf(9, 5)
    }

    @Test
    fun `7, 4, 6, 8, 7, 9 returns 7, 7, 9`() {
        filterOdd(listOf(7, 4, 6, 8, 7, 9), "Case 4") shouldBeEqualTo listOf(7, 7, 9)
    }
}
