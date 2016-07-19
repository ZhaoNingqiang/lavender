package lavender.flower.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lavender.flower.com.lavender.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_retrofit)
    public void retrofit(View view){
        startActivity(RetrofitActivity.class);
    }

    @OnClick(R.id.bt_popupWindow)
    public void popupWindow(View view){
        startActivity(PopupWindowAcitivity.class);
    }



    protected void startActivity(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }


}
