package com.example.lab2_kotlin


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
        if(result.equals(R.string.nothing_selected.toString()))
        {
            resultTextView.text = getString(R.string.nothing_selected)
        }
        else
        {
            resultTextView.text = "Your choice: ${result}"
        }
    }


}
