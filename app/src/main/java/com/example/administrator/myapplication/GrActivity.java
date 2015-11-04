package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/30.
 */
public class GrActivity extends Activity {
    private TextView textView,textView5,textView15,textView17;
    private ImageView imageView;
    private RelativeLayout relativeLayout,relativeLayout2,relativeLayout3,relativeLayout4;
    final private int PICTURE_CHOOSE = 1;
    private static Bitmap img;
    private static String mc;
    private static String qm;
    private static String xb;
    static int T =0;
    private  static String fileSrc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gr);
        textView=(TextView)findViewById(R.id.textView1);
        textView5=(TextView)findViewById(R.id.textView5);
        textView15=(TextView)findViewById(R.id.textView15);
        textView17=(TextView)findViewById(R.id.textView17);
        imageView=(ImageView)findViewById(R.id.imageView);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);
        relativeLayout2=(RelativeLayout)findViewById(R.id.relativeLayout2);
        relativeLayout3=(RelativeLayout)findViewById(R.id.relativeLayout3);
        relativeLayout4=(RelativeLayout)findViewById(R.id.relativeLayout4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                Bundle bundle=new Bundle();
                bundle.putString("tx",fileSrc);
                bundle.putString("mc",mc);
                intent.putExtras(bundle);
                setResult(0x11,intent);
                finish();
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, PICTURE_CHOOSE);
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GrActivity.this,McActivity.class);
                startActivityForResult(intent, 0x12);
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GrActivity.this, QmActivity.class);
                startActivityForResult(intent, 0x13);
            }
        });
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items =new String[]{"男","女"};

                AlertDialog.Builder builder= new AlertDialog.Builder(GrActivity.this);
                builder.setTitle("性别");
                builder.setSingleChoiceItems(items, T, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int i = which;
                        if (i == 0) {
                            textView17.setText("男");
                            xb=textView17.getText().toString();
                            T = which;
                        } else {
                            textView17.setText("女");
                            T = which;
                            xb=textView17.getText().toString();
                        }
                    }
                });
                builder.create().show();

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GrActivity.this,TxActivity.class);
                Bundle bundle =new Bundle();
                bundle.putString("tx",fileSrc);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        if (fileSrc!=null){
        imageView.setImageBitmap(img);}
        if (mc!=null){
        textView5.setText(mc);}
        textView15.setText(qm);
        textView17.setText(xb);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICTURE_CHOOSE) {
            if (data != null) {
                Cursor cursor = getContentResolver().query(data.getData(),
                        null, null, null, null);
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                fileSrc = cursor.getString(idx);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                img = BitmapFactory.decodeFile(fileSrc, options);
                //options.inSampleSize = Math.max(1, (int) Math.ceil(Math.max(
                        //(double) options.outWidth / 1024f,
                        //(double) options.outHeight / 1024f)));
                options.inSampleSize=8;
                options.inJustDecodeBounds = false;
                img = BitmapFactory.decodeFile(fileSrc, options);
                imageView.setImageBitmap(img);
            }
        }
        if (requestCode==0x12&&resultCode==0x12){
             mc=data.getStringExtra("mc");
            if (mc!=null){
            textView5.setText(mc);}
        }
        if (requestCode==0x13&&resultCode==0x13){
            qm=data.getStringExtra("qm");
            if (qm!=null){
                textView15.setText(qm);}
        }

    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=getIntent();
            Bundle bundle=new Bundle();
            bundle.putString("tx",fileSrc);
            bundle.putString("mc",mc);
            intent.putExtras(bundle);
            setResult(0x11,intent);
        }
        return super.onKeyDown(keyCode,event);
    }
}
