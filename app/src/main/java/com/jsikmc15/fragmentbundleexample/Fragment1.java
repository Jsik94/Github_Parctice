package com.jsikmc15.fragmentbundleexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment {

    private TextView tv_tvfrag1;
    private Button btn_move;
    private View view;
    private String result;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_1,container,false);

        tv_tvfrag1 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);

        if(getArguments() !=null){
            result = getArguments().getString("fromFrag2");
            tv_tvfrag1.setText(result);
        }



        btn_move.setOnClickListener(new View.OnClickListener() { //프래그먼트 2로 이동함
            @Override
            public void onClick(View v) {
                /*
                Bundle이란
                무언가를 담을 준비를 하는 보따리 같은 개념

                 */



                Bundle bundle = new Bundle();
                bundle.putString("fromFrag1","프1에서 넘어가쪙");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);

                // 뼈대가 되는 화면 영역 , 교체할 부분
                transaction.replace(R.id.frameLayout,fragment2);
                transaction.commit();

            }
        });

        return view;
    }
}
