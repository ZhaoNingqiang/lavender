package lavender.flower.com.lavender;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lavender.flower.com.been.ShareContent;
import lavender.flower.com.retrofit.BaiduService;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView content = findView(R.id.content);
        Button click = findView(R.id.click);

        click.setOnClickListener(this);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.ujipin.com/v4/")
                .build();
        BaiduService baiduService = retrofit.create(BaiduService.class);


        Call<ShareContent> shareContent = baiduService.getShareContent("da76e40e370c4dc8a86089f0f3cbd618");
    }


    protected<T extends View> T findView(@IdRes int id){
        return  (T)findViewById(id);
    }
}
