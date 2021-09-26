package com.jsikmc15.fragmentbundleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//여긴 activity 이므로 getActivity 할필요가없음
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        // 뼈대가 되는 화면 영역 , 교체할 부분
        transaction.replace(R.id.frameLayout,fragment1);
        transaction.commit();


    }


}