package android.com.myapplication.fragment;

import android.com.myapplication.R;
import android.com.myapplication.Donghua.seriousActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/3.
 */

public class MineFragment extends Fragment implements View.OnClickListener {
    View layout;
    private TextView mMessage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_mine,container,false);

        mMessage = (TextView)layout.findViewById(R.id.xyy_information);
        mMessage.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xyy_information:
                Intent intent = new Intent(getActivity(), seriousActivity.class);
                startActivity(intent);
                break;
        }
    }
}
