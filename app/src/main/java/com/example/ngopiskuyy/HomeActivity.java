package com.example.ngopiskuyy;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView tvCoffeeName, tvCoffeePrice;
    private ImageView coffeeImage;
    private EditText username, email, address, phoneNumber;
    private Button buyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Inisialisasi views
        tvCoffeeName = findViewById(R.id.tvCoffeeName);
        tvCoffeePrice = findViewById(R.id.price);
        coffeeImage = findViewById(R.id.coffee);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        phoneNumber = findViewById(R.id.phoneNumber);
        buyNow = findViewById(R.id.buyNow);

        // Ambil data dari Intent
        Intent receivedIntent = getIntent();
        String coffeeName = receivedIntent.getStringExtra("COFFEE_NAME");
        String coffeePrice = receivedIntent.getStringExtra("COFFEE_PRICE");

        // Tampilkan data di TextView
        tvCoffeeName.setText(coffeeName);
        tvCoffeePrice.setText(coffeePrice);

        // Set gambar kopi sesuai dengan yang dipilih
        setCoffeeImage(coffeeName);

        // Tambahkan listener untuk button "Buy Now"
        buyNow.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, OrderItemsActivity.class);
            intent.putExtra("COFFEE_NAME", tvCoffeeName.getText().toString());
            intent.putExtra("COFFEE_PRICE", tvCoffeePrice.getText().toString());
            intent.putExtra("COFFEE_IMAGE", getCoffeeImageResource(coffeeName)); // Mengambil resource gambar
            startActivity(intent);
        });
    }

    private void setCoffeeImage(String coffeeName) {
        switch (coffeeName) {
            case "Americano":
                coffeeImage.setImageResource(R.drawable.kopiamericano);
                break;
            case "Cappuccino":
                coffeeImage.setImageResource(R.drawable.kopicappucino);
                break;
            case "Espresso":
                coffeeImage.setImageResource(R.drawable.kopiespresso);
                break;
            case "Latte":
                coffeeImage.setImageResource(R.drawable.kopilatte);
                break;
            default:
                coffeeImage.setImageResource(R.drawable.logokeranjang2); // Gambar default
                break;
        }
    }

    private int getCoffeeImageResource(String coffeeName) {
        switch (coffeeName) {
            case "Americano":
                return R.drawable.kopiamericano;
            case "Cappuccino":
                return R.drawable.kopicappucino;
            case "Espresso":
                return R.drawable.kopiespresso;
            case "Latte":
                return R.drawable.kopilatte;
            default:
                return R.drawable.logokeranjang2; // Gambar default
        }
    }
}