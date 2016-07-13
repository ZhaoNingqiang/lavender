package lavender.flower.com.lavender;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lavender.flower.com.been.ShareContent;
import lavender.flower.com.retrofit.BaiduService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    TextView content;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = findView(R.id.content);
        click = findView(R.id.click);

        click.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.ujipin.com/v4/")
                .build();
        BaiduService baiduService = retrofit.create(BaiduService.class);


        Call<ShareContent> shareContent = baiduService.getShareContent("da76e40e370c4dc8a86089f0f3cbd618");

        shareContent.enqueue(new Callback<ShareContent>() {
            @Override
            public void onResponse(Call<ShareContent> call, Response<ShareContent> response) {
                ShareContent body = response.body();
                Log.d(TAG, "ShareContent = " + body.toString());
                content.setText(body.toString());
            }

            @Override
            public void onFailure(Call<ShareContent> call, Throwable t) {
                t.printStackTrace();
            }
        });

//        try {
//            Response<ShareContent> execute = shareContent.execute();
//            ShareContent body = execute.body();
//            Log.d( TAG,"ShareContent = "+body.toString());
//            content.setText(body.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
