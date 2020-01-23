import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class gethttpurl {
    public static void main(String[] args) {
        try {
            gethttpurl test = new gethttpurl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public gethttpurl() throws Exception {

        System.out.print("请输入坐标：");
        Scanner input=new Scanner(System.in);
        String city_input=input.nextLine();
        String road_input="";
        if(city_input!="")
        {
            System.out.print("请输入时间戳：");
            road_input=input.nextLine();
        }

        //编码--转换为URLencode
        String urllocation =java.net.URLEncoder.encode(city_input,"utf-8");
        String timestamp =java.net.URLEncoder.encode(road_input,"utf-8");

        URL url = new URL("http://api.map.baidu.com/timezone/v1?coord_type=wgs84ll&location="+urllocation+"&timestamp="+timestamp+"&ak=GLh3Onmap2k8ot4ZGCiFdIPk0GKp3cSD");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // 开始读取远程服务器的响应数据。
        BufferedInputStream bis = new BufferedInputStream(urlConnection.getInputStream());

        byte[] buffer = new byte[1024 * 10];
        int count = 0;
        while (true) {
            count = bis.read(buffer);
            if (count == -1) {
                break;
            }

            System.out.println(new String(buffer, 0, count, "UTF-8"));
        }

        bis.close();
    }
}
