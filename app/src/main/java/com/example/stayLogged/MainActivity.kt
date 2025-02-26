package com.example.stayLogged

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stayLogged.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefsManager: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefsManager = PrefsManager(this)

        val username = prefsManager.getUser()
        binding.tvWelcome.text = "환영합니다, ${username}님!"

        binding.btnLogout.setOnClickListener {
            prefsManager.clearUser() // 로그아웃 시 SharedPreferences 삭제
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // 현재 액티비티 종료
        }
    }
}