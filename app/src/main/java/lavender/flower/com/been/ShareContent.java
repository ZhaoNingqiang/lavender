package lavender.flower.com.been;

/**
 * Created by ningqiangzhao on 16/7/8.
 */

public class ShareContent{
    public int status_code;
    public String message;
    public int time;
    public Data data;

    public static class Data {
        public String content;
        public String image;
        public String share_url;
        public String title;

        @Override
        public String toString() {
            return "Data{" +
                    "content='" + content + '\'' +
                    ", image='" + image + '\'' +
                    ", share_url='" + share_url + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ShareContent{" +
                "status_code=" + status_code +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", data=" + data +
                '}';
    }
}
