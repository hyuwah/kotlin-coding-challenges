package com.igorwojda.string.isanagram

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isAnagram(str1: String, str2: String): Boolean {
    return logExecutionTimeNano { SolutionA.isAnagram(str1, str2) }
}

private object SolutionA {
    fun isAnagram(str1: String, str2: String): Boolean {
        // ignore special char, space & case
        val filteredStr1 = str1.filter { it.isLetterOrDigit() }.lowercase()
        val filteredStr2 = str2.filter { it.isLetterOrDigit() }.lowercase()

        if (filteredStr1.length != filteredStr2.length) return false // both str should have same length

        val charFreqMap = mutableMapOf<Char, Int>()

        // intuition: char freq should be the same (i.e. cancel each other resulting 0 value)
        for (i in filteredStr1.indices) { // using either indices is fine
            charFreqMap[filteredStr1[i]] = charFreqMap.getOrDefault(filteredStr1[i], 0).inc()
            charFreqMap[filteredStr2[i]] = charFreqMap.getOrDefault(filteredStr2[i], 0).dec()
        }

        charFreqMap.values.forEach {
            if (it != 0) return false
        }

        return true
    }
}

/**
 *
 */
private object SolutionB {
    fun isAnagram(str1: String, str2: String): Boolean {
        // ignore special char, space & case
        val filteredStr1 = str1.filter { it.isLetterOrDigit() }.lowercase()
        val filteredStr2 = str2.filter { it.isLetterOrDigit() }.lowercase()

        if (filteredStr1.length != filteredStr2.length) return false // both str should have same length

        // basically the same as SolutionA but with built-in function
        return filteredStr1.groupBy { it } == filteredStr2.groupBy { it }
    }
}

private class Test {
    @Test
    fun `'rail safety' is an anagram of 'fairy tales'`() {
        isAnagram("rail safety", "fairy tales") shouldBeEqualTo true
    }

    @Test
    fun `'RAIL SAFETY' is an anagram of 'fairy tales' - ignore letter casing`() {
        isAnagram("RAIL SAFETY", "fairy tales") shouldBeEqualTo true
    }

    @Test
    fun `'rail safety!!' is an anagram of 'fairy tales' - ignore special characters`() {
        isAnagram("rail safety!!", "fairy tales") shouldBeEqualTo true
    }

    @Test
    fun `'hi' is not an anagram of 'ihi'`() {
        isAnagram("hi", "ihi") shouldBeEqualTo false
    }

    @Test
    fun `'hello' is an anagram of 'llohe'`() {
        isAnagram("hello", "llohe") shouldBeEqualTo true
    }

    @Test
    fun `'Whoa! Hi!' is an anagram of 'Hi! Whoa!'`() {
        isAnagram("Whoa! Hi!", "Hi! Whoa!") shouldBeEqualTo true
    }

    @Test
    fun `'One One' is not an anagram of 'Two two two'`() {
        isAnagram("One One", "Two two two") shouldBeEqualTo false
    }

    @Test
    fun `'One one' is not an anagram of 'One one c'`() {
        isAnagram("One one", "One one c") shouldBeEqualTo false
    }

    @Test
    fun `'One one' is not an anagram of 'One one  ' - ignore spaces`() {
        isAnagram("One one", "One one  ") shouldBeEqualTo true
    }

    @Test
    fun `'A tree, a life, a bench' is not an anagram of 'A tree, a fence, a yard'`() {
        isAnagram("A tree, a life, a bench", "A tree, a fence, a yard") shouldBeEqualTo false
    }
}
