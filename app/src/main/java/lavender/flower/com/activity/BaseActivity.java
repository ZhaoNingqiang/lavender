package lavender.flower.com.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @Description:
 * @Author: ZhaoNingqiang
 * @Time 2016/07/13 上午11:58
 */

public class BaseActivity extends AppCompatActivity {
    protected<T extends View> T findView(@IdRes int id){
        return  (T)findViewById(id);
    }


}
