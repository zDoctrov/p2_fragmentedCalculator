package com.zacdoc.p2_fragmentedcalculator

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), CalcButtonsFragment.CalcButtonsListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun addEntry(text: String) {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as CalcDisplayFragment
        calcDisplayFragment.changeTextProperties(text)
    }//end onButtonClick

    override fun squareRoot() {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as CalcDisplayFragment
        calcDisplayFragment.resetTextProperties()
    }

    override fun clearEntry() {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as CalcDisplayFragment
        calcDisplayFragment.removeLastEntry()
    }

    override fun clear() {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as CalcDisplayFragment
        calcDisplayFragment.resetTextProperties()
    }

    override fun equals() {
        val calcDisplayFragment = supportFragmentManager.findFragmentById(R.id.calcDisplayFragment) as CalcDisplayFragment
        calcDisplayFragment.calculateCurrentDisplay()
    }


}