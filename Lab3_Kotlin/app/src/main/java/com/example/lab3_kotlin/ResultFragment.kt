package com.example.lab3_kotlin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    fun setText(result: String){
        if(result.equals(getString(R.string.nothing_selected)) || result.equals(getString(R.string.nothing_selected_item)))
        {
            resultTextView.text = getString(R.string.nothing_selected)
        }
        else
        {
            resultTextView.text = "Great choice, sir, : ${result} is the great movie for evening"
        }
    }


}
