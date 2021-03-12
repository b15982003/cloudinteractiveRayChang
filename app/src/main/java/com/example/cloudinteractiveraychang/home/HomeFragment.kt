package com.example.cloudinteractiveraychang.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cloudinteractiveraychang.MainActivity
import com.example.cloudinteractiveraychang.R

/**
 * 主頁
 */

class HomeFragment : Fragment(), HomeView {

    private lateinit var presenter: HomePresenter
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(this, HomeModel(MainActivity()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        btnNext = view.findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_global_colorFragment)
        }
        return view
    }
}