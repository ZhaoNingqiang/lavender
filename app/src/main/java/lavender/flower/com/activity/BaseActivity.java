package lavender.flower.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @Description:
 * @Author: ZhaoNingqiang
 * @Time 2016/07/13 上午11:58
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected<T extends View> T findView(@IdRes int id){
        return  (T)findViewById(id);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    protected void startActivity(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
