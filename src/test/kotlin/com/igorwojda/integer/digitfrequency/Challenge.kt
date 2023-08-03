package com.igorwojda.integer.digitfrequency

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun equalDigitFrequency(i1: Int, i2: Int): Boolean {
    return logExecutionTimeNano { SolutionA.equalDigitFrequency(i1, i2) }
}

private object SolutionA {
    fun equalDigitFrequency(i1: Int, i2: Int): Boolean {
        val iStr1 = i1.toString()
        val iStr2 = i2.toString()
        if (iStr1.length != iStr2.length) return false

        val freqMap = mutableMapOf<Char, Int>()
        for (i in iStr1.indices) {
            freqMap[iStr1[i]] = freqMap.getOrDefault(iStr1[i], 0) + 1 // inc value for every digit from i1
            freqMap[iStr2[i]] = freqMap.getOrDefault(iStr2[i], 0) - 1 // dec value for every digit from i2
        }
        return freqMap.values.all { it == 0 } // if digit freq is equal, then the value should cancel each other & become 0
    }
}

private class Test {
    @Test
    fun `'789' and '897' have the same digit frequency`() {
        equalDigitFrequency(789, 897) shouldBeEqualTo true
    }

    @Test
    fun `'123445' and '451243' have the same digit frequency`() {
        equalDigitFrequency(123445, 451243) shouldBeEqualTo true
    }

    @Test
    fun `'447' and '477' have different digit frequency`() {
        equalDigitFrequency(447, 477) shouldBeEqualTo false
    }

    @Test
    fun `'578' and '0' have different digit frequency`() {
        equalDigitFrequency(578, 0) shouldBeEqualTo false
    }

    @Test
    fun `'0' and '0' have the same digit frequency`() {
        equalDigitFrequency(0, 0) shouldBeEqualTo true
    }
}
