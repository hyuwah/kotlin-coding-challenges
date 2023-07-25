package com.igorwojda.list.search.linearsearch

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun getIndex(list: List<String>, str: String, caseId: String = ""): Int {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.getIndex(list, str) }
}

/**
 * #idiomatic
 */
private object SolutionA {
    fun getIndex(list: List<String>, str: String): Int {
        return list.indexOfFirst { it == str }
    }
}

/**
 * Naive iteration vanilla
 */
private object SolutionB {
    fun getIndex(list: List<String>, str: String): Int {
        var index = 0
        list.forEach {
            if (it == str) return index
            index++
        }
        return -1
    }
}

private class Test {
    @Test
    fun `index of 'A' in 'A, B, C' is 0`() {
        getIndex(listOf("A", "B", "C"), "A", "Case 1") shouldBeEqualTo 0
    }

    @Test
    fun `index of 'B' in 'A, B, C' is 1`() {
        getIndex(listOf("A", "B", "C"), "B", "Case 2") shouldBeEqualTo 1
    }

    @Test
    fun `index of 'C' in 'A, B, C' is 2`() {
        getIndex(listOf("A", "B", "C"), "C", "Case 3") shouldBeEqualTo 2
    }

    @Test
    fun `index of 'D' in 'A, B, C' is -1`() {
        getIndex(listOf("A", "B", "C"), "D", "Case 4") shouldBeEqualTo -1
    }
}
