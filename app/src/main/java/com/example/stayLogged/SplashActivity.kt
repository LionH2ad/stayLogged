package com.example.stayLogged

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefsManager = PrefsManager(this)

        // 저장된 유저 정보가 있는지 확인 (let 사용)
        prefsManager.getUser()?.let {
            // 자동 로그인 -> MainActivity로 이동
            startActivity(Intent(this, MainActivity::class.java))
        } ?: run {
            // 로그인 정보 없음 -> LoginActivity로 이동
            startActivity(Intent(this, LoginActivity::class.java))
        }

        finish() // SplashActivity 종료
    }
}