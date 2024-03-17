package com.example.tutor.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tutor.PopularAdapter

import com.example.tutor.R
import com.example.tutor.databinding.FragmentHome2Binding
import com.example.tutor.databinding.FragmentMenuBottomSheetBinding
import com.example.tutor.menuBottomSheetFragment


class home2Fragment : Fragment() {

   private lateinit var binding : FragmentHome2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHome2Binding.inflate(inflater,container,false)

        binding.viewAllClick.setOnClickListener {
            val bottomSheetDialog = menuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1))
        imageList.add(SlideModel(R.drawable.banner2))
        imageList.add(SlideModel(R.drawable.banner3))
        imageList.add(SlideModel(R.drawable.banner4))



        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)



        val facultyName = listOf("aman","gourav","kuldeep","atharv")
        val education = listOf("b","c","d","e")
        val facultyImages = listOf(R.drawable.banner1,R.drawable.banner1,R.drawable.banner1,R.drawable.banner1)

        val adapter = PopularAdapter(facultyName,education,facultyImages)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
    companion object {

    }
}