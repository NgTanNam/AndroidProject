package com.example.lab8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    private MainActivity context;
    private int layout;
    private List<SinhVien> sinhViens;

    public SinhVienAdapter(MainActivity context, int layout, List<SinhVien> svList) {
        this.context = context;
        this.layout = layout;
        this.sinhViens = svList;
    }

    @Override
    public int getCount() {
        return sinhViens.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtname, txtmsv;
        ImageButton imagexoa, imagesua;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtname = (TextView) view.findViewById(R.id.tv_name);
            holder.txtmsv = (TextView) view.findViewById(R.id.tv_msv);
            holder.imagesua = (ImageButton) view.findViewById(R.id.btn_edit);
            holder.imagexoa = (ImageButton) view.findViewById(R.id.btn_delete);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        SinhVien sv = sinhViens.get(i);

        holder.txtname.setText(sv.getTen());
        holder.txtmsv.setText(sv.getMsv());

        holder.imagexoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.xoasv(sv.getId());
            }
        });

        holder.imagesua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Toast.makeText(context, "Sua"+thuPhi.getId(), Toast.LENGTH_SHORT).show();
                context.suasv(sv.getId(),sv.getTen(),sv.getMsv());


            }
        });
        return view;
    }


}
