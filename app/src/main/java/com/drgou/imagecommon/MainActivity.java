package com.drgou.imagecommon;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.drgou.imagecommonlibrary.ImgCommon;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.test_iv);

        ImgCommon.setImg(imageView, "http://images.baixingliangfan.cn/homeFloor/20180407/20180407181423_15.jpg");

    }
}
