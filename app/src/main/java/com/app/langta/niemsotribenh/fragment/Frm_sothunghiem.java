package com.app.langta.niemsotribenh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.app.langta.niemsotribenh.R;
import com.app.langta.niemsotribenh.adapter.Adapter_sotribenh;
import com.app.langta.niemsotribenh.model.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frm_sothunghiem extends Fragment {
    ListView lv_sotribenh;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<Data> listSotribenh = new ArrayList<Data>();
    Adapter_sotribenh adapter_sotribenh;
    ProgressBar pro_bar;

    public static Frm_sothunghiem newInstance(int page, String title) {
        Frm_sothunghiem fragmentFirst = new Frm_sothunghiem();
        return fragmentFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.frm_sothunghiem, container, false);
        initUI(view);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("SoTriBenh");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if (child.child("DoLinhNghiem").getValue(Integer.class) != null) {
                        Data post = new Data(
                                Integer.parseInt(Objects.requireNonNull(child.getKey())),
                                child.child("DoLinhNghiem").getValue(Integer.class),
                                child.child("SoBenh").getValue(String.class),
                                child.child("TenBenh").getValue(String.class),
                                child.child("GhiChu").getValue(String.class));
                        listSotribenh.add(post);
                    } else {
                        Data post = new Data(
                                Integer.parseInt(Objects.requireNonNull(child.getKey())),
                                0,
                                child.child("SoBenh").getValue(String.class),
                                child.child("TenBenh").getValue(String.class),
                                child.child("GhiChu").getValue(String.class));
                        listSotribenh.add(post);
                    }
                }
                adapter_sotribenh = new Adapter_sotribenh(listSotribenh, getActivity());
                lv_sotribenh.setAdapter(adapter_sotribenh);
                pro_bar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view;
    }

    private void initUI(View view) {
        lv_sotribenh = view.findViewById(R.id.lv_sotribenh);
        pro_bar = view.findViewById(R.id.pro_bar);
    }

}