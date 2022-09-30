package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvUser);
        ArrayList<User> arr = new ArrayList<>();

        arr.add(new User(R.drawable.man, "1911505310239", "Nguyễn Tấn Năm"));
        arr.add(new User(R.drawable.man1, "19115053101", "Nguyễn Văn Tây"));
        arr.add(new User(R.drawable.man2, "1911505310260", "Phạm Văn Thiên"));
        arr.add(new User(R.drawable.woman, "1234567890", "Nguyễn Thị A"));
        arr.add(new User(R.drawable.woman1, "5671234890", "Nguyễn Thị B"));
        arr.add(new User(R.drawable.gamer, "1567892340", "Nguyễn Văn A"));
        arr.add(new User(R.drawable.woman, "2345617890", "Phạm Thị A"));
        arr.add(new User(R.drawable.man, "5678901234", "Nguyễn Văn B"));
        arr.add(new User(R.drawable.man2, "6789123450", "Phạm Văn A"));
        arr.add(new User(R.drawable.man1, "8123456790", "Nguyễn Văn B"));

        UserAdapter adapter = new UserAdapter(this, 0,arr);
        lv.setAdapter(adapter);
    }
}