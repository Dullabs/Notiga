package com.dullabs.notiga.ui.chatoptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dullabs.notiga.MainActivity
import com.dullabs.notiga.databinding.FragmentChatOptionsBinding

class ChatOptionsFragment : Fragment() {

    private var _binding: FragmentChatOptionsBinding? = null
    private lateinit var chatOptionsViewModel: ChatOptionsViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatOptionsBinding.inflate(inflater, container, false)
        chatOptionsViewModel =
            ViewModelProvider(this).get(ChatOptionsViewModel::class.java)
        chatOptionsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textChatOptions.text = it
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