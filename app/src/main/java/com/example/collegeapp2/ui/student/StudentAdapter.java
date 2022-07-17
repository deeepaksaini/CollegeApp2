package com.example.collegeapp2.ui.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeapp2.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewAdapter> {

    private List<StudentData> list;
    private Context context;

    public StudentAdapter(List<StudentData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item_layout, parent, false);
        return new StudentViewAdapter(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StudentViewAdapter holder, int position) {
        StudentData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.roll_no.setText(item.getRoll_no());
        holder.phone_No.setText(item.getPhone_No());
        holder.session.setText(item.getSession());
        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.avatarprofile).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewAdapter extends RecyclerView.ViewHolder {
        private TextView name, email, roll_no, phone_No, session;
        private ImageView imageView;


        public StudentViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentName);
            roll_no = itemView.findViewById(R.id.studentRoll_No);
            email = itemView.findViewById(R.id.studentEmail);
            phone_No = itemView.findViewById(R.id.studentPhone);
            session = itemView.findViewById(R.id.studentSession);
            imageView = itemView.findViewById(R.id.studentImage);

        }
    }
}
