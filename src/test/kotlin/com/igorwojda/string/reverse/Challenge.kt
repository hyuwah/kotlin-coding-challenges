package com.igorwojda.string.reverse

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun reverse(str: String): String {
    return logExecutionTimeNano { SolutionA.reverse(str) }
}

private object SolutionA {
    fun reverse(str: String): String {
        return buildString {
            for (i in str.lastIndex downTo 0) {
                append(str[i])
            }
        }
    }
}

private class Test {
    @Test
    fun `Reverse of 'abcd' is 'dcba'`() {
        reverse("abcd") shouldBeEqualTo "dcba"
    }

    @Test
    fun `Reverse of 'aabbccdd' is 'ddccbbaa'`() {
        reverse("aabbccdd") shouldBeEqualTo "ddccbbaa"
    }
}
