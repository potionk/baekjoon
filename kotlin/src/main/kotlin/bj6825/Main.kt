package bj6825

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val weight = br.readLine().toDouble()
    val height = br.readLine().toDouble()
    val bmi = weight / height / height
    print(if (bmi > 25) "Overweight" else if (bmi > 18.5) "Normal weight" else "Underweight")
    br.close()
}
