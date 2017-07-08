package android.com.myapplication.Donghua;

import android.com.myapplication.R;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Donghua extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImage;
    private Button mStart,mStop,mScale;
    AnimationDrawable loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donghua);
        mImage = (ImageView) findViewById(R.id.yxj_image);
        mImage.setBackgroundResource(R.drawable.loading);
        loading=(AnimationDrawable)mImage.getBackground();

        mStart = (Button) findViewById(R.id.yxj_start);
        mStart.setOnClickListener(this);
        mStop = (Button) findViewById(R.id.yxj_stop);
        mStop.setOnClickListener(this);
        mScale = (Button) findViewById(R.id.yxj_scale);
        mScale.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yxj_start:
                loading.start();
                Animation translate= AnimationUtils.loadAnimation(this,R.anim.loading_translate);
                translate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                mImage.startAnimation(translate);
                break;
            case R.id.yxj_stop:
                loading.stop();
                break;
            case R.id.yxj_scale:
                Animation sacle=AnimationUtils.loadAnimation(this,R.anim.loading_scale);
                sacle.setDuration(3*1000);
                mImage.startAnimation(sacle);
                break;
        }
    }
}
