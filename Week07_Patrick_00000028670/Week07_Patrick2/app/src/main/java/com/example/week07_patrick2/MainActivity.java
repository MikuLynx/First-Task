package com.example.week07_patrick2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvDaftarVideo;
    DaftarVideoAdapter mAdapter;
    LinkedList<SumberVideo> daftarVideo = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isiDaftarVideo();
        rvDaftarVideo = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarVideoAdapter(this, daftarVideo);
        rvDaftarVideo.setAdapter(mAdapter);
        rvDaftarVideo.setLayoutManager(new LinearLayoutManager(this));
    }
    public void isiDaftarVideo(){
        daftarVideo.add(new SumberVideo("Honkai Coffin Meme",
                "Don't mess with her",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.hi3));
        daftarVideo.add(new SumberVideo("Axel F - Crazy Frog",
                "Nostalgic Time",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.crazyfrog));
    }
}