package com.chelo.reyes.soiltypes.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chelo.reyes.soiltypes.ActivityCallback
import com.chelo.reyes.soiltypes.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by lazy { ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java] }
    private lateinit var callback: ActivityCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            callback = context as ActivityCallback
        } catch (ex: Exception){ }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate( inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDefinitionOfProfile.observe(viewLifecycleOwner){
            callback.findClassification(it)
        }
    }
}