package com.example.lab5;

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

public class UserAdapter extends ArrayAdapter<User> {

    private Context context;
    private ArrayList<User> arr;

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
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
            User user = arr.get(position);
            ImageView imageView = convertView.findViewById(R.id.image);
            TextView textView = convertView.findViewById(R.id.tvname);
            TextView textViewid = convertView.findViewById(R.id.tvid);

            imageView.setImageResource(user.img);
            textView.setText(user.name);
            textViewid.setText(user.id);
        }
        return convertView;
    }
}
