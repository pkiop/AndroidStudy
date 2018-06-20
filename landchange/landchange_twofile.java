package com.example.pkiop.myorientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	EditText editText;
	String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toast.makeText(this, "Oncreate() 호출됨", Toast.LENGTH_LONG).show();

		editText = (EditText) findViewById(R.id.editText);
		Button button = (Button) findViewById(R.id.button);
		if (button != null) {
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					name = editText.getText().toString();
					Toast.makeText(getApplicationContext(), "입력한 값을 name 변수에 할당함", Toast.LENGTH_LONG).show();
//이 함수는 this로 참조할 수 없으므로 이것
				}
			});
			if (savedInstanceState != null) {
				String name = savedInstanceState.getString("name");
				if (editText != null) {
					editText.setText("복원된 이름 : " + name);
					Toast.makeText(getApplicationContext(), "이름이 복원됨", Toast.LENGTH_LONG).show();
				}
			}
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putString("name",name);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "OnResume() 호출됨",Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "OnDestroy() 호출됨",Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "OnStart() 호출됨",Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "OnStop() 호출됨",Toast.LENGTH_LONG).show();
	}
}