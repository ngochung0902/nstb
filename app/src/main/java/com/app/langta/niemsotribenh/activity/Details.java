package com.app.langta.niemsotribenh.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.langta.niemsotribenh.R;
import com.app.langta.niemsotribenh.model.Data;
import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
    TextView tv_ghichu, tv_sotribenh, tv_tenbenh;
    ImageView img_ghichu, img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initUI();
    }

    private void initUI() {
        tv_ghichu = findViewById(R.id.tv_ghichu);
        img_ghichu = findViewById(R.id.img_ghichu);
        tv_sotribenh = findViewById(R.id.tv_sotribenh);
        tv_tenbenh = findViewById(R.id.tv_tenbenh);
        img_back = findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            Intent i = getIntent();
        if (i!=null){
            Data data = (Data)i.getSerializableExtra("data");
            tv_ghichu.setText(data.getGhichu());
            tv_sotribenh.setText(data.getSobenh());
            tv_tenbenh.setText(data.getTenbenh());
            if (data.getUrl_image().length()>0){
                Picasso.get()
                        .load(data.getUrl_image())
                        .into(img_ghichu);
            }
        }
    }
}
