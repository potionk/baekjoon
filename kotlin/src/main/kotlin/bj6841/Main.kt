package bj6841

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var input = br.readLine()
    while (true) {
        println(
            when (input) {
                "CU" -> "see you"
                ":-)" -> "I’m happy"
                ":-(" -> "I’m unhappy"
                ";-)" -> "wink"
                ":-P" -> "stick out my tongue"
                "(~.~)" -> "sleepy"
                "TA" -> "totally awesome"
                "CCC" -> "Canadian Computing Competition"
                "CUZ" -> "because"
                "TY" -> "thank-you"
                "YW" -> "you’re welcome"
                "TTYL" -> "talk to you later"
                else -> input
            }
        )
        if (input == "TTYL") break
        input = br.readLine()
    }
}
