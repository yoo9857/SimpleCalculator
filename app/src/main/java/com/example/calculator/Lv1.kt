
fun main() {
    /*
    * var operator = '+'

if(##답안##) {
	// 덧셈일 때
} else if(##답안##) {
  // 뺄셈일 때
} else if(##답안##) {
	// 곱셈일 때
} else if(##답안##) {
	// 나눗셈일 때
} else {
	// 잘못된 연산자 일 때
}*/

    var operator:String = "+"
    var firsrnumber:Double = 0.0
    var secondnumber:Double = 0.0

        if (operator == "+") {
            val result = firsrnumber + secondnumber
            println("$firsrnumber + $secondnumber = $result")

        } else if (operator == "-") {
            val result = firsrnumber - secondnumber
            println("$firsrnumber - $secondnumber = $result")

        } else if (operator == "*") {
            val result = firsrnumber * secondnumber
            println("$firsrnumber * $secondnumber = $result")

        } else if (operator == "/") {
            if (secondnumber != 0.0) {
                val result = firsrnumber / secondnumber
                println("$firsrnumber / $secondnumber = $result")
            }
        }else if (operator == "%") {
            if (secondnumber != 0.0) {
                var result = firsrnumber % secondnumber
                println("$firsrnumber % $secondnumber = $result")
            }
        }else {
                println("아무것도아닙니다 .")
            }
}

