package bj7656

import java.io.*
import java.util.regex.Pattern

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine()

    val pattern = Pattern.compile("What is.*?\\?")
    val matcher = pattern.matcher(input)

    while (matcher.find()) {
        var question = matcher.group()
        if (question.contains(".")) {
            question = question.substring(question.lastIndexOf(".") + 1)
        }
        bw.write("Forty-two${question.trim().drop(4).dropLast(1)}.\n")
    }
    bw.close()
}
