package com.igorwojda.integer.pyramidgenerator

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun generatePyramid(n: Int): List<String> {
    return logExecutionTimeNano { SolutionA.generatePyramid(n) }
}

private object SolutionA {
    fun generatePyramid(n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in 0 until n) {
            val maxColumns = (2 * n) - 1
            val midPoint = maxColumns / 2
            val row = buildString {
                for (j in 0 until maxColumns) {
                    if (j in (midPoint-i)..(midPoint+i)) {
                        append("#")
                    } else {
                        append(" ")
                    }
                }
            }
            result.add(row)
        }
        return result
    }
}

private class Test {

    @Test
    fun `pyramid n = 2`() {
        generatePyramid(2).also {
            it.size shouldBeEqualTo 2
            it[0] shouldBeEqualTo " # "
            it[1] shouldBeEqualTo "###"
        }
    }

    @Test
    fun `pyramid n = 3`() {
        generatePyramid(3).also {
            it.size shouldBeEqualTo 3
            it[0] shouldBeEqualTo "  #  "
            it[1] shouldBeEqualTo " ### "
            it[2] shouldBeEqualTo "#####"
        }
    }

    @Test
    fun `pyramid n = 4`() {
        generatePyramid(4).also {
            it.size shouldBeEqualTo 4
            it[0] shouldBeEqualTo "   #   "
            it[1] shouldBeEqualTo "  ###  "
            it[2] shouldBeEqualTo " ##### "
            it[3] shouldBeEqualTo "#######"
        }
    }
}
