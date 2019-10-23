package com.app.langta.niemsotribenh.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.langta.niemsotribenh.R;
import com.app.langta.niemsotribenh.model.Data;

import java.util.List;

public class Adapter_sotribenh extends BaseAdapter {
    List<Data> postList;
    Context context;

    public Adapter_sotribenh(List<Data> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHoler {
        TextView tv_dolinhnghiem, tv_soniem, tv_tenbenh;

        ViewHoler(View rootView) {
            this.tv_dolinhnghiem = rootView.findViewById(R.id.tv_dolinhnghiem);
            this.tv_soniem = rootView.findViewById(R.id.tv_soniem);
            this.tv_tenbenh = rootView.findViewById(R.id.tv_tenbenh);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.line_sotribenh, null, false);
        ViewHoler holder = new ViewHoler(convertView);
        holder.tv_tenbenh.setText(postList.get(position).getTenbenh());
        holder.tv_soniem.setText(postList.get(position).getSobenh());
        holder.tv_dolinhnghiem.setText(postList.get(position).getDolinhnghiem()+"");
        return convertView;
    }
}