package com.zacdoc.p2_fragmentedcalculator
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.util.Log;
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zacdoc.p2_fragmentedcalculator.databinding.FragmentCalcDisplayBinding
import kotlin.math.roundToInt
import kotlin.math.sqrt


//TODO: Need to make a separate file for vertical and horizontal versions of screen
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
        if( binding.displayTextView.text.toString() == "ERROR"){
            binding.displayTextView.text =  text
        }
        else{
            binding.displayTextView.text = binding.displayTextView.text.toString() + text
        }
    }

    fun resetTextProperties(){
        binding.displayTextView.setText(R.string.empty);
    }

    fun removeLastEntry(){
        val currentDisplayText: String = binding.displayTextView.text.toString()
        binding.displayTextView.text = currentDisplayText.subSequence(0, currentDisplayText.length - 1)
    }

    fun calculateCurrentDisplay(){
        //Use the MOZILLA RHINO - JavaScript Engine library to solve the display's arithmetic
        val context: Context = Context.enter()
        context.setOptimizationLevel(-1)
        val scope: Scriptable = context.initStandardObjects()
        var result: Any = context.evaluateString(scope,  binding.displayTextView.text.toString(), "<cmd>", 1, null)
        binding.displayTextView.text = result.toString()
    }

    fun calculateSquareRoot(){
        binding.displayTextView.setText("Math.sqrt(" + binding.displayTextView.text.toString() + ")")
        calculateCurrentDisplay()

    }
}