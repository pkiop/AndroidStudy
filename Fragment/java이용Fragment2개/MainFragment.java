package com.example.pkiop.myfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    //메모리 객체화 하고 xml 과 연결시켜줘야함
    //오른쪽 클릭 Generate -> OnCreateView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }
    //해줬으면 메인화면에 추가해주어야한다. xml에서
}
