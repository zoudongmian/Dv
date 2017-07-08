package android.com.myapplication.fragment;

import android.com.myapplication.Donghua.Donghua;
import android.com.myapplication.Donghua.PintuActivity;
import android.com.myapplication.R;
import android.com.myapplication.Donghua.YaoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/3.
 */

public class DiscoverFragment extends Fragment implements View.OnClickListener {
    View layout;
    private TextView mGame;
    private TextView mDonghua;
    private ImageView mYao;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_discover,container,false);
        initView();
        return layout;

    }

    private void initView() {

        mGame = (TextView) layout.findViewById(R.id.xyy_game);
        mGame.setOnClickListener(this);
        mYao =(ImageView)layout.findViewById(R.id.yaoyiyao);
        mYao.setOnClickListener(this);

        mDonghua = (TextView)layout.findViewById(R.id.donghua);
        mDonghua.setOnClickListener(this);

//
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.xyy_game:
                Intent intent = new Intent(getActivity(),PintuActivity.class);
                startActivity(intent);
                break;
            case R.id.yaoyiyao:
                Intent intent2 = new Intent(getActivity(),YaoActivity.class);
                startActivity(intent2);
                break;
            case R.id.donghua:
                Intent intent3 = new Intent(getActivity(),Donghua.class);
                startActivity(intent3);
                break;
        }
    }
}
