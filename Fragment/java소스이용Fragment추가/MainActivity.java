package com.example.pkiop.myfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 클릭했을 때 프래그먼트 추가한다.
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment fragment1 = new MainFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();
                //프래그먼트 실행하는 것은 여기서 프래그먼트 메니저가 담당한다.
                //transaction 안에서 진행하는 것은 꼭 commit을 해주어야 실행된다.
            }
        });
    }
}
