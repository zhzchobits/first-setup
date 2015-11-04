package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/10/30.
 */
public class QmActivity extends Activity {
    private EditText editText;
    private TextView textView;
    private Button button;
    static String qm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qm);
        editText=(EditText)findViewById(R.id.editText2);
        editText.setText(qm);
        textView=(TextView)findViewById(R.id.textView16);
        button=(Button)findViewById(R.id.button1);
        final Intent intent1 =getIntent();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qm = ((EditText) findViewById(R.id.editText2)).getText().toString();
                intent1.putExtra("qm", qm);
                setResult(0x13, intent1);
                finish();

            }
        });
    }
}
