package com.example.dialog12.dialog12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String array[] ={"aa","bb","cc","dd"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewDialog(View v){
        switch (v.getId()){
            case R.id.bt1:
                Log.d("옴?","응 옴");
                Dialog d1 = new Dialog(this);
                TextView t = new TextView(this);
                t.setText("대화상자내용");
                d1.setContentView(t);
                d1.setTitle("대화상자 제목");
                d1.show();
                break;

            case R.id.bt2:
                AlertDialog.Builder d2 = new AlertDialog.Builder(this);
                d2.setTitle("대화상자 제목");
                d2.setMessage("대화상자 내용");
                d2.setIcon(R.mipmap.images);
                d2.setCancelable(false);

                d2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("확인?","확인");
                        Log.d("확인?", String.valueOf(i));
                    }
                });
                d2.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("확인?","취소");
                        Log.d("확인?", String.valueOf(i));
                    }
                });
                d2.setNeutralButton("무시", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("확인?","무시");
                        Log.d("확인?", String.valueOf(i));
                    }
                });


                d2.show();
                break;

            case R.id.bt3:
                AlertDialog.Builder d3 = new AlertDialog.Builder(this);
                d3.setTitle("다음 목록에서 선택하세요.");
                d3.setItems(array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String msg = "selectindex:"+i+",selectString:"+array[i];
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                    }
                });

                d3.setNegativeButton("cancel",null);
                d3.show();
                break;

            case R.id.bt4:
                AlertDialog.Builder d4 = new AlertDialog.Builder(this);
                d4.setTitle("제목");
                d4.setCancelable(false);

                final LinearLayout layout = (LinearLayout)
                        View.inflate(this,R.layout.mydialog,null);
                d4.setView(layout);

                d4.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText text = layout.findViewById(R.id.text);
                        CheckBox check= layout.findViewById(R.id.check);
                        String s = "입력문자열: "+text.getText()+",체크박스선택:"+check.isChecked();
                        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();

                    }
                });
                d4.show();
                break;

        }
    }
}
