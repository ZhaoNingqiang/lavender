package lavender.flower.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import butterknife.BindView;
import lavender.flower.com.lavender.R;

/**
 * @Description:
 * @Author: ZhaoNingqiang
 * @Time 2016/07/19 下午1:23
 */

public class PopupWindowAcitivity extends BaseActivity {
    @BindView(R.id.bt_click_me)
    Button bt_click_me;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                PopupWindow popWindow  = new PopupWindow(PopupWindowAcitivity.this);
                ImageView iv = new ImageView(PopupWindowAcitivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(450,450);
                iv.setLayoutParams(lp);
                iv.setImageResource(R.mipmap.ic_launcher);
                popWindow.setContentView(iv);
                popWindow.setHeight(100);
                popWindow.setWidth(200);
                popWindow.showAtLocation(bt_click_me, Gravity.CENTER,0,0);
            }
        };
        bt_click_me.post(runnable);
        

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_popup_window;
    }

}
