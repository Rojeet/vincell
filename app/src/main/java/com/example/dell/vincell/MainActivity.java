package com.example.dell.vincell;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etusername, etpassword;
    private Button btn_login;
    private CheckBox chk;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        chk = findViewById(R.id.checkbox);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    etpassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    etpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loging In");
//        progressDialog.setTitle("Vincell");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        btn_login = findViewById(R.id.login_btn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {
        String user = etusername.getText().toString().trim();
        String pass = etpassword.getText().toString().trim();
        if (user.equals("ram") && pass.equals("1234")) {
            progressDialog.show();
            progressDialog.setCancelable(false);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    progressDialog.dismiss();
                }
            }).start();
            Toast.makeText(this, "VALID", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "INVALID", Toast.LENGTH_SHORT).show();
        }
    }
}



