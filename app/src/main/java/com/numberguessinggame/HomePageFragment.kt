package com.numberguessinggame

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.numberguessinggame.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    //Fragment'ta viewBinding kurulumu
    private var _binding: FragmentHomePageBinding?=null
    //lateinit var olarak tanımlanmadığı için default olarak null değeri verildi.
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomePageBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//anasayfadan tahmin sayfasına geçiş işlemi
   binding.playButton.setOnClickListener {
       findNavController().navigate(R.id.homePageToPrediction)
   }






    }
    //Oluşturulan view kapandığında yapılmasını istediklerimizi yazacağımız fonksiyondur.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null //ui ile ilgili veriler gereksiz yer kaplamasın diye
    }
}