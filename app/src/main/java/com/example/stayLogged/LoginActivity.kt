package com.example.stayLogged

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stayLogged.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefsManager: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefsManager = PrefsManager(this)

        // 자동 로그인 처리 (let 사용)
        prefsManager.getUser()?.let {
            navigateToMain(it)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etID.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                prefsManager.saveUser(username) // SharedPreferences 저장
                navigateToMain(username)
            } else {
                Toast.makeText(this, "아이디와 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMain(username: String) {
        Toast.makeText(this, "$username 님, 환영합니다!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
        finish() // 현재 액티비티 종료
    }
}