package bj25206

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var totalCredit = 0.0
    var totalScore = 0.0
    for (i in 0 until 20) {
        val subjectResult = br.readLine().split(" ")
        if (subjectResult[2] != "P") {
            val credit = subjectResult[1].toDouble()
            totalCredit += credit
            totalScore += gradeToNumber(subjectResult[2]) * credit
        }
    }
    println(totalScore / totalCredit)
    br.close()
}

fun gradeToNumber(grade: String): Double {
    return when (grade) {
        "A+" -> 4.5
        "A0" -> 4.0
        "B+" -> 3.5
        "B0" -> 3.0
        "C+" -> 2.5
        "C0" -> 2.0
        "D+" -> 1.5
        "D0" -> 1.0
        "F" -> 0.0
        else -> -1.0
    }
}
