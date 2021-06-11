package com.example.moveimage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
//объявление глобальных переменных
    int x=200,y=300;
    ImageView  image;
    ViewGroup.MarginLayoutParams marginParams;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//создание объектов
        image = new ImageView(this);
        image.setImageResource(R.drawable.ic_android_black_24dp);//назначение картинки
        marginParams=new ViewGroup.MarginLayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout = (RelativeLayout) findViewById(R.id.relaLayout);//Ваш контейнер (можно layout любого другого типа)
//первое размещение картинки
        marginParams.setMargins(x, y, 0, 0);
        image.setLayoutParams(marginParams);
        layout.addView(image);
//ТАЙМЕР **************************************************************************************
        CountDownTimer cdt=new CountDownTimer(30000, 1) {// 1 милисекунда шаг по времени
                                                //30 сек работает таймер
            public void onTick(long millisUntilFinished) {
                y+=10;
                marginParams.setMargins(x, y, 0, 0);
                image.setLayoutParams(marginParams);
                layout.removeView(image);//удаление картинки со старыми параметрами
                layout.addView(image);//создание картинки с новыми параметрами
            }
            public void onFinish() { }
        };
        cdt.start();
//***************************************************************************************

/*        marginParams.setMargins(x, y+300, 0, 0);
        image.setLayoutParams(marginParams);
        layout.addView(image);
        layout.removeView(image);
        layout.addView(image);*/
    }

}