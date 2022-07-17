package com.example.collegeapp2.ebook;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycle;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        ebookRecycle=findViewById(R.id.ebookRecycle);
        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list =new ArrayList<>();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    EbookData data=snapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adapter=new EbookAdapter(EbookActivity.this,list);
                ebookRecycle.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycle.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(EbookActivity.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}