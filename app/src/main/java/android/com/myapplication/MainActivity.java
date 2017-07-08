package android.com.myapplication;

import android.com.myapplication.News.TeachPagerAdapter;
import android.com.myapplication.fragment.DiscoverFragment;
import android.com.myapplication.fragment.Message_Fragment;
import android.com.myapplication.fragment.MineFragment;
import android.com.myapplication.fragment.WeChatFragment;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private ViewPager mViewpager;
    private TeachPagerAdapter adapter;
    private RadioGroup mController;
    long currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        initView();
    }
//初始化控件
    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.teach_content);
        adapter = new TeachPagerAdapter(getSupportFragmentManager(),getData());
        mViewpager.setAdapter(adapter);
        mController = (RadioGroup)findViewById(R.id.teach_controller);
        mViewpager.addOnPageChangeListener(this);
        mController.setOnCheckedChangeListener(this);
        RadioButton radioButton = (RadioButton)mController.getChildAt(0);
        radioButton.setChecked(true);
    }

    private List<Fragment> getData() {
        List<Fragment> data = new ArrayList<>();
        data.add(new Message_Fragment());
        data.add(new WeChatFragment());
        data.add(new DiscoverFragment());
        data.add(new MineFragment());
        return data;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton radioButton = (RadioButton)mController.getChildAt(position);
        radioButton.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Log.e("TAG","onKeyDown: "+ SystemClock.uptimeMillis());

            if (SystemClock.uptimeMillis() - currentTime >2000){

                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
                currentTime = SystemClock.uptimeMillis();
                return true;
            }
        }
        return super.onKeyDown(keyCode,event);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.teach_message:
                mViewpager.setCurrentItem(0);
                break;
            case R.id.teach_home:
                mViewpager.setCurrentItem(1);
                break;
            case R.id.teach_discover:
                mViewpager.setCurrentItem(2);
                break;

            case R.id.teach_mine:
                mViewpager.setCurrentItem(3);
                break;
        }
    }
}
