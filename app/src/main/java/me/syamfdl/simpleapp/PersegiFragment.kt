package me.syamfdl.simpleapp


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi.*
import me.syamfdl.simpleapp.databinding.FragmentPersegiBinding
import java.lang.Exception
import kotlin.math.min

/**
 * A simple [Fragment] subclass.
 */
class PersegiFragment : Fragment() {

    var luasPersegi = 0
    var kelilingPersegi = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPersegiBinding>(inflater, R.layout.fragment_persegi, container, false)

        if (savedInstanceState != null) {
            // Get all the game state information from the bundle, set it
            luasPersegi = savedInstanceState.getInt("luas")
            kelilingPersegi = savedInstanceState.getInt("keliling")
        }

        binding.luasp = luasPersegi
        binding.kelilingp = kelilingPersegi


        binding.btnHitung.setOnClickListener {

            var panjangPersegi = etPanjang.text.toString().toDouble()
            var lebarPersegi = etLebar.text.toString().toDouble()

            luasPersegi = (panjangPersegi * lebarPersegi).toInt()
            kelilingPersegi = (2*(panjangPersegi + lebarPersegi)).toInt()

            binding.luasp = luasPersegi
            binding.kelilingp = kelilingPersegi

        }

        binding.btnShare.setOnClickListener {
            var message = tvLuas.text.toString().trim()
            sendEmail(recipient = "syamfdl.lvlup@gmail.com", subject = "nilai", message = message)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {

        val mIntent = Intent(Intent.ACTION_SEND)

        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(mIntent, "www.gmail.com"))
        }
        catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("luas", luasPersegi)
        outState.putInt("keliling", kelilingPersegi)
        super.onSaveInstanceState(outState)
    }


}
