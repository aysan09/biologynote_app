package com.example.biologyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class TopicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Apply theme first
        setTheme(ThemeManager.getTheme(this));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        // Dark mode toggle button
        ImageButton toggleDarkBtn = findViewById(R.id.toggleDarkBtn);
        toggleDarkBtn.setOnClickListener(v -> {
            // Flip the current mode
            boolean isDark = !ThemeManager.isDarkMode(this);
            ThemeManager.setDarkMode(this, isDark);

            // Restart this activity to apply new theme
            recreate();
        });


        ListView list = findViewById(R.id.topicListView);

        // Get all titles from StorageManager
        List<String> titles = StorageManager.getTitles(this);

        // Display titles in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item,
                titles
        );
        list.setAdapter(adapter);

        // Handle item click
        list.setOnItemClickListener((parent, view, position, id) -> {

            String title = StorageManager.getTitles(this).get(position);
            String content = StorageManager.getContent(this, position);

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("content", content);
            startActivity(intent);
        });
    }
}
