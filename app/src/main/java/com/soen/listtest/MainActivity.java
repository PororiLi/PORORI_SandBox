package com.soen.listtest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    private LinearLayout container;
    String item_ssid;
    Drawable ap_state;
    ArrayList<ListItem> mlist = new ArrayList<ListItem>();
    RecyclerView recyclerView = null;
    ListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //리사이클러뷰에 표시할 데이터 리스트 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        for (int i = 0; i < 10; i++) {
//            list.add(String.format("SSID %d", i));
//        }
        //현재 내 와이파이 부분
        container = findViewById(R.id.container);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.wifilist_item, container, true);


        //리사이클러뷰 리니어 레이아웃 매니저 지정
        RecyclerView recyclerView = findViewById(R.id.wifiList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //리사이클러뷰에 리스트 어뎁더 객체 지정
        adapter = new ListAdapter(mlist, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //버튼 클릭될때 호출됨
                addItem("click test",getDrawable(R.drawable.wifi_full));
                Log.d("debug", "onItemClick: "+item_ssid);
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(adapter);

        //item 추가
        addItem("test",getDrawable(R.drawable.wifi_full));
        Log.d("'debug", "onCreate: additem test1");
        addItem("test2",getDrawable(R.drawable.wifi_full));
        Log.d("debug", "onCreate: additem test2");
        addItem("test3",getDrawable(R.drawable.wifi_full));
//        Log.d(TAG, "onCreate: additem test3");
        adapter.notifyDataSetChanged();
    }

    public void addItem(String item_ssid, Drawable ap_state){
        ListItem item = new ListItem();

        item.setItem_ssid(item_ssid);
        item.setAp_state(ap_state);

        mlist.add(item);
        Log.d("debug", "addItem: "+item_ssid);
    }

}
