package com.example.ed_06
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val whatsAppButton = findViewById<Button>(R.id.openWhatsappButton)
        val exitButton = findViewById<Button>(R.id.closeAppButton)

        whatsAppButton.setOnClickListener {
            val number = "+5541997560527"
            val message = "Mensagem enviada pelo codigo em Kotlin"
            val url = "https://wa.me/$number?text=${Uri.encode(message)}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        exitButton.setOnClickListener {
            System.exit(0);
        }
    }
}