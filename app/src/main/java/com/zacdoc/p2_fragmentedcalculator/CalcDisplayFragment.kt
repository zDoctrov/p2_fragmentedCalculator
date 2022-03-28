package com.zacdoc.p2_fragmentedcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zacdoc.p2_fragmentedcalculator.databinding.FragmentCalcDisplayBinding

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
        calc.Calculate( binding.displayTextView.text.toString())
    }
}