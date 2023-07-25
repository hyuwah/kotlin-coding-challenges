package com.igorwojda.range.containsrange

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun containsRange(range1: IntRange, range2: IntRange, caseId: String = ""): Boolean {
    return logExecutionTimeNano("$caseId|SolutionB") { SolutionB.containsRange(range1, range2) }
}

/**
 * Naive solution
 * Iterate all elements on range2 & check it with range1
 * might be O(n)
 * Also valid for is "List1 contains items of List2?" case
 */
private object SolutionA {
    fun containsRange(range1: IntRange, range2: IntRange): Boolean {
        range2.forEach {
            if (!range1.contains(it)) return false // break loop if there's number on range2 that is not on range1
        }
        return true // All number on range2 is on range1 too
    }
}

/**
 * Only check boundary
 * Faster than [SolutionA]
 * O(1)
 * Doesn't check the elements, only valid on full range case
 */
private object SolutionB {
    fun containsRange(range1: IntRange, range2: IntRange): Boolean {
        return range1.first <= range2.first
                && range1.last >= range2.last
    }
}

private class Test {
    @Test
    fun `5-7 range contains 5-7`() {
        containsRange(5..7, 5..7, "Case 1") shouldBeEqualTo true
    }

    @Test
    fun `1-12 range contains 5-7`() {
        containsRange(1..12, 5..7, "Case 2") shouldBeEqualTo true
    }

    @Test
    fun `12-17 range contains 12-14`() {
        containsRange(12..17, 12..14, "Case 3") shouldBeEqualTo true
    }

    @Test
    fun `12-17 range contains 15-17`() {
        containsRange(12..17, 15..17, "Case 4") shouldBeEqualTo true
    }

    @Test
    fun `5-7 range contains 1-12`() {
        containsRange(5..7, 1..12, "Case 5") shouldBeEqualTo false
    }

    @Test
    fun `5-8 range contains 5-9`() {
        containsRange(5..8, 5..9, "Case 6") shouldBeEqualTo false
    }

    @Test
    fun `5-8 range contains 3-5`() {
        containsRange(5..8, 3..5, "Case 7") shouldBeEqualTo false
    }

    @Test
    fun `1-10 range contains 1-1_000_000`() {
        containsRange(1..10, 1..1_000_000, "Case 8") shouldBeEqualTo false
    }

    @Test
    fun `1-10 range contains 1-500_000`() {
        containsRange(1..10, 1..500_000, "Case 9") shouldBeEqualTo false
    }

    @Test
    fun `1-1_000_000 range contains 1-10`() {
        containsRange(1..1_000_000, 1..10, "Case 10") shouldBeEqualTo true
    }

    @Test
    fun `1-500_000 range contains 1-10`() {
        containsRange(1..500_000, 1..10, "Case 11") shouldBeEqualTo true
    }
}
