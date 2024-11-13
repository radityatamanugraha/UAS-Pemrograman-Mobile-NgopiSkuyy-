package com.example.ngopiskuyy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout americanoLayout, cappuccinoLayout, espressoLayout, latteLayout;
    private TextView tvTitle, tvSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Initialize views
        initializeViews();

        // Set click listeners for each coffee item
        setItemClickListeners();
    }

    private void initializeViews() {
        tvTitle = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);

        // Coffee items layouts
        americanoLayout = findViewById(R.id.americanoLayout);
        cappuccinoLayout = findViewById(R.id.cappuccinoLayout);
        espressoLayout = findViewById(R.id.espressoLayout);
        latteLayout = findViewById(R.id.latteLayout);
    }

    private void setItemClickListeners() {
        // Americano
        americanoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHomeActivity("Americano", "Rp10.000");
            }
        });

        // Cappuccino
        cappuccinoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHomeActivity("Cappuccino", "Rp20.000");
            }
        });

        // Espresso
        espressoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHomeActivity("Espresso", "Rp30.000");
            }
        });

        // Latte
        latteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHomeActivity("Latte", "Rp40.000");
            }
        });
    }

    private void navigateToHomeActivity(String coffeeName, String price) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("COFFEE_NAME", coffeeName);
        intent.putExtra("COFFEE_PRICE", price);
        startActivity(intent);
    }
}
