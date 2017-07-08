package android.com.myapplication.Donghua;

import android.animation.ObjectAnimator;
import android.com.myapplication.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class YaoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mStartAuto;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yao);
        mStartAuto = (Button) findViewById(R.id.yxj_start_auto);
        mStartAuto.setOnClickListener(this);
        mImage = (ImageView) findViewById(R.id.yxj_image);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yxj_start_auto:
                ObjectAnimator rotationX = ObjectAnimator.ofFloat(mImage, "translationX", 0, -300, 300, -300, 300, -300, 0);
                rotationX.setDuration(3 * 1000);
                rotationX.start();
                break;
        }
    }
}
