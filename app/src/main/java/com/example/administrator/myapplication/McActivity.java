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
public class McActivity extends Activity {
    private EditText editText;
    private TextView textView;
    private Button button;
    static String mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc);
        editText=(EditText)findViewById(R.id.editText);
        editText.setText(mc);
        textView=(TextView)findViewById(R.id.textView3);
        button=(Button)findViewById(R.id.button);
        final Intent intent =getIntent();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc =((EditText)findViewById(R.id.editText)).getText().toString();
                 intent.putExtra("mc", mc);
                setResult(0x12,intent);
                finish();

            }
        });

    }
}
