package com.example.tomas.prooptyk.screen.main.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tomas.prooptyk.R
import com.example.tomas.prooptyk.databinding.FragmentEyeglassBinding
import com.example.tomas.prooptyk.utils.adapter.EyeglassAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class EyeglassFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    private lateinit var binding: FragmentEyeglassBinding

    private var recyclerView : RecyclerView? = null

    @Inject
    lateinit var eyeglassAdapter : EyeglassAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<FragmentEyeglassBinding>(inflater, R.layout.fragment_eyeglass, container, false)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(EyeglassFragmentViewModel::class.java)

        recyclerView = binding.root.findViewById(R.id.eyeglassRecyclerView)

        viewModel.getEyeglassList().observe(this, Observer { eyeglassArray ->
            eyeglassAdapter!!.setEyeglassList(eyeglassArray)
            recyclerView!!.layoutManager = LinearLayoutManager(this.activity)
            recyclerView!!.adapter = eyeglassAdapter


        })
        return binding.root
    }

    companion object {
        fun newInstance(): EyeglassFragment = EyeglassFragment()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }

}
