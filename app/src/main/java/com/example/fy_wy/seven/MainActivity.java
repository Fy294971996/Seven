package com.example.fy_wy.seven;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userId,pwd;
    String un,ps;
    LinearLayout Lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个普通的对话框");
                builder.setTitle("对话框");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(MainActivity.this,"用户按下了确定按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(MainActivity.this,"用户按下了忽略按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        //登录
        Button buttonone = (Button)findViewById(R.id.buttonone);
        buttonone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                Lin = (LinearLayout)getLayoutInflater().inflate(R.layout.login_dialog,null);
                builder.setView(Lin);
                builder.setTitle("Login");


                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"取消？",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userId = (EditText)Lin.findViewById(R.id.editTextUserId);
                        un = userId.getText().toString();
                        pwd = (EditText)Lin.findViewById((R.id.editTextPwd));
                        ps = pwd.getText().toString();
                        if(!un.equals("abc")){
                            Toast.makeText(MainActivity.this,"用户名不正确",Toast.LENGTH_SHORT).show();
                        }
                        if(!ps.equals("123")){
                            Toast.makeText(MainActivity.this,"密码不正确",Toast.LENGTH_SHORT).show();
                        }
                        if(un.equals("abc")&&ps.equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.create();
                builder.show();
            }
        });


    }
}