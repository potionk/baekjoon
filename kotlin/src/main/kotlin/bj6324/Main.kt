package bj6324

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val url = br.readLine()
        val protocol = url.substringBefore("://")
        val hostAndPort = url.substringAfter("://").substringBefore("/")
        val host = hostAndPort.substringBefore(":")
        val port = hostAndPort.substringAfter(":", "").ifEmpty { "<default>" }
        val path = url.substringAfter("://").substringAfter("/", "").ifEmpty { "<default>" }
        println("URL #${it + 1}")
        println("Protocol = $protocol")
        println("Host     = $host")
        println("Port     = $port")
        println("Path     = $path")
        println()
    }
}
