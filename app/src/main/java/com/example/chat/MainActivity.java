package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    UserText text;

    String temp;
    ArrayList<UserText> list = new ArrayList<UserText>();
    Button send1;
    Button send2;
    ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        send1 = findViewById(R.id.send1);
        send2 = findViewById(R.id.send2);



        RecyclerView recyclerView =findViewById(R.id.recycler_xml);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ChatAdapter(list);
        recyclerView.setAdapter(adapter);

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = et1.getText().toString();
                text = new UserText(temp,1);
                et1.getText().clear();
                list.add(text);
                adapter.notifyDataSetChanged();
            }
        });

        send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = et2.getText().toString();
                text = new UserText(temp,2);
                et2.getText().clear();
                list.add(text);
                adapter.notifyDataSetChanged();

            }
        });


    }
}