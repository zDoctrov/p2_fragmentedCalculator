package com.zacdoc.p2_fragmentedcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zacdoc.p2_fragmentedcalculator.databinding.FragmentCalcDisplayBinding
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.math.truncate

class CalcDisplayFragment : Fragment() {

    private lateinit var binding: FragmentCalcDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeTextProperties(text: String){
        binding.displayTextView.text = binding.displayTextView.text.toString() + text
    }

    fun resetTextProperties(){
        binding.displayTextView.setText(R.string.empty);
    }

    fun removeLastEntry(){
        val currentDisplayText: String = binding.displayTextView.text.toString()
        binding.displayTextView.text = currentDisplayText.subSequence(0, currentDisplayText.length - 1)
    }

    fun calculateCurrentDisplay(){
        var calc = Calculations()
        var result = calc.Calculate( binding.displayTextView.text.toString())

        //Truncate to integer if decimal place contains zero
        if(result.toString().contains(Regex("^[0-9]?[.][1-9]+$"))){
            binding.displayTextView.text = result.toString()
        }
        else{
            binding.displayTextView.text = result.roundToInt().toString()
        }
    }

    fun calculateSquareRoot(){
        var calc = Calculations()
        var result = calc.Calculate( binding.displayTextView.text.toString())
        result = sqrt(result)
        if(result.toString().contains(Regex("^[0-9]?[.][1-9]+$"))){
            binding.displayTextView.text = result.toString()
        }
        else {
            binding.displayTextView.text = result.roundToInt().toString()
        }
    }
}