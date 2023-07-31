package com.igorwojda.string.ispalindrome.basic

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isPalindrome(str: String): Boolean {
    return logExecutionTimeNano { SolutionA.isPalindrome(str) }
}

/**
 * Two pointer approach
 */
private object SolutionA {
    fun isPalindrome(str: String): Boolean {
        var right = str.lastIndex
        for (left in str.indices) {
            if (right < left) return true
            if (str[left] != str[right]) return false
            right--
        }
        return true
    }
}

private class Test {

    @Test
    fun `'aba' is a palindrome`() {
        isPalindrome("aba") shouldBeEqualTo true
    }

    @Test
    fun `' aba' is not a palindrome`() {
        isPalindrome(" aba") shouldBeEqualTo false
    }

    @Test
    fun `'aba ' is not a palindrome`() {
        isPalindrome("aba ") shouldBeEqualTo false
    }

    @Test
    fun `'greetings' is not a palindrome`() {
        isPalindrome("greetings") shouldBeEqualTo false
    }

    @Test
    fun `'1000000001' a palindrome`() {
        isPalindrome("1000000001") shouldBeEqualTo true
    }

    @Test
    fun `'Fish hsif' is not a palindrome`() {
        isPalindrome("Fish hsif") shouldBeEqualTo false
    }

    @Test
    fun `'pennep' a palindrome`() {
        isPalindrome("pennep") shouldBeEqualTo true
    }
}
