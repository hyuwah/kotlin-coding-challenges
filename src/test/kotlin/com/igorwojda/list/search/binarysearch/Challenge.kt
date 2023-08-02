package com.igorwojda.list.search.binarysearch

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun binarySearch(list: List<Char>, element: Char): Int {
    return logExecutionTimeNano { SolutionA.binarySearch(list, element) }
}

private object SolutionA {
    fun binarySearch(list: List<Char>, element: Char): Int {
        var left = 0
        var right = list.lastIndex
        while (left <= right) {
            val mid = left + ((right - left) / 2) // calculate mid-pointer, will be rounded down & used as index
            when {
                element == list[mid] -> return mid // found the char, return the mid-pointer index
                element - 'A' < list[mid] - 'A' -> right = mid - 1 // element is on the left side of mid, adjust right boundary
                element - 'A' > list[mid] - 'A' -> left = mid + 1 // element is on the right side of mid, adjust left boundary
            }
        }
        return -1 // reduced the list & element still not found, return -1
    }
}

private class Test {
    @Test
    fun `index of A in A, B, C is 0`() {
        binarySearch(listOf('A', 'B', 'C'), 'A') shouldBeEqualTo 0
    }

    @Test
    fun `index of B in A, B, C is 1`() {
        binarySearch(listOf('A', 'B', 'C'), 'B') shouldBeEqualTo 1
    }

    @Test
    fun `index of C in A, B, C is 2`() {
        binarySearch(listOf('A', 'B', 'C'), 'C') shouldBeEqualTo 2
    }

    @Test
    fun `index of H in A, B, C is -1`() {
        binarySearch(listOf('A', 'B', 'C'), 'H') shouldBeEqualTo -1
    }

    @Test
    fun `index of A in A, B, C, D is 0`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'A') shouldBeEqualTo 0
    }

    @Test
    fun `index of B in A, B, C, D is 1`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'B') shouldBeEqualTo 1
    }

    @Test
    fun `index of C in A, B, C, D is 2`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'C') shouldBeEqualTo 2
    }

    @Test
    fun `index of D in A, B, C, D is 3`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'D') shouldBeEqualTo 3
    }

    @Test
    fun `index of H in A, B, C, D is -1`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'H') shouldBeEqualTo -1
    }
}
