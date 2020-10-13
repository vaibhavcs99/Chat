package com.example.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<UserOne> list1;
    ArrayList<UserTwo> list2;
    String temp;
    private static final int USER_ONE = 1;
    private static final int USER_TWO = 2;


    public ChatAdapter(ArrayList<UserOne> list1, ArrayList<UserTwo> list2) {
        
        this.list1 = list1;
        this.list2 = list2;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == USER_ONE) {

            View view = inflater.inflate(R.layout.chatwindow, parent, false);
            return new ChatViewHolder(view);

        } else {

            View view = inflater.inflate(R.layout.chatwindow2, parent, false);
            return new ChatViewHolder2(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChatViewHolder) {

            UserOne data = list1.get(position);
            temp = data.toString();

            ((ChatViewHolder) holder).tv1.setText(temp);

        } else {

            UserTwo data = list2.get(position);
            temp = data.toString();
            ((ChatViewHolder2) holder).tv2.setText(temp);

        }
    }


    @Override
    public int getItemViewType(int position) {

        if (list1.get(position) instanceof UserOne) {

            return USER_ONE;

        }
        else {

            return USER_TWO;

        }

    }

    @Override
    public int getItemCount() {
        int i = list1.size() + list2.size() + 1;
        return i;
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

    public static class ChatViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv2;

        public ChatViewHolder2(@NonNull View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
