package com.example.pkiop.mylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new Singeritem("소녀시대","010-1000-1000",R.drawable.a));
        adapter.addItem(new Singeritem("r녀시대","010-2000-1000",R.drawable.b));
        adapter.addItem(new Singeritem("3녀시대","010-3000-1000",R.drawable.c));
        adapter.addItem(new Singeritem("2녀시대","010-4000-1000",R.drawable.d));
        adapter.addItem(new Singeritem("1녀시대","010-5000-1000",R.drawable.e));
        listView.setAdapter(adapter);

        //리스트뷰는 보여주는 역할만. 이벤트 처리는 아래처럼

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Singeritem item = (Singeritem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : " +item.getName(),Toast.LENGTH_LONG).show();
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new Singeritem(name,mobile,R.drawable.ic_launcher_background));
                adapter.notifyDataSetChanged();
            }
        });
    }


    //먼저 어뎁터 를 만들어야 한다. 따로 클래스로

    class SingerAdapter extends BaseAdapter {
        ArrayList<Singeritem> items = new ArrayList<Singeritem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Singeritem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        //실제로는 원하는 id를 만들어서 return
        @Override
        public long getItemId(int position) {
            return position;
        }

        //View는 레이아웃으로 구성. 새로 만들어야
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertview 값을 통해 화면에 보이는 값이 부족하면 new로 새로 만들고
            //아니라면 이미 new로 만들어 뒀던 값으로 재사용한다.
            SingeritemView view = null;
            if(convertView == null){
                view = new SingeritemView(getApplicationContext());
            }
            else{
                view = (SingeritemView) convertView;
            }
            Singeritem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());

            return view;
        }
    }

}
