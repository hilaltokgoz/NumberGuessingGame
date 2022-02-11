package com.numberguessinggame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.numberguessinggame.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    //Binding Tanımı
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    //Args Tanımı
    private val args:ResultFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = args.result //Tanımlanılan arg'ı çağırdım.
        if (result == "WIN") {
            binding.resultTextView.text = "WIN"
            binding.resultImage.setImageResource(R.drawable.kazandin)
        } else if (result == "LOST") {
            binding.resultTextView.text = "LOST"
            binding.resultImage.setImageResource(R.drawable.kaybettin)

        }else{
            binding.resultTextView.text = "NULL"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}