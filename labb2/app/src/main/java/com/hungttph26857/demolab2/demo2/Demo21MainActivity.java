package com.hungttph26857.demolab2.demo2;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hungttph26857.demolab2.R;


public class Demo21MainActivity extends AppCompatActivity
implements View.OnClickListener,Demo21Interface {
    Button button;
    TextView textView;
    ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo21_main);
        button=findViewById(R.id.demo21Btn);
        textView=findViewById(R.id.demo21Tv);
        imageView=findViewById(R.id.demo21ImageView);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //khi click button thi goi asynctask
        new Demo21AsyncTask(this,this)
                .execute("https://scontent.fhan2-3.fna.fbcdn.net/v/t39.30808-6/274095885_1125908821317661_3891499414252278166_n.jpg?_nc_cat=111&cb=99be929b-3346023f&ccb=1-7&_nc_sid=174925&_nc_ohc=KWRb8NGuaNsAX_PpwL9&_nc_ht=scontent.fhan2-3.fna&oh=00_AfD_-Eptx_xepc9n41xTm44C1CjlJmhRCIMrsN_RuwWQ_g&oe=64B46DFE");
    }

    @Override
    public void onLoadAnh(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onLoi() {
        textView.setText("loi doc du lieu");
    }
}