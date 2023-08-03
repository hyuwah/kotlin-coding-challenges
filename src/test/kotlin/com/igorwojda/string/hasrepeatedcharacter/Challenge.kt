package com.igorwojda.string.hasrepeatedcharacter

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun hasRepeatedChar(str: String): Boolean {
    return logExecutionTimeNano { SolutionA.hasRepeatedChar(str) }
}

private object SolutionA {
    fun hasRepeatedChar(str: String): Boolean {
        val charSet = mutableSetOf<Char>()
        str.forEach {
            val charExists = !charSet.add(it)
            if (charExists) return true
        }
        return false
    }
}

private class Test {
    @Test
    fun `'abc' don't have repeated character`() {
        hasRepeatedChar("abc") shouldBeEqualTo false
    }

    @Test
    fun `'aabc' has repeated character`() {
        hasRepeatedChar("aabc") shouldBeEqualTo true
    }

    @Test
    fun `'aabcc' has repeated character`() {
        hasRepeatedChar("aabcc") shouldBeEqualTo true
    }
}
