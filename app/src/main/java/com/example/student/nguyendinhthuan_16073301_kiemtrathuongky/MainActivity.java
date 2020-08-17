package com.example.student.nguyendinhthuan_16073301_kiemtrathuongky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button_DatHang;
    private TextView textView_KetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        XuLy();
        Show();
    }

    public void AnhXa() {
        button_DatHang = (Button) findViewById(R.id.button_DatHang);
        textView_KetQua = (TextView) findViewById(R.id.textView_KetQua);
    }

    public void XuLy() {
        button_DatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void Show() {
        Intent intent = getIntent();
        String thongtinshow = intent.getStringExtra("thongtin");
        textView_KetQua.setText(thongtinshow);
    }
}
