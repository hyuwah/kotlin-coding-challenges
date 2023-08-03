package com.igorwojda.integer.fizzbuzz

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun fizzBuzz(n: Int): List<String> {
    return logExecutionTimeNano { SolutionA.fizzBuzz(n) }
}

private object SolutionA {
    fun fizzBuzz(n: Int): List<String> {
        return (1..n).map {
            when {
                it % (3 * 5) == 0 -> "FizzBuzz"
                it % 5 == 0 -> "Buzz"
                it % 3 == 0 -> "Fizz"
                else -> it.toString()
            }
        }
    }
}

private class Test {

    @Test
    fun `Calling fizzbuzz with "5" returns list with 5 items`() {
        fizzBuzz(5) shouldBeEqualTo listOf("1", "2", "Fizz", "4", "Buzz")
    }

    @Test
    fun `Calling fizzbuzz with 16 returns out the correct values`() {
        val list = listOf(
            "1", "2", "Fizz", "4", "Buzz", "Fizz",
            "7", "8", "Fizz", "Buzz", "11", "Fizz",
            "13", "14", "FizzBuzz", "16",
        )

        fizzBuzz(16) shouldBeEqualTo list
    }
}
