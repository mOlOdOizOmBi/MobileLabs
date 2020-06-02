package com.example.lab3_kotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*



class MainFragment : Fragment() {

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(result: String)
    }

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SetAdapter()

        buttonOkSetup()

        buttonCancelSetup()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }




    fun SetAdapter()
    {
        val adapter = ArrayAdapter(
            this.context!!,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.films).toList()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner!!.adapter = adapter
    }

    fun buttonOkSetup()
    {
        buttonOk.setOnClickListener{

                listener?.onFragmentInteraction(spinner?.selectedItem.toString())

        }
    }

    fun buttonCancelSetup()
    {
        buttonCancel.setOnClickListener {
            spinner?.setSelection(0)
            listener?.onFragmentInteraction(getString(R.string.nothing_selected))
        }
    }



}
