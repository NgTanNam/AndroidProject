package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThemSinhVien extends AppCompatActivity {

    Database database;
    int it;
    EditText editTextmsv, editTextten;
    Button btluu, bthuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien);

        database = new Database(this, "Qldata", null, 1);
        editTextmsv = (EditText) findViewById(R.id.edittextmsv);
        editTextten = (EditText) findViewById(R.id.edittextten);
        btluu = (Button) findViewById(R.id.btluu);
        bthuy = (Button) findViewById(R.id.bthuy);
        //lay du lieu sua
        Intent intent = getIntent();
        it = intent.getIntExtra("so",0);
        int idsua = intent.getIntExtra("id",-1);
        String suaten = intent.getStringExtra("ten");
        String suamsv = intent.getStringExtra("msv");
        if(idsua != -1){
            editTextten.setText(suaten);
            editTextmsv.setText(suamsv);
        }


        btluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTextten.getText().toString();
                String msv = editTextmsv.getText().toString();
                if (ten.equals("") || msv.equals("")){
                    Toast.makeText(ThemSinhVien.this, "Vui lòng nhập đủ dữ liệu.", Toast.LENGTH_SHORT).show();
                }else {
                    if (idsua != -1){
                        database.QueryData("Update SinhVien Set ten ='"+ ten +"', msv ='"+ msv +"' where id ='"+ idsua +"' ");

                    }else {

                        database.QueryData("Insert into SinhVien(ten, msv) values('"+ ten +"', '"+ msv +"')");

                    }
                    Toast.makeText(ThemSinhVien.this, "Đã lưu.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ThemSinhVien.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        bthuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ThemSinhVien.this, MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });

    }
}