package com.example.signin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    TextView txtDetail, txtMoTa;
    ImageView imgViewHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetail = (TextView) findViewById(R.id.textViewDetail);
        txtMoTa = (TextView) findViewById(R.id.textViewMota);
        imgViewHinh = (ImageView) findViewById(R.id.imageViewHinh);

        Intent intent = getIntent();

        String noiDung = intent.getStringExtra("tenxe");
        txtDetail.setText(noiDung);

        String moTa = intent.getStringExtra("mota");
        txtMoTa.setText(moTa);

        int hinhAnh = intent.getIntExtra("hinh", 1);
        imgViewHinh.setImageResource(hinhAnh);

    }
}