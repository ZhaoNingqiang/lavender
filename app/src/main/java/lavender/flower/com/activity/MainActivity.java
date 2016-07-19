package lavender.flower.com.activity;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;
import lavender.flower.com.lavender.R;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.bt_retrofit)
    public void retrofit(View view){
        startActivity(RetrofitActivity.class);
    }

    @OnClick(R.id.bt_popupWindow)
    public void popupWindow(View view){
        startActivity(PopupWindowAcitivity.class);
    }






}
