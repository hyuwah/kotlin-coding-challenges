package com.igorwojda.utility

inline fun <T> logExecutionTimeMillis(
    identifier: String = "function",
    function: () -> T
): T {
    val startTime = System.currentTimeMillis()
    val result: T = function.invoke()
    val measuredTime = System.currentTimeMillis() - startTime
    println("$identifier took $measuredTime ms")
    return result
}

inline fun <T> logExecutionTimeNano(
    identifier: String = "function",
    function: () -> T
): T {
    val startTime = System.nanoTime()
    val result: T = function.invoke()
    val measuredTime = System.nanoTime() - startTime
    println("$identifier took $measuredTime ns (${measuredTime / 1_000_000} ms)")
    return result
}