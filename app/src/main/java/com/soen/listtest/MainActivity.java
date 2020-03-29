package com.soen.listtest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //리사이클러뷰에 표시할 데이터 리스트 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format("SSID %d", i));
        }
        //현재 내 와이파이 부분
        container = findViewById(R.id.container);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.wifilist_item, container, true);


//리사이클러뷰 리니어 레이아웃 매니저 지정
        RecyclerView recyclerView = findViewById(R.id.wifiList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //리사이클러뷰에 리스트 어뎁더 객체 지정
        ListAdapter adapter = new ListAdapter(list);
        recyclerView.setAdapter(adapter);

    }

}
