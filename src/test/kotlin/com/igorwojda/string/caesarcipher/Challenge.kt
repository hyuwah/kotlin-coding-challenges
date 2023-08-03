package com.igorwojda.string.caesarcipher

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun encodeCaesarCipher(str: String, shift: Int): String {
    return logExecutionTimeNano { SolutionB.encodeCaesarCipher(str, shift) }
}

private object SolutionA {
    fun encodeCaesarCipher(str: String, shift: Int): String {
        val alphabet = "abcdefghijklmnopqrstuvwxyz"
        return str.map {
            val shiftedIndex = (it - alphabet[0] + shift) % alphabet.length
            alphabet[shiftedIndex]
        }.joinToString("")
    }
}

/**
 * Faster than [SolutionA]
 */
private object SolutionB {
    fun encodeCaesarCipher(str: String, shift: Int): String {
        val alphabet = "abcdefghijklmnopqrstuvwxyz"
        return buildString {
            str.forEach {
                val shiftedIndex = (it - alphabet[0] + shift) % alphabet.length
                append(alphabet[shiftedIndex])
            }
        }
    }
}

private class Test {
    @Test
    fun `'abc' with shift 1 return 'bcd'`() {
        encodeCaesarCipher("abc", 1) shouldBeEqualTo "bcd"
    }

    @Test
    fun `'abcdefghijklmnopqrstuvwxyz' shift 1 returns 'bcdefghijklmnopqrstuvwxyza'`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            1,
        ) shouldBeEqualTo "bcdefghijklmnopqrstuvwxyza"
    }

    @Test
    fun `'abcdefghijklmnopqrstuvwxyz' shift 7 returns 'hijklmnopqrstuvwxyzabcdefg'`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            7,
        ) shouldBeEqualTo "hijklmnopqrstuvwxyzabcdefg"
    }

    @Test
    fun `'abcdefghijklmnopqrstuvwxyz' shift 50 returns 'yzabcdefghijklmnopqrstuvwx'`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            50,
        ) shouldBeEqualTo "yzabcdefghijklmnopqrstuvwx"
    }
}
