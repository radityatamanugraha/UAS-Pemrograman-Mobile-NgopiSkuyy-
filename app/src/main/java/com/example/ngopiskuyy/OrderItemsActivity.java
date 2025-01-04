package com.example.ngopiskuyy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OrderItemsActivity extends AppCompatActivity {

    private ImageView backButton, coffeeImage;
    private TextView titleText, coffeeNameText, coffeePriceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_order_items);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Inisialisasi views
        coffeeImage = findViewById(R.id.coffeeImage);
        coffeeNameText = findViewById(R.id.coffeeNameText);
        coffeePriceText = findViewById(R.id.coffeePriceText);
        titleText = findViewById(R.id.titleText);

        // Ambil data dari Intent
        Intent intent = getIntent();
        String coffeeName = intent.getStringExtra("COFFEE_NAME");
        String coffeePrice = intent.getStringExtra("COFFEE_PRICE");
        int coffeeImageResource = intent.getIntExtra("COFFEE_IMAGE", R.drawable.logokeranjang2); // Gambar default jika tidak ada

        // Tampilkan data di TextView dan ImageView
        coffeeNameText.setText(coffeeName);
        coffeePriceText.setText(coffeePrice);
        coffeeImage.setImageResource(coffeeImageResource);


    }
}