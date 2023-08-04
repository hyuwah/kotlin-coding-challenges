package com.igorwojda.list.capitalizefirst

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun capitalizeFirst(list: List<String>, caseId: String = ""): List<String> {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.capitalizeFirst(list) }
}

private object SolutionA {
    fun capitalizeFirst(list: List<String>): List<String> {
        return list.map { word ->
            word.replaceFirstChar { it.uppercaseChar() }
        }
    }
}

private class Test {
    @Test
    fun `capitalize list with one string`() {
        capitalizeFirst(listOf("igor"), "Case 1") shouldBeEqualTo listOf("Igor")
    }

    @Test
    fun `capitalize list with two strings`() {
        capitalizeFirst(listOf("igor", "wojda"), "Case 2") shouldBeEqualTo listOf("Igor", "Wojda")
    }

    @Test
    fun `capitalize list with empty string`() {
        capitalizeFirst(listOf(""), "Case 3") shouldBeEqualTo listOf("")
    }

    @Test
    fun `capitalize list with sentence`() {
        capitalizeFirst(listOf("what a", "beautiful", "morning"), "Case 4") shouldBeEqualTo listOf(
            "What a",
            "Beautiful",
            "Morning",
        )
    }
}
