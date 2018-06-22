package com.example.pkiop.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    MainActivity activity;

    //onAttach로 activity 위에 올라와야 프래그먼트로서 동작할 수 있다.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) rootView.findViewById(R.id.button); // 프래그먼트 안에 있는 버튼찾기
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //여기 동작을 보내야 하는데 이건 시스템이 아니기 때문에 intent에 넣어서 보낼 순 없다. mainactivity에 method를 만들어야 한다.
                activity.onFragmentChange(1);
            }
        });

        return rootView;
    }
    //해줬으면 메인화면에 추가해주어야한다. xml에서
}
