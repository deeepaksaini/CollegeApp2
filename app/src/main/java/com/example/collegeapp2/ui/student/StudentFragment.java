package com.example.collegeapp2.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

public class StudentFragment extends Fragment {

    private RecyclerView cseDepartment, informationDepartment, meDepartment, eceDepartment;
    private LinearLayout cseNoData, informationNoData, meNoData, eceNoData;
    private List<StudentData> list1, list2, list3, list4;

    private DatabaseReference reference, dbRef;
    private StudentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student, container, false);

        cseDepartment = view.findViewById(R.id.cseDepartment);
        informationDepartment = view.findViewById(R.id.informationDepartment);
        meDepartment = view.findViewById(R.id.meDepartment);
        eceDepartment = view.findViewById(R.id.eceDepartment);

        cseNoData = view.findViewById(R.id.cseNoData);
        informationNoData = view.findViewById(R.id.informationNoData);
        meNoData = view.findViewById(R.id.meNoData);
        eceNoData = view.findViewById(R.id.eceNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Students");

        cseDepartment();
        meDepartment();
        informationDepartment();
        eceDepartment();
        return view;
    }
    private void cseDepartment() {
        dbRef=reference.child("Computer Science & Engineering(CSE)");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDepartment.setVisibility(View.GONE);
                }else {

                    cseNoData.setVisibility(View.GONE);
                    cseDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        StudentData data = snapshot.getValue(StudentData.class);
                        list1.add(data);
                    }

                    cseDepartment.setHasFixedSize(true);
                    cseDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new StudentAdapter(list1,getContext());
                    cseDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void informationDepartment() {

        dbRef=reference.child("Information Technology(IT)");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    informationNoData.setVisibility(View.VISIBLE);
                    informationDepartment.setVisibility(View.GONE);
                } else {
                    informationNoData.setVisibility(View.GONE);
                    informationDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        StudentData data = snapshot.getValue(StudentData.class);
                        list2.add(data);
                    }
                    informationDepartment.setHasFixedSize(true);
                    informationDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new StudentAdapter(list2, getContext());
                    informationDepartment.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartment() {
        dbRef=reference.child("Mechanical Engineering(ME)");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }else {

                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        StudentData data=snapshot.getValue(StudentData.class);
                        list3.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new StudentAdapter(list3,getContext());
                    meDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eceDepartment() {
        dbRef = reference.child("Electronics & Communication Engineering(ECE)");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    eceNoData.setVisibility(View.VISIBLE);
                    eceDepartment.setVisibility(View.GONE);
                } else {

                    eceNoData.setVisibility(View.GONE);
                    eceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        StudentData data = snapshot.getValue(StudentData.class);
                        list4.add(data);
                    }
                    eceDepartment.setHasFixedSize(true);
                    eceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new StudentAdapter(list4, getContext());
                    eceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}