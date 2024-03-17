package com.example.tutor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutor.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class menuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayout {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        val menufacultyName = listOf("aman", "gourav", "kuldeep", "atharv")
        val menueducation = listOf("b", "c", "d", "e")
        val menufacultyImages =
            listOf(R.drawable.banner1, R.drawable.banner1, R.drawable.banner1, R.drawable.banner1)

        val adapter = menuAdapter(menufacultyName as MutableList<String>,
            menueducation as MutableList<String>, menufacultyImages as MutableList<Int>
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root

    }

    companion object {

    }
}