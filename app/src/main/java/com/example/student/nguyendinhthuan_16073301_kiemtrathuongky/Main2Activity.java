package com.example.student.nguyendinhthuan_16073301_kiemtrathuongky;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private EditText editText_HoTen, editText_SDT;
    private Button button_LaySanPham, button_Xong;
    private CheckBox checkbox_ComSuon, checkbox_ChaoGa, checkbox_HuTieu, checkbox_MiXao, checkbox_Pho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();
        XuLy();
    }

    public void AnhXa() {
        editText_HoTen = (EditText) findViewById(R.id.editText_HoTen);
        editText_SDT = (EditText) findViewById(R.id.editText_SDT);
        button_LaySanPham = (Button) findViewById(R.id.button_LaySanPham);
    }

    public void XuLy() {
        button_LaySanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(Main2Activity.this);
                dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);
                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                dialog.show();

                //Anh xa
                button_Xong = (Button) dialog.findViewById(R.id.button_Xong);
                checkbox_ComSuon = (CheckBox) dialog.findViewById(R.id.checkbox_ComSuon);
                checkbox_ChaoGa = (CheckBox) dialog.findViewById(R.id.checkbox_ChaoGa);
                checkbox_HuTieu = (CheckBox) dialog.findViewById(R.id.checkbox_HuTieu);
                checkbox_MiXao = (CheckBox) dialog.findViewById(R.id.checkbox_MiXao);
                checkbox_Pho = (CheckBox) dialog.findViewById(R.id.checkbox_Pho);

                button_Xong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String monan = "";
                        if (checkbox_ComSuon.isChecked()) {
                            monan += " - " + checkbox_ComSuon.getText().toString() + "\n";
                        }
                        if (checkbox_ChaoGa.isChecked()) {
                            monan += " - " + checkbox_ChaoGa.getText().toString() + "\n";
                        }
                        if (checkbox_HuTieu.isChecked()) {
                            monan += " - " +  checkbox_HuTieu.getText().toString() + "\n";
                        }
                        if (checkbox_MiXao.isChecked()) {
                            monan += " - " +  checkbox_MiXao.getText().toString() + "\n";
                        }
                        if (checkbox_Pho.isChecked()) {
                            monan += " - " +  checkbox_Pho.getText().toString() + "\n";
                        }
                        dialog.cancel();

                        String thongtin = "Khách hàng: " + editText_HoTen.getText().toString() + " Số ĐT: " + editText_SDT.getText().toString() + " đã đặt" + "\n" + monan;
                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        intent.putExtra("thongtin", thongtin);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
