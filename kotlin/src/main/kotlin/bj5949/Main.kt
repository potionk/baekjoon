package bj5949

fun main() = println(readLine()!!.reversed().chunked(3).joinToString(",").reversed())

