package com.jsikmc15.fragmentbundleexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment2 extends Fragment {

    private TextView tv_tvfrag2;
    private Button btn_move2;
    private View view;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_2,container,false);
//        view = getLayoutInflater().inflate(R.layout.fragment_2,container,false);
        tv_tvfrag2 = view.findViewById(R.id.tv_frag2);
        btn_move2 = view.findViewById(R.id.btn_move2);

        /*
        추가해봄!!

         */

        //데이터 받아옴

        if(getArguments() !=null){
            result = getArguments().getString("fromFrag1");
            tv_tvfrag2.setText(result);
        }



        btn_move2.setOnClickListener(new View.OnClickListener() { //프래그먼트 1로 이동함
            @Override
            public void onClick(View v) {
                /*
                Bundle이란
                무언가를 담을 준비를 하는 보따리 같은 개념

                 */

                Bundle bundle = new Bundle();
                bundle.putString("fromFrag2","프2에서 넘어가쪙");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(bundle);

                // 뼈대가 되는 화면 영역 , 교체할 부분
                transaction.replace(R.id.frameLayout,fragment1);
                transaction.commit();



            }
        });

        return view;
    }
}
