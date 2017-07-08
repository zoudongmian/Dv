package android.com.myapplication.Donghua;

import android.com.myapplication.R;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PintuActivity extends AppCompatActivity implements View.OnClickListener,Handler.Callback{
    ImageView mImage0x0;
    ImageView mImage1x0;
    ImageView mImage2x0;
    ImageView mImage0x1;
    ImageView mImage1x1;
    ImageView mImage2x1;
    ImageView mImage0x2;
    ImageView mImage1x2;
    ImageView mImage2x2;

    //    图片资源
    int[] pics = {R.mipmap.xyy_kenan_00x00, R.mipmap.xyy_kenan_01x00, R.mipmap.xyy_kenan_02x00,
            R.mipmap.xyy_kenan_00x01, R.mipmap.xyy_kenan_01x01, R.mipmap.xyy_kenan_02x01,
            R.mipmap.xyy_kenan_00x02, R.mipmap.xyy_kenan_01x02, R.mipmap.xyy_kenan_02x02};
    //      图片资源索引，下标
    int[] picIndex = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    //    原来隐藏额view
    ImageView blankview;
    int blankPosition;
    Button mStart;
    Handler mHandler = new Handler(this);
    int time;
    TextView mTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //    原来隐藏额view


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pintu2);
        mImage0x0 = (ImageView) findViewById(R.id.xyy_0x0);
        mImage1x0 = (ImageView) findViewById(R.id.xyy_1x0);
        mImage2x0 = (ImageView) findViewById(R.id.xyy_2x0);
        mImage0x1 = (ImageView) findViewById(R.id.xyy_0x1);
        mImage1x1 = (ImageView) findViewById(R.id.xyy_1x1);
        mImage2x1 = (ImageView) findViewById(R.id.xyy_2x1);
        mImage0x2 = (ImageView) findViewById(R.id.xyy_0x2);
        mImage1x2 = (ImageView) findViewById(R.id.xyy_1x2);
        mImage2x2 = (ImageView) findViewById(R.id.xyy_2x2);

        mImage0x0.setOnClickListener(this);
        mImage0x1.setOnClickListener(this);
        mImage0x2.setOnClickListener(this);
        mImage1x0.setOnClickListener(this);
        mImage1x1.setOnClickListener(this);
        mImage1x2.setOnClickListener(this);
        mImage2x0.setOnClickListener(this);
        mImage2x1.setOnClickListener(this);
        mImage2x2.setOnClickListener(this);

        mImage0x0.setClickable(false);
        mImage1x0.setClickable(false);
        mImage2x0.setClickable(false);
        mImage0x1.setClickable(false);
        mImage1x1.setClickable(false);
        mImage2x1.setClickable(false);
        mImage0x2.setClickable(false);
        mImage1x2.setClickable(false);
        mImage2x2.setClickable(false);

        mStart = (Button) findViewById(R.id.xyy_start);
        mStart.setOnClickListener(this);
        mTime = (TextView) findViewById(R.id.xyy_time);
    }

    public void randomInit() {
        for (int i = 0; i < 20; i++) {
            int rand1;
            int rand2;
//        [0-7]
            rand1 = (int) (Math.random() * 8);

            /**
             * 交换规则：x相等y差值为1；x差值为1,y相等
             */
            int y = rand1 / 3;
            int x = rand1 % 3;

            while (true) {
                rand2 = (int) (Math.random() * 8);
                int y2 = rand2 / 3;
                int x2 = rand2 % 3;
                int absX = Math.abs(x - x2);
                int absY = Math.abs(y - y2);
                if ((absX == 0 && absY == 1) || (absX == 1 && absY == 0)) {
                    break;
                }
            }
            exchange(rand1, rand2);
        }
    }

    public void exchange(int rand1, int rand2) {
//        int temp = picIndex[rand1];
//        picIndex[rand1]=picIndex[rand2];
//        picIndex[rand2]=temp;
//        2 3       01         10          ^       11

        picIndex[rand1] = picIndex[rand1] ^ picIndex[rand2];
//         2       10          01   ^            11
        picIndex[rand2] = picIndex[rand1] ^ picIndex[rand2];
//         3       11        01         ^       10
        picIndex[rand1] = picIndex[rand1] ^ picIndex[rand2];
    }

    private void gamestart() {
        mHandler.removeMessages(100);
        time = 0;
        mTime.setText("时间" + time);
        randomInit();
//        设置资源
        mImage0x0.setImageResource(pics[picIndex[0]]);
        mImage1x0.setImageResource(pics[picIndex[1]]);
        mImage2x0.setImageResource(pics[picIndex[2]]);
        mImage0x1.setImageResource(pics[picIndex[3]]);
        mImage1x1.setImageResource(pics[picIndex[4]]);
        mImage2x1.setImageResource(pics[picIndex[5]]);
        mImage0x2.setImageResource(pics[picIndex[6]]);
        mImage1x2.setImageResource(pics[picIndex[7]]);
        mImage2x2.setImageResource(pics[picIndex[8]]);

//        其他控件变为可见
        mImage0x0.setVisibility(View.VISIBLE);
        mImage1x0.setVisibility(View.VISIBLE);
        mImage2x0.setVisibility(View.VISIBLE);
        mImage0x1.setVisibility(View.VISIBLE);
        mImage1x1.setVisibility(View.VISIBLE);
        mImage2x1.setVisibility(View.VISIBLE);
        mImage0x2.setVisibility(View.VISIBLE);
        mImage1x2.setVisibility(View.VISIBLE);
//         隐藏最后一张图片
        mImage2x2.setVisibility(View.INVISIBLE);
        blankview = mImage2x2;
        blankPosition = 8;


        mImage0x0.setClickable(true);
        mImage1x0.setClickable(true);
        mImage2x0.setClickable(true);
        mImage0x1.setClickable(true);
        mImage1x1.setClickable(true);
        mImage2x1.setClickable(true);
        mImage0x2.setClickable(true);
        mImage1x2.setClickable(true);
        mImage2x2.setClickable(true);
        mHandler.sendEmptyMessageDelayed(100,1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xyy_0x0:
                move(mImage0x0, 0);
                break;
            case R.id.xyy_1x0:
                move(mImage1x0, 1);
                break;
            case R.id.xyy_2x0:
                move(mImage2x0, 2);
                break;
            case R.id.xyy_0x1:
                move(mImage0x1, 3);
                break;
            case R.id.xyy_1x1:
                move(mImage1x1, 4);
                break;
            case R.id.xyy_2x1:
                move(mImage2x1, 5);
                break;
            case R.id.xyy_0x2:
                move(mImage0x2, 6);
                break;
            case R.id.xyy_1x2:
                move(mImage1x2, 7);
                break;
            case R.id.xyy_2x2:
                move(mImage2x2, 8);
                break;
            case R.id.xyy_start:
                gamestart();
                break;
        }
    }

    public void move(ImageView v, int position) {
        int y = position / 3;
        int x = position % 3;
        int y2 = blankPosition / 3;
        int x2 = blankPosition % 3;
        int absY = Math.abs(y - y2);
        int absX = Math.abs(x - x2);
        if ((absX == 1 && absY == 0) || (absX == 0 && absY == 1)) {
            //        隐藏点击的view，显示原来隐藏的view
            v.setVisibility(View.INVISIBLE);
            blankview.setVisibility(View.VISIBLE);

//        设置新显示出来view的资源
            blankview.setImageResource(pics[picIndex[position]]);

//        交换数据位置
            exchange(position, blankPosition);
            blankPosition = position;
            blankview = v;
            gameOver();
        }
    }
    private void gameOver() {
        boolean isOver = true;
        for(int i = 0; i < 9; i++){
            if(picIndex[i] != i){
                isOver = false;
                break;
            }
        }
        if(isOver){
            mHandler.removeMessages(100);

//            Toast.makeText(this,"你真是一个小天才！",Toast.LENGTH_SHORT).show();
            AlertDialog alertDialog =  new AlertDialog.Builder(this).setMessage("你真是一个小天才，只用了" + time + "秒完成游戏").create();
            alertDialog.show();

            mImage0x0.setClickable(false);mImage1x0.setClickable(false);mImage2x0.setClickable(false);
            mImage0x1.setClickable(false);mImage1x1.setClickable(false);mImage2x1.setClickable(false);
            mImage0x2.setClickable(false);mImage1x2.setClickable(false);mImage2x2.setClickable(false);
            mImage2x2.setVisibility(View.VISIBLE);
            mImage2x2.setImageResource(pics[picIndex[8]]);
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case 100:
//                更新进度
                time++;
                mTime.setText("时间" + time);
//                继续发送更新进度的消息
                mHandler.sendEmptyMessageDelayed(100,1000);
                break;
        }
        return false;
    }
}
