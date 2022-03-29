package com.zacdoc.p2_fragmentedcalculator

class Calculations {
//    "[A-Z0-9<\n]+".toRegex().matches(inputEquation)

    fun checkIfNumber(equation: String): Boolean{
        return (equation.toString().contains(Regex("^[0-9]*\\d*(\\.[1-9]+)?\$"))
                || equation.toString().contains(Regex("^\\.[0-9]+\$")))
    }

    fun checkIfOperation(equation: String, operation: String): Boolean{
        val tempOperation = "\\" + operation
        val pattern = "[-]?[.]?[0-9]+${tempOperation}[-]?[.]?[0-9]+"
        return (equation.contains(Regex(pattern)))
    }

    //Searches for any of the known operators and recursively breaks the math problem in PEMDAS order
    fun Calculate (inputEquation: String): Double{
        //Subtraction / Negative numbers
        if(inputEquation.contains('-')){
            print("Subtraction/Negative number\n")

            //Case in which there are numbers on both sides of the operation (Subtraction)
            if(checkIfOperation(inputEquation, "-")){
                print("Subtraction done right :>\n")
                var difference = Calculate(inputEquation.split(Regex("-"), 2)[0]) - Calculate(inputEquation.split(Regex("-"), 2)[1])
                print("$difference\n")
                return difference
            }
            //Case in which there is only a number to the right of the operation (Negative Number)
            else if(inputEquation.contains(Regex("-[.]?[0-9]+"))){
                println("This is a negative number")

//                var negativeNum = inputEquation.substring(inputEquation.lastIndexOf("-") + 1)
                var removeNegative = inputEquation.substringAfter("-")
                println(removeNegative.substring(0, 0))
                println(removeNegative.subSequence(1, removeNegative.length - 1))
            }
            else{
                print("Subtraction done WRONG >:(\n")

            }
            //Need to check if it's a negative number or a subtraction operation
        }
        //Addition
        else if(inputEquation.contains('+')){
            print("Addition\n")
//            inputEquation.contains(Regex("[-]?[.]?[0-9]+\\+[-]?[.]?[0-9]+"))
            if(checkIfOperation(inputEquation, "+")){
                print("Addition done right :>\n")
                var sum = Calculate(inputEquation.split(Regex("\\+"), 2)[0]) + Calculate(inputEquation.split(Regex("\\+"), 2)[1])
                print("$sum\n")
                return sum
            }
            else{
                print("Addition done WRONG >:(\n")

            }
        }
        //Multiplication
        else if(inputEquation.contains('*')){
            print("Multiplication\n")
            if(checkIfOperation(inputEquation, "*")){
                print("Multiplication done right :>\n")
                var product = Calculate(inputEquation.split(Regex("\\*"), 2)[0]) * Calculate(inputEquation.split(Regex("\\*"), 2)[1])
                print("$product\n")
                return product
            }
            else{
                print("Multiplication done WRONG >:(\n")

            }
        }
        //Division
        else if(inputEquation.contains('÷')){
            print("Division\n")
            if(checkIfOperation(inputEquation,"÷") && inputEquation.split(Regex("÷"), 2)[1] != "0"){
                println("Division done right :>")
                var quotient = Calculate(inputEquation.split(Regex("÷"), 2)[0]) / Calculate(inputEquation.split(Regex("÷"), 2)[1])
                println("$quotient")
                return quotient
            }
            else{
                println("Division done WRONG >:(")
            }
        }
        //Modulus
        else if(inputEquation.contains('%')){
            print("Modulus\n")
            if(checkIfOperation(inputEquation,"%") && inputEquation.split(Regex("%"), 2)[1] != "0"){
                println("Modulus done right :>")
                var remainder = Calculate(inputEquation.split(Regex("%"), 2)[0]) % Calculate(inputEquation.split(Regex("%"), 2)[1])
                println("$remainder")
                return remainder
            }
            else{
                println("Modulus done WRONG >:(")
            }
        }
        //(Base Case) Decimal & Integer values only
        else if(checkIfNumber(inputEquation)){
            print("Numbers\n")
            return inputEquation.toDouble()
        }
        //Errors
        else{
            print("BRUH WHAT IS THIS????\n")
        }
        return -999.0
    }

}