package me.syamfdl.simpleapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi.*
import me.syamfdl.simpleapp.databinding.FragmentPersegiBinding

/**
 * A simple [Fragment] subclass.
 */
class PersegiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPersegiBinding>(inflater, R.layout.fragment_persegi, container, false)



        binding.tvLuas.setVisibility(View.GONE)
        binding.tvKeliling.setVisibility(View.GONE)
        binding.btnShare.setVisibility(View.GONE)

        binding.btnHitung.setOnClickListener {

            var panjangPersegi = etPanjang.text.toString().toDouble()
            var lebarPersegi = etLebar.text.toString().toDouble()

            var luasPersegi = panjangPersegi * lebarPersegi
            var kelilingPersegi = 2*(panjangPersegi + lebarPersegi)

            binding.tvLuas.setVisibility(View.VISIBLE)
            binding.tvKeliling.setVisibility(View.VISIBLE)
            binding.btnShare.setVisibility(View.VISIBLE)

            tvLuas.text = luasPersegi.toString()

            tvKeliling.text = kelilingPersegi.toString()
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}
