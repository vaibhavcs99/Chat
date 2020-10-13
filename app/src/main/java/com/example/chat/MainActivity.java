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
    UserOne text1;
    UserTwo text2;
    String temp;
    ArrayList<UserOne> list1 = new ArrayList<UserOne>();
    ArrayList<UserTwo> list2 = new ArrayList<UserTwo>();

    Button send1;
    Button send2;
    ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1.add(new UserOne("text1"));
        list2.add(new UserTwo("text2"));


        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        send1 = findViewById(R.id.send1);
        send2 = findViewById(R.id.send2);



        RecyclerView recyclerView =findViewById(R.id.recycler_xml);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ChatAdapter(list1,list2);
        recyclerView.setAdapter(adapter);

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = et1.getText().toString();
                text1 = new UserOne(temp);
                et1.getText().clear();
                list1.add(text1);
                adapter.notifyDataSetChanged();
            }
        });

        send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = et2.getText().toString();
                text2 = new UserTwo(temp);
                et2.getText().clear();
                list2.add(text2);
                adapter.notifyDataSetChanged();

            }
        });


    }
}