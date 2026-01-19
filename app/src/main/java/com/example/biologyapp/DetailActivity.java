package com.example.biologyapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;


public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apply the saved theme (light or dark)
        setTheme(ThemeManager.getTheme(this));

        // Set the layout
        setContentView(R.layout.activity_detail);

        // Find views
        TextView title = (TextView) findViewById(R.id.titleTV);
        TextView content = (TextView) findViewById(R.id.contentTV);

        // Set the text from intent extras
        String titleText = getIntent().getStringExtra("title");
        String contentText = getIntent().getStringExtra("content");

        if (titleText != null) {
            title.setText(titleText);
        }

        if (contentText != null) {
            content.setText(contentText);
        }
    }

}