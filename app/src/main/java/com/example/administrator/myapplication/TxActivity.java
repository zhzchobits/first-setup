package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/10/30.
 */
public class TxActivity extends Activity {
    private ImageView imageView;
    private Bitmap bitmap;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tx);
        imageView=(ImageView)findViewById(R.id.imageView14);
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(bundle.getString("tx"), options);
        options.inSampleSize=2;
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFile(bundle.getString("tx"), options);
        if(bundle.getString("tx")!=null){
        imageView.setImageBitmap(bitmap);}
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
