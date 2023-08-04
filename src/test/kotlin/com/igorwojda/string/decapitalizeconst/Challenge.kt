package com.igorwojda.string.decapitalizeconst

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun decapitalizeConst(str: String, caseId: String = ""): String {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.decapitalizeConst(str) }
    }

private object SolutionA {
    fun decapitalizeConst(str: String): String {
        return str.trim('_')
            .lowercase()
            .split("_").mapIndexed { index, s ->
                if (index > 0) s.replaceFirstChar { it.uppercaseChar() }
                else s
            }.joinToString("")
    }
}

private class Test {
    @Test
    fun `'FOOBAR' return foobar`() {
        decapitalizeConst("FOOBAR", "Case 1") shouldBeEqualTo "foobar"
    }

    @Test
    fun `'FOO_BAR' return 'fooBar'`() {
        decapitalizeConst("FOO_BAR", "Case 2") shouldBeEqualTo "fooBar"
    }

    @Test
    fun `'FOO_BAR_BAZ' return 'fooBarBaz'`() {
        decapitalizeConst("FOO_BAR_BAZ", "Case 3") shouldBeEqualTo "fooBarBaz"
    }

    @Test
    fun `'__F_BAR' return 'fBar'`() {
        decapitalizeConst("__F_BAR", "Case 4") shouldBeEqualTo "fBar"
    }

    @Test
    fun `'F_BAR' return 'fBar'`() {
        decapitalizeConst("F_BAR", "Case 5") shouldBeEqualTo "fBar"
    }

    @Test
    fun `empty string return empty string`() {
        decapitalizeConst("", "Case 6") shouldBeEqualTo ""
    }
}
