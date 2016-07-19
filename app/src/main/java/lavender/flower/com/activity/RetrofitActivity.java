package lavender.flower.com.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import lavender.flower.com.been.ShareContent;
import lavender.flower.com.lavender.R;
import lavender.flower.com.retrofit.BaiduService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description:
 * @Author: ZhaoNingqiang
 * @Time 2016/07/19 上午11:48
 */

public class RetrofitActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    TextView content;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        content = findView(R.id.content);
        click = findView(R.id.click);
        click.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("aaaa", "bbbb").build();
                return chain.proceed(request);
            }
        };

        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.ujipin.cn/v4/")
                .client(client)
                .build();
        BaiduService baiduService = retrofit.create(BaiduService.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("content_id", "da76e40e370c4dc8a86089f0f3cbd618");
        map.put("type_id", "2");
        Call<ShareContent> shareContent = baiduService.getShareContent(
                map);

        shareContent.enqueue(new Callback<ShareContent>() {

            @Override
            public void onResponse(Call<ShareContent> call, retrofit2.Response<ShareContent> response) {
                ShareContent body = response.body();
                Log.d(TAG, "ShareContent = " + body.toString());
                content.setText(body.toString());
            }

            @Override
            public void onFailure(Call<ShareContent> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
