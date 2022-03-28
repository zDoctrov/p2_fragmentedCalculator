package com.zacdoc.p2_fragmentedcalculator

class Calculations {
//    "[A-Z0-9<\n]+".toRegex().matches(inputEquation)

    //Searches for any of the known operators and recursively breaks the math problem in PEMDAS order
    fun Calculate (inputEquation: String): Double{
        //Subtraction / Negative numbers
        if(inputEquation.contains('-')){
            print("Subtraction/Negative number\n")
        }
        //Addition
        else if(inputEquation.contains('+')){
            print("Addition\n")
            if(inputEquation.contains(Regex("[0-9]+\\+[0-9]+"))){
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
        }
        //Division
        else if(inputEquation.contains('÷')){
            print("Division\n")
        }
        //Modulus
        else if(inputEquation.contains('%')){
            print("Modulus\n")
        }
        //(Base Case) Decimal & Integer values only
        //TODO: Make it so .1 + .1 results in .2
        else if(inputEquation.contains(Regex("^[+-]?[0-9]+\\.?[0-9]*\$"))
                    || inputEquation.contains(Regex("^\\.[0-9]+\$"))){
            print("Numbers\n")
            return inputEquation.toDouble()
        }
        //Errors
        else{
            print("BRUH WHAT IS THIS????\n")
        }
        return 0.0
    }

}