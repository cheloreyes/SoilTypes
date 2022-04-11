package com.chelo.reyes.soiltypes.ui.main.classification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chelo.reyes.soiltypes.databinding.ClassificationFragmentBinding
import com.chelo.reyes.soiltypes.ui.main.MainViewModelFactory

private const val PROFILE_TYPE_KEY = "profile_type_key"
class ClassificationFragment: Fragment() {

    companion object {
        fun newInstance(profileType: String) = ClassificationFragment().apply {
            arguments = Bundle().apply { putString(PROFILE_TYPE_KEY, profileType) }
        }
    }

    private val viewModel by lazy { ViewModelProvider(this, MainViewModelFactory())[ClassificationViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ClassificationFragmentBinding.inflate( inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(PROFILE_TYPE_KEY)?.let {
            viewModel.setType(it)
        }
    }
}