package com.igorwojda.integer.generateallpairs

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun getAllPairs(n: Int, caseId: String = ""): List<Pair<Int, Int>> {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.getAllPairs(n) }
    }

/**
 * Brute force
 */
private object SolutionA {
    fun getAllPairs(n: Int): List<Pair<Int, Int>> {
        val list = (0..n).toList()
        val result = mutableListOf<Pair<Int, Int>>()
        list.forEach { a ->
            list.forEach { b ->
                result.add(a to b)
            }
        }
        return result
    }
}

private class Test {
    @Test
    fun `get all pairs 0`() {
        getAllPairs(0, "Case 1") shouldBeEqualTo listOf(0 to 0)
    }

    @Test
    fun `get all pairs 1`() {
        getAllPairs(1, "Case 2") shouldBeEqualTo listOf(
            0 to 0,
            0 to 1,
            1 to 0,
            1 to 1,
        )
    }

    @Test
    fun `get all pairs 2`() {
        getAllPairs(2, "Case 3") shouldBeEqualTo listOf(
            0 to 0,
            0 to 1,
            0 to 2,
            1 to 0,
            1 to 1,
            1 to 2,
            2 to 0,
            2 to 1,
            2 to 2,
        )
    }
}
