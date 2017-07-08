package android.com.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.yang_splash_image);
        //补间动画加载
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splsah_anim);
        //设置动画时长
        animation.setDuration(3*1000);
        //添加动画监听
        animation.setAnimationListener(this);
        //开启动画
        mImage.startAnimation(animation);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        SharedPreferences guide = getSharedPreferences("guide", MODE_PRIVATE);
        boolean firstUse=guide.getBoolean("first_use",true);
        if(firstUse){
            //存储使用标记，跳转到导航页面
            SharedPreferences.Editor edit=guide.edit();
            edit.putBoolean("first_use",false);
            edit.apply();

            Intent intent=new Intent(this,GuideActivity.class);
            startActivity(intent);
            //完成后，杀死界面
            finish();
        }else {
            Intent intent=new Intent(this,DengluActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
