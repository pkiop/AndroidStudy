package com.example.pkiop.myfragment2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListFragment fragment1;
    ViewerFragment fragment2;

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        fragment1 = (ListFragment) manager.findFragmentById(R.id.listFragment);
        fragment2 = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }

    //ViewerFragment 에서 처리하도록 하겠다. 메인에서 하게 해도 되고
    public void onImageChange(int index){
        fragment2.setImage(index);
    }


}
