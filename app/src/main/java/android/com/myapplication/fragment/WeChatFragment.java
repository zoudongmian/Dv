package android.com.myapplication.fragment;

import android.app.Activity;
import android.com.myapplication.Donghua.CheatActivity;
import android.com.myapplication.News.Question;
import android.com.myapplication.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/3.
 */

public class WeChatFragment extends Fragment  {
    private Button mCheatButton;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Button mBackButton;
    private static final String TAG = "QuizActivity";
    private static final int REQUEST_CODE_CHEAT = 0;
    private boolean mIsCheater;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_ocean,true),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_americas,false),
            new Question(R.string.question_city,false),
    };
    private  int mCurrentIndex = 0;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode != REQUEST_CODE_CHEAT){
            if (data == null){
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (mIsCheater){
            messageResId = R.string.judgment_toast;
        }else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_tosat;
            }
        }
        Toast.makeText(getContext(),messageResId,Toast.LENGTH_SHORT).show();
    }


    View layout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_we_chat,container,false);
        mNextButton = (Button)layout.findViewById(R.id.next_button);
        mQuestionTextView = (TextView)layout.findViewById(R.id.question_text_view);
        mBackButton = (Button)layout.findViewById(R.id.prev_button);
        mTrueButton = (Button)layout.findViewById(R.id.true_button);
        mFalseButton = (Button) layout.findViewById(R.id.false_button);
        mCheatButton = (Button)layout.findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                Intent intent;
                intent = new Intent(getActivity(),CheatActivity.class);
                startActivity(intent);
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1)%mQuestionBank.length;
                updateQuestion();
            }
        });
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1)%mQuestionBank.length;
                mIsCheater= false;
                updateQuestion();
            }
        });
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1)%mQuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();


        return layout;
    }


}
