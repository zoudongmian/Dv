package android.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private Button mComein;
    private int i=0;
    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mComein = (Button) findViewById(R.id.yang_comein);
        mComein.setOnClickListener(this);
        mRg = (RadioGroup) findViewById(R.id.yang_conter);
        mRg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if(i==1){
            Intent intent=new Intent(this,DengluActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this,"接受协议后可使用",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.yang_yes:
                i=1;
                break;
            case R.id.yang_no:
                i=0;
                Toast.makeText(this,"是否不接受协议",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
