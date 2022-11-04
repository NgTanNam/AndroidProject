package com.example.lab8;

import android.content.DialogInterface;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Database database;
    ImageButton button, btthoat;
    ListView listView;
    int itent;
    ArrayList<SinhVien> array, a;
    SinhVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);
        array = new ArrayList<>();

        adapter = new SinhVienAdapter(this, R.layout.item_sinhvien, array);
        listView.setAdapter(adapter);

        database = new Database(this, "Qldata", null, 1);

        database.QueryData("Create table if not exists Sinhvien(id integer primary key autoincrement, ten text, msv text)");
//        database.QueryData("Insert into SinhVien(ten, msv) values('Nguyen Tan Nam', '1911505310239')");

        Cursor data;
        data = database.GetData("Select * from Sinhvien");

        array.clear();

        while (data.moveToNext()){

            int id = data.getInt(0);
            String ten = data.getString(1);
            String msv = data.getString(2);

            array.add(new SinhVien(id, ten, msv));
        }
//        array.add(new SinhVien(123, "Nam", "12345667"));
//        Log.d("TAG", "onCreate: ${adapter}");
        adapter.notifyDataSetChanged();


        button = (ImageButton) findViewById(R.id.btnadd);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemSinhVien.class);
                startActivity(intent);
            }
        });


    }



    public void suasv(int id, String ten, String msv){
        Intent intent = new Intent(MainActivity.this, ThemSinhVien.class);

        intent.putExtra("id", id);
        intent.putExtra("ten",ten);
        intent.putExtra("msv",msv);

        startActivity(intent);
    }
    public void xoasv(int idxoa){

        database.QueryData("Delete from Sinhvien where id = '"+ idxoa +"'");

        resetlist();
    }
    public void resetlist(){
        Cursor data;

        data = database.GetData("Select * from Sinhvien");

        array.clear();
        while (data.moveToNext()){
            int id = data.getInt(0);
            String ten = data.getString(1);
            String msv = data.getString(2);

            array.add(new SinhVien(id, ten, msv));
        }
        adapter.notifyDataSetChanged();
    }



}