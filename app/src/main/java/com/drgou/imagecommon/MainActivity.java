package com.drgou.imagecommon;

import android.Manifest;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.drgou.imagecommonlibrary.ImgCommon;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    final RxPermissions rxPermissions = new RxPermissions(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.test_iv);

        ImgCommon.setImg(imageView, "http://pic26.nipic.com/20121229/9252150_101107077359_2.jpg");

//        rxPermissions
//                .request(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .subscribe(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean granted) throws Exception {
//                        if (granted) { // Always true pre-M
//                            ImgCommon.setImg(imageView, "http://pic26.nipic.com/20121229/9252150_101107077359_2.jpg");
//                        } else {
//                            // Oups permission denied
//                            Toast.makeText(MainActivity.this,"没有权限!",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

    }
}
