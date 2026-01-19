package com.example.biologyapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Apply saved theme before loading layout
        setTheme(ThemeManager.getTheme(this));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to start TopicListActivity
        Button startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TopicListActivity.class);
            startActivity(intent);
        });


    }
}
