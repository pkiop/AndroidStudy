package com.example.pkiop.mytoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(),"위치가 바뀐 토스트", Toast.LENGTH_LONG);
// //show는 아직 하지 않고 기다린다.
				toast.setGravity(Gravity.TOP|Gravity.LEFT,200,200);
// offset 값이 왼쪽, 거기서 얼마나 떨어졌나
				toast.show();
			}

		});

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.toastborder, (ViewGroup) findViewById(R.id.toast_layout_root));
//메모리 객체화 완료
				TextView text = (TextView) layout.findViewById(R.id.text);
//이 텍스트뷰를 토스트 메세지로 띄울 것
				text.setText("모양을 바꾼 토스트입니다.");

				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER, 0,-100);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);

				toast.show();
			}
		});
	}
}