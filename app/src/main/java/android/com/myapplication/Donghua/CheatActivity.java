package android.com.myapplication.Donghua;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.com.myapplication.R;
import android.com.myapplication.fragment.WeChatFragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE =
            "android.com.myapplication.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN="android.com.myapplication.answer_shown";
    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private TextView sdk;

    public  static Intent newIntent(FragmentActivity packageContext, boolean answerIsTrue){
        Intent intent;
        intent = new Intent(packageContext,WeChatFragment.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return intent;
    }

    public  static  boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        sdk = (TextView)findViewById(R.id.sdk_number);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        sdk.setText("API level 23");
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
                int cx =mShowAnswer.getWidth()/2;
                int cy = mShowAnswer.getHeight()/2;
                float radius = mShowAnswer.getWidth();
                Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswer,cx,cy,radius,0);
                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void  onAnimationEnd(Animator animator){
                        super.onAnimationEnd(animator);
                        mShowAnswer.setVisibility(View.INVISIBLE);
                    }
                });
                anim.start();
            }
        });
    }
    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }
}
