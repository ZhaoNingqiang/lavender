package lavender.flower.com.retrofit;

import lavender.flower.com.been.ShareContent;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ningqiangzhao on 16/7/8.
 * https://api.ujipin.com/v4/app/share?content_id=da76e40e370c4dc8a86089f0f3cbd618&type_id=2
 */

public interface BaiduService {
    @GET("app/share?content_id={content_id}&type_id=2")
    Call<ShareContent> getShareContent(@Path("content_id") String content_id);
}
