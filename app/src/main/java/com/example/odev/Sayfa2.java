package com.example.odev;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sayfa2 extends AppCompatActivity {

    CheckBox cbKitap, cbSpor, cbSinema;
    Button btnGoster;
    TextView tvHobiSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sayfa2);

        cbKitap = findViewById(R.id.cbKitap);
        cbSpor = findViewById(R.id.cbSpor);
        cbSinema = findViewById(R.id.cbSinema);
        btnGoster = findViewById(R.id.btnGoster);
        tvHobiSonuc = findViewById(R.id.tvHobiSonuc);

        btnGoster.setOnClickListener(v -> {
            StringBuilder secimler = new StringBuilder("Seçilen Hobiler:\n");

            if (cbKitap.isChecked()) secimler.append("Kitap\n");
            if (cbSpor.isChecked()) secimler.append("Spor\n");
            if (cbSinema.isChecked()) secimler.append("Sinema\n");

            if (secimler.toString().equals("Seçilen Hobiler:\n")) {
                secimler = new StringBuilder("Hiç hobi seçmediniz.");
            }

            tvHobiSonuc.setText(secimler.toString());
        });
    }
}
