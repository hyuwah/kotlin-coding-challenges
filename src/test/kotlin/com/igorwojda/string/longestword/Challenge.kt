package com.igorwojda.string.longestword

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun longestWord(str: String, caseId: String = ""): String {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.longestWord(str) }
}

private object SolutionA {
    fun longestWord(str: String): String {
        var result = ""
        str.replace(Regex("[^a-zA-Z\\d\\s:]"), " ").split(" ").forEach {
            if (result.length < it.length) {
                result = it
            }
        }
        return result
    }
}

private class Test {
    @Test
    fun `'flower' return 'flower'`() {
        longestWord("flower", "Case 1") shouldBeEqualTo "flower"
    }

    @Test
    fun `'flower is growing fast' return 'growing'`() {
        longestWord("flower is growing fast", "Case 2") shouldBeEqualTo "growing"
    }

    @Test
    fun `'This is my jeep' return 'jeep'`() {
        longestWord("This is my jeep", "Case 3") shouldBeEqualTo "This"
    }

    @Test
    fun `'Home!@#&sweet home' return 'sweet'`() {
        longestWord("Home!@&#sweet home", "Case 4") shouldBeEqualTo "sweet"
    }
}
