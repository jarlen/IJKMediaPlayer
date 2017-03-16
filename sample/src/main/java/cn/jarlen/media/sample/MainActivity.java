package cn.jarlen.media.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import cn.jarlen.richcommon.utils.ToastUtil;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText inputPathEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputPathEt = (EditText) findViewById(R.id.et_input_path);
        findViewById(R.id.testBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.testBtn:

                String path = inputPathEt.getText().toString();

                if(TextUtils.isEmpty(path)){
                    ToastUtil.makeToast(this).setText("输入为空").show();
                    return;
                }

                VideoActivity.intentTo(this,path,"测试");

                break;
            default:

                break;
        }
    }





}
