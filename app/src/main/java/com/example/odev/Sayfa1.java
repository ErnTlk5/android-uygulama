package com.example.odev;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sayfa1 extends AppCompatActivity {

    EditText etAd, etSoyad, etDogumYili;
    Button btnHesapla, btnGit;
    TextView tvSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sayfa1);

        etAd = findViewById(R.id.etAd);
        etSoyad = findViewById(R.id.etSoyad);
        etDogumYili = findViewById(R.id.etDogumYili);
        btnHesapla = findViewById(R.id.btnHesapla);
        btnGit = findViewById(R.id.btnGit);
        tvSonuc = findViewById(R.id.tvSonuc);

        btnHesapla.setOnClickListener(v -> {
            String ad = etAd.getText().toString().trim();
            String soyad = etSoyad.getText().toString().trim();
            String dogumYiliStr = etDogumYili.getText().toString().trim();

            if (TextUtils.isEmpty(ad) || TextUtils.isEmpty(soyad) || TextUtils.isEmpty(dogumYiliStr)) {
                Toast.makeText(this, "Boş bırakma!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (dogumYiliStr.length() != 4) {
                Toast.makeText(this, "Doğum yılı 4 haneli olmalı!", Toast.LENGTH_SHORT).show();
                return;
            }

            int dogumYili = Integer.parseInt(dogumYiliStr);
            if (dogumYili >= 2024) {
                Toast.makeText(this, "2024'ten küçük bir yıl gir!", Toast.LENGTH_SHORT).show();
                return;
            }

            int yas = 2025 - dogumYili;
            tvSonuc.setText("Merhaba " + ad + " " + soyad + ", yaşınız: " + yas);
        });

        btnGit.setOnClickListener(v -> {
            if (TextUtils.isEmpty(etAd.getText()) || TextUtils.isEmpty(etSoyad.getText()) || TextUtils.isEmpty(etDogumYili.getText())) {
                Toast.makeText(this, "Alanları doldurmadan gidemezsin!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(Sayfa1.this, Sayfa2.class);
                startActivity(intent);
            }
        });
    }
}
