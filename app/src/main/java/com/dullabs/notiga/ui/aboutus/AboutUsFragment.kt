package com.dullabs.notiga.ui.aboutus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dullabs.notiga.MainActivity
import com.dullabs.notiga.databinding.FragmentAboutusBinding

class AboutUsFragment : Fragment() {

    private var _binding: FragmentAboutusBinding? = null
    private lateinit var aboutUsViewModel: AboutUsViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutusBinding.inflate(inflater, container, false)
        aboutUsViewModel =
            ViewModelProvider(this).get(AboutUsViewModel::class.java)
        aboutUsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textAboutUs.text = it
        })
        hideBottomControls()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBottomControls()
        _binding = null
    }

    private fun hideBottomControls() {
        (activity as MainActivity).hideBottomAppBar()
        (activity as MainActivity).hideBottomFab()
    }

    private fun showBottomControls() {
        (activity as MainActivity).showBottomAppBar()
        (activity as MainActivity).showBottomFab()
    }

}