package android.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DengluActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mLogin;
    private  TextInputEditText mUserName;
    private TextInputEditText mPassword;
    private TextInputLayout mUserNameLayout;
    private TextInputLayout mPassWordLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        initView();
    }

    private void initView() {
        mLogin = (Button)findViewById(R.id.teach_login);
        mLogin.setOnClickListener(this);
        mUserName = (TextInputEditText)findViewById(R.id.teach_input_username);
        mPassword = (TextInputEditText)findViewById(R.id.teach_input_password);
        mUserNameLayout = (TextInputLayout)findViewById(R.id.teach_input_username_Layout);
        mPassWordLayout = (TextInputLayout)findViewById(R.id.teach_input_password_Layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.teach_login:
                String username = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                if(TextUtils.isEmpty(username)){
                    mUserNameLayout.setErrorEnabled(true);
                    mUserNameLayout.setError("请输入用户名");
                }else {
                    mUserNameLayout.setError("");
                    mUserNameLayout.setErrorEnabled(false);
                }
                if (TextUtils.isEmpty(password)){
                    mPassWordLayout.setErrorEnabled(true);
                    mPassWordLayout.setError("请输入密码");

                }else {
                    mPassWordLayout.setError("");
                    mPassWordLayout.setErrorEnabled(false);

                }
                if(username.equals("zhuyukui")&&password.equals("0607")){
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                }
                else {

                }
                break;
        }
    }
}
