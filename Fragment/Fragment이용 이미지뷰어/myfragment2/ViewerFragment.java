package com.example.pkiop.myfragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class ViewerFragment extends Fragment {

    ImageView imageView1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);

        imageView1 = (ImageView) rootView.findViewById(R.id.imageView1);

        return rootView;
    }

    public void setImage(int index){
        if(index == 0){
            imageView1.setImageResource(R.drawable.a);
        }
        if(index == 1){
            imageView1.setImageResource(R.drawable.b);
        }
        if(index == 2){
            imageView1.setImageResource(R.drawable.c);
        }
    }
}
