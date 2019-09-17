package com.example.tuan2p2bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mylist;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btnnhap;
    private TextView tvkq;
    private EditText etten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylist=new ArrayList<String>();
        etten=findViewById(R.id.editText_ten);
        list=findViewById(R.id.list);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mylist);
        list.setAdapter(adapter);
        btnnhap=findViewById(R.id.button_nhap);
        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.add(etten.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
        tvkq=findViewById(R.id.textView_kq);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mgs="position: "+i;
                mgs+="; value: "+adapterView.getItemAtPosition(i).toString();
                tvkq.setText(mgs);
            }
        });

    }
}
