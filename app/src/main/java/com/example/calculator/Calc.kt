package com.example.calculator

class Calc(
    var firstArg: Int = 0,
    var secondArg: Int = 0,
    var input: String = ""
) {

    var actionStr = ""
    fun onNumPressed(buttonId: Int) {
        when (buttonId) {
            R.id.zero -> input += "0"
            R.id.one -> input += "1"
            R.id.two -> input += "2"
            R.id.three -> input += "3"
            R.id.four -> input += "4"
            R.id.five -> input += "5"
            R.id.six -> input += "6"
            R.id.seven -> input += "7"
            R.id.eight -> input += "8"
            R.id.nine -> input += "9"
        }
    }

    fun onActionPressed(actionId: Int) {
        when (actionId) {
            R.id.plus -> {
                firstArg = input.toInt()
                input += "+"
                actionStr = "+"
            }
            R.id.minus -> {
                firstArg = input.toInt()
                input += "-"
                actionStr = "-"
            }
            R.id.multiply -> {
                firstArg = input.toInt()
                input += "*"
                actionStr = "*"
            }
            R.id.division -> {
                firstArg = input.toInt()
                input += "/"
                actionStr = "/"
            }
            R.id.equals -> {
                secondArg = getSecondArgumentFromInput(input)
                input = equal().toString()
            }
        }
    }

    fun getSecondArgumentFromInput(str: String): Int {
        var result: String = ""
        for (i in 0..str.length - 1) {
            result += str[i]
            if (!str[i].isDigit()) {
                result = ""
            }
        }
        return result.toInt()
    }

    fun equal(): Int {
        var result: Int = 0
        when (actionStr) {
            "+" -> result = secondArg + firstArg
            "-" -> result = firstArg + secondArg
            "*" -> result = firstArg * secondArg
            "/" -> result = firstArg / secondArg
        }
        return result
    }

}