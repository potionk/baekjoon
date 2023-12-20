package bj30087

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()) {
        println(when(br.readLine()){
            "Algorithm" -> "204"
            "DataAnalysis" -> "207"
            "ArtificialIntelligence" -> "302"
            "CyberSecurity" -> "B101"
            "Network" -> "303"
            "Startup" -> "501"
            "TestStrategy" -> "105"
            else -> ""
        })
    }
}
