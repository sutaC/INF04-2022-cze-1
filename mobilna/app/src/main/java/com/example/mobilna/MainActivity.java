package com.example.mobilna;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnLike, btnDelete;
    private TextView tvLikes;

    private int likes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnDelete = findViewById(R.id.btnDelete);
        btnLike = findViewById(R.id.btnLike);
        tvLikes = findViewById(R.id.tvLikes);

//    Listeners
        btnDelete.setOnClickListener(e -> {
            likes--;
            if(likes < 0){
                likes = 0;
            }
            tvLikes.setText(likes + " polubień");
        });
        btnLike.setOnClickListener(e -> {
            likes++;
            tvLikes.setText(likes + " polubień");
        });
    }
}