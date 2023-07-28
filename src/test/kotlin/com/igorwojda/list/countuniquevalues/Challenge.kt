package com.igorwojda.list.countuniquevalues

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun countUniqueValues(list: List<Int>, caseId: String = ""): Int {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.countUniqueValues(list) }
}

/**
 * Kotlin stdlib
 */
private object SolutionA {
    fun countUniqueValues(list: List<Int>): Int {
//        val result = list.distinct().size
        val result = list.groupBy { it }.count() // faster than distinct()
        return result
    }
}

/**
 * Using set
 */
private object SolutionB {
    fun countUniqueValues(list: List<Int>): Int {
        val numberSet = mutableSetOf<Int>()
        list.forEach {
            numberSet.add(it)
        }
        //val result = list.toSet().size
        return numberSet.size
    }
}

private class Test {
    @Test
    fun `countUniqueValues empty list return 0`() {
        countUniqueValues(listOf(), "Case 1") shouldBeEqualTo 0
    }

    @Test
    fun `countUniqueValues 4 return 1`() {
        countUniqueValues(listOf(4), "Case 2") shouldBeEqualTo 1
    }

    @Test
    fun `countUniqueValues 3, 3, 3, 3, 5 return 2`() {
        countUniqueValues(listOf(3, 3, 3, 3, 5), "Case 3") shouldBeEqualTo 2
    }

    @Test
    fun `countUniqueValues 5, 5, 6, 7, 7 returns 3`() {
        countUniqueValues(listOf(5, 5, 6, 7, 7), "Case 4") shouldBeEqualTo 3
    }

    @Test
    fun `countUniqueValues 1, 5, 9, 9 returns 3`() {
        countUniqueValues(listOf(1, 5, 9, 9), "Case 5") shouldBeEqualTo 3
    }

    @Test
    fun `countUniqueValues 1, 5, 5, 5, 9 returns 3`() {
        countUniqueValues(listOf(1, 5, 5, 5, 9), "Case 6") shouldBeEqualTo 3
    }

    @Test
    fun `countUniqueValues 4, 4, 5, 7, 10, 10 returns 4`() {
        countUniqueValues(listOf(4, 4, 5, 7, 10, 10), "Case 7") shouldBeEqualTo 4
    }

    @Test
    fun `countUniqueValues 2, 2, 3, 6, 7, 9, 9, 12, 13, 13 returns 7`() {
        countUniqueValues(listOf(2, 2, 3, 6, 7, 9, 9, 12, 13, 13), "Case 8") shouldBeEqualTo 7
    }

    @Test
    fun `countUniqueValues 1, 2, 3, 4, 5 return 5`() {
        countUniqueValues(listOf(1, 2, 3, 4, 5), "Case 9") shouldBeEqualTo 5
    }

    @Test
    fun `countUniqueValues 2, 3, 4, 7 return 4`() {
        countUniqueValues(listOf(2, 3, 4, 7), "Case 10") shouldBeEqualTo 4
    }
}
