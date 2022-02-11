package com.numberguessinggame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.numberguessinggame.databinding.FragmentPredictionFragmentBinding

class PredictionFragmentFragment : Fragment() {
    private var _binding: FragmentPredictionFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPredictionFragmentBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*//Navigation yolu tanımlaması
   binding.predictionButton.setOnClickListener {
       findNavController().navigate(R.id.predictionToResult)
   }
*/
        var hak = 10
        binding.remainingText.text=hak.toString()
        val randomNumber = (0..1).random() //random sayi üretmek için
        var prediction=0
        //Boş olup olmadığını kontrol ettiriyorsun
        //val prediction = if (binding.predictionEditText.toString().isDigitsOnly())
       // binding.predictionEditText.toString().toInt()
       // else 0
        binding.predictionButton.setOnClickListener {
            if (binding.predictionEditText.text.toString()
                    .isEmpty() || binding.predictionEditText.text.toString() == ""
            ) {
                Toast.makeText(context, "Lütfen bir tahminde bulunun!", Toast.LENGTH_SHORT).show()
            } else {

                hak -= 1
                binding.remainingText.text = "KalanHak:$hak".toString()
                prediction=binding.predictionEditText.text.toString().toInt()
                when {
                    prediction > randomNumber -> {
                        binding.helperText.text = "Yardımcı: Azalt"
                    }
                    prediction < randomNumber -> {
                        binding.helperText.text = "Yardımcı: Artır"
                    }//Geçiş yapma işlemi eşit olduğunda
                    prediction == randomNumber -> {
                        val action = PredictionFragmentFragmentDirections.predictionToResult("WIN")
                        findNavController().navigate(action)
                    }
                }
                if (hak == 0) {
                    val action = PredictionFragmentFragmentDirections.predictionToResult("LOST")
                    findNavController().navigate(action)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}