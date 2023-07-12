package com.hungttph26857.demolab2.demo2;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.hungttph26857.demolab2.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo23MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo23_main);
        button=findViewById(R.id.demo23Btn);
        textView=findViewById(R.id.demo23Tv);
        imageView=findViewById(R.id.demo23ImageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread myThread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //doc anh
                        Bitmap bitmap=loadAnh("https://scontent.fhan2-3.fna.fbcdn.net/v/t39.30808-6/275604961_1138554470053096_6902914953120644532_n.jpg?_nc_cat=111&cb=99be929b-3346023f&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=bMJswnxTvQ4AX-DVHAm&_nc_ht=scontent.fhan2-3.fna&oh=00_AfB_l-k0VAnk80Mggxp4LjMRYlcV65SixuNafZFYEzAdbg&oe=64B4523E");
                        //dua anh vao imageview
                        imageView.post(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(bitmap);
                                textView.setText("Thanh cong");
                            }
                        });
                    }
                });
                myThread.start();
            }
        });
    }
    //dinh nghia ham load anh
    private Bitmap loadAnh(String str){
        URL url;
        Bitmap bitmap = null;
        try {
            url=new URL(str);
            bitmap= BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}