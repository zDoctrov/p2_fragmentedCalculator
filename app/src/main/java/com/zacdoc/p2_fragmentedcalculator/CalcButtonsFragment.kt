package com.zacdoc.p2_fragmentedcalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zacdoc.p2_fragmentedcalculator.databinding.FragmentCalcButtonsBinding
import java.lang.ClassCastException

class CalcButtonsFragment : Fragment() {

    private lateinit var  binding : FragmentCalcButtonsBinding
    var activityCallback : CalcButtonsFragment.CalcButtonsListener? = null

    interface CalcButtonsListener {
        fun addEntry(text: String)
        fun squareRoot()
        fun clearEntry()
        fun clear()
        fun equals()
    }

    override fun onAttach(context : Context) {
        /* onAttach, when given 'Context' during the fragment lifecycle
        (Which is the container activity that the fragment resides in, which the system automatically passes to it as Context),
        so making 'activityCallback = context as CalcButtonsListener' means we're making MainActivity the listener to the fragment

        */
        super.onAttach(context)
        try {
            activityCallback = context as CalcButtonsListener
        }
        catch(e: ClassCastException){
            throw ClassCastException(context.toString() + "must implement CalcButtonsListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcButtonsBinding.inflate(inflater, container, false)

        binding.negativeButton.setOnClickListener{v: View -> buttonClicked(v, "-")}
        binding.decimalButton.setOnClickListener{v: View -> buttonClicked(v, ".")}
        binding.zeroButton.setOnClickListener{ v: View -> buttonClicked(v, "0")}
        binding.oneButton.setOnClickListener{ v: View -> buttonClicked(v, "1")}
        binding.twoButton.setOnClickListener{ v: View -> buttonClicked(v, "2")}
        binding.threeButton.setOnClickListener{ v: View -> buttonClicked(v, "3")}
        binding.fourButton.setOnClickListener{ v: View -> buttonClicked(v,"4")}
        binding.fiveButton.setOnClickListener{ v: View -> buttonClicked(v, "5")}
        binding.sixButton.setOnClickListener{v: View -> buttonClicked(v, "6")}
        binding.sevenButton.setOnClickListener{v: View -> buttonClicked(v, "7")}
        binding.eightButton.setOnClickListener{v: View -> buttonClicked(v, "8")}
        binding.nineButton.setOnClickListener{v: View -> buttonClicked(v, "9")}

        binding.divisionButton.setOnClickListener{v: View -> buttonClicked(v, "/")}
        binding.multiplyButton.setOnClickListener{v: View -> buttonClicked(v, "*")}
        binding.subtractButton.setOnClickListener{v: View -> buttonClicked(v, "-")}
        binding.addButton.setOnClickListener{v: View -> buttonClicked(v, "+")}
        binding.modButton.setOnClickListener{v: View -> buttonClicked(v, "%")}

        binding.sqrtButton.setOnClickListener{v: View -> squareRootClicked(v)}
        binding.clearEntryButton.setOnClickListener{v: View -> clearEntryClicked(v)}
        binding.clearButton.setOnClickListener{v: View -> clearClicked(v)}
        binding.equalButton.setOnClickListener{v: View -> equalClicked(v)}

        return binding.root
    }

    private fun buttonClicked(view: View, entry: String) {
        activityCallback?.addEntry(entry)
    }

    private fun squareRootClicked(view: View){
        activityCallback?.squareRoot()
    }

    private fun clearEntryClicked(view: View){
        activityCallback?.clearEntry()
    }

    private fun clearClicked(view: View){
        activityCallback?.clear()
    }

    private fun equalClicked(view: View){
        activityCallback?.equals()
    }
}