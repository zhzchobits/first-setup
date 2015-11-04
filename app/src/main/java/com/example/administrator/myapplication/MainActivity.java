package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.FileOutputStream;


public class MainActivity extends Activity implements View.OnClickListener {
    private ImageView imageView,imageView2,imageView3,imageView4,imageView5;
    private RelativeLayout relativeLayout;
    private Bitmap bitmap;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findView();
    }
    private void findView(){
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);
        imageView=(ImageView)findViewById(R.id.imageView1);
        imageView2=(ImageView)findViewById(R.id.imageView2);
        imageView3=(ImageView)findViewById(R.id.imageView3);
        imageView4=(ImageView)findViewById(R.id.imageView4);
        imageView5=(ImageView)findViewById(R.id.imageView5);
        textView=(TextView)findViewById(R.id.textView7);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
    }
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.imageView1:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.s18));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.s9));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.s8));
                imageView4.setImageDrawable(getResources().getDrawable(R.drawable.s16));
                break;
            case R.id.imageView2:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.s10));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.s17));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.s8));
                imageView4.setImageDrawable(getResources().getDrawable(R.drawable.s16));
                break;
            case R.id.imageView3:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.s10));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.s9));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.s15));
                imageView4.setImageDrawable(getResources().getDrawable(R.drawable.s16));
                break;
            case R.id.imageView4:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.s10));
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.s9));
                imageView3.setImageDrawable(getResources().getDrawable(R.drawable.s8));
                imageView4.setImageDrawable(getResources().getDrawable(R.drawable.s7));
                break;
            case R.id.relativeLayout:
                Intent intent=new Intent(MainActivity.this,GrActivity.class);
                startActivityForResult(intent,0x11);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==0x11&&resultCode==0x11){
            Bundle bundle=data.getExtras();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (bundle.getString("tx")!=null){
            bitmap = BitmapFactory.decodeFile(bundle.getString("tx"), options);
            options.inSampleSize=8;
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(bundle.getString("tx"), options);
            imageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView5.setImageBitmap(bitmap);}
            else {
                imageView5.setImageDrawable(getResources().getDrawable(R.drawable.s12));
            }
            if (bundle.getString("mc")!=null){
                textView.setText(bundle.getString("mc"));
            }
        }
    }
}
