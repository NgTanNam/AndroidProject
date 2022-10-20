package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetail extends AppCompatActivity {

    TextView tvName, tvMoney;
    ImageView imageView;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Anh xa
        tvName = findViewById(R.id.tvName);
        tvMoney = findViewById(R.id.tvMoney);
        imageView = findViewById(R.id.image);
        imageButton = findViewById(R.id.btback);

        Intent intent = getIntent();
        Food food = (Food) intent.getSerializableExtra("data");

        tvName.setText(food.getName());
        tvMoney.setText(food.getMoney());
        imageView.setImageResource(food.getImg());

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ItemDetail.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}