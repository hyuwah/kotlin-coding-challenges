package com.igorwojda.integer.reverse

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import kotlin.math.sign

private fun reverseInt(i: Int): Int {
    return logExecutionTimeNano { SolutionA.reverseInt(i) }
}

private object SolutionA {
    fun reverseInt(i: Int): Int {
        val reversedI = i.toString()
            .removePrefix("-")
            .reversed()
            .toIntOrNull() ?: 0
        return reversedI * i.sign
    }
}

private class Test {
    @Test
    fun `ReverseInt handles 0 as an input`() {
        reverseInt(0) shouldBeEqualTo 0
    }

    @Test
    fun `ReverseInt flips a positive number`() {
        reverseInt(5) shouldBeEqualTo 5
        reverseInt(15) shouldBeEqualTo 51
        reverseInt(90) shouldBeEqualTo 9
        reverseInt(700) shouldBeEqualTo 7
        reverseInt(2359) shouldBeEqualTo 9532
    }

    @Test
    fun `ReverseInt flips a negative number`() {
        reverseInt(-5) shouldBeEqualTo -5
        reverseInt(-15) shouldBeEqualTo -51
        reverseInt(-90) shouldBeEqualTo -9
        reverseInt(-700) shouldBeEqualTo -7
        reverseInt(-2359) shouldBeEqualTo -9532
    }
}
