package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {

    private Context context;
    private ArrayList<Food> arr;

    public FoodAdapter(@NonNull Context context, int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arr = new ArrayList<>(objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, null);
        }
        if (arr.size()>0){
            Food food = arr.get(position);
            ImageView imageView = convertView.findViewById(R.id.image);
            TextView textView = convertView.findViewById(R.id.tvname);
            TextView textViewid = convertView.findViewById(R.id.tvid);

            imageView.setImageResource(food.img);
            textView.setText(food.name);
            textViewid.setText(food.money);
        }
        return convertView;
    }
}
