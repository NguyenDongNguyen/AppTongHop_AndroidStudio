package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    ListView lvXeCon;
    ArrayList<XeCon> arrayXeCon;
    XeConAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        AnhXa();

        adapter = new XeConAdapter(this, R.layout.dong_trai_cay, arrayXeCon);
        lvXeCon.setAdapter(adapter);

        lvXeCon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ShowList.this, Detail.class);
                XeCon xeCon = arrayXeCon.get(i);
                intent.putExtra("tenxe", xeCon.getTen());
                intent.putExtra("mota", xeCon.getMoTa());
                intent.putExtra("hinh",xeCon.getHinh());
                startActivity(intent);
            }
        });

        lvXeCon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return false;
            }
        });
    }

    private void AnhXa() {
        lvXeCon = (ListView) findViewById(R.id.listviewTraiCay);
        arrayXeCon = new ArrayList<>();
        arrayXeCon.add(new XeCon("Lamborghini","Information Of Car1", R.drawable.car1));
        arrayXeCon.add(new XeCon("Ferrari","Information Of Car2", R.drawable.car2));
        arrayXeCon.add(new XeCon("Porsche","Information Of Car3", R.drawable.car3));
        arrayXeCon.add(new XeCon("MCLaren","Information Of Car4", R.drawable.car4));
        arrayXeCon.add(new XeCon("Bentley","Information Of Car5", R.drawable.car5));
    }

    private void XacNhanXoa(int position) {
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(this);
        alertDiaLog.setTitle("Thông báo!");
        alertDiaLog.setIcon(R.drawable.warning);
        alertDiaLog.setMessage("Bạn có muốn xoá xe này không?");

        alertDiaLog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayXeCon.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alertDiaLog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDiaLog.show();
    }
}