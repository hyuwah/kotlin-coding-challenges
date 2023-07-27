package com.igorwojda.list.formattrainroute

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun formatTrainRoute(stations: List<String>, caseId: String = ""): String {
    return logExecutionTimeNano("$caseId|SolutionB") { SolutionB.formatTrainRoute(stations) }
}

private object SolutionA {
    fun formatTrainRoute(stations: List<String>): String {
        return buildString {
            append("Train is calling at ")
            if (stations.size > 2) {
                val lastStation = stations.last()
                append(stations.dropLast(1).joinToString(", "))
                append(" and $lastStation")
            } else {
                append(stations.joinToString(" and "))
            }
        }
    }
}

/**
 * Faster than [SolutionA]
 */
private object SolutionB {
    fun formatTrainRoute(stations: List<String>): String {
        return buildString {
            append("Train is calling at ")
            stations.forEach {  station ->
                when(station) {
                    stations.first() -> append(station)
                    stations.last() -> append(" and $station")
                    else -> append(", $station")
                }
            }
        }
    }
}

private class Test {
    @Test
    fun `formatTrainRoute list 'Luton'`() {
        formatTrainRoute(listOf("Luton"), "Case 1") shouldBeEqualTo "Train is calling at Luton"
    }

    @Test
    fun `formatTrainRoute list 'Luton', 'Harpenden'`() {
        formatTrainRoute(listOf("Luton", "Harpenden"), "Case 2") shouldBeEqualTo "Train is calling at Luton and Harpenden"
    }

    @Test
    fun `formatTrainRoute list 'Luton', 'Harpenden', 'London'`() {
        val list = listOf("Luton", "Harpenden", "London")
        formatTrainRoute(list, "Case 3") shouldBeEqualTo "Train is calling at Luton, Harpenden and London"
    }

    @Test
    fun `formatTrainRoute list 'Luton', 'Harpenden', 'St Albans', 'London'`() {
        val list = listOf("Luton", "Harpenden", "St Albans", "London")
        formatTrainRoute(list, "Case 4") shouldBeEqualTo "Train is calling at Luton, Harpenden, St Albans and London"
    }
}
