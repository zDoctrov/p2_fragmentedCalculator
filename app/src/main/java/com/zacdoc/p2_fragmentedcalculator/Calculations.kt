package com.zacdoc.p2_fragmentedcalculator

class Calculations {
//    "[A-Z0-9<\n]+".toRegex().matches(inputEquation)

    //Searches for any of the known operators and recursively breaks the math problem in PEMDAS order
    fun Calculate(inputEquation: String){
        //Subtraction / Negative numbers
        if(inputEquation.contains('-')){
            print("Subtraction/Negative number")
        }
        //Addition
        else if(inputEquation.contains('+')){
            print("Addition\n")
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
        //(Base Case) Numbers
        else if(inputEquation.contains("[0-9<]+")){
            print("Numbers\n")
        }
        //Errors
        else{
            print("BRUH WHAT IS THIS????\n")
        }
    }

}