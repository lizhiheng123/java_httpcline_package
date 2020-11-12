package auto;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
  接口调用工具类
*/

public class HttpUtil {
    /*
    已post方式处理接口调用
    */
    public  static  String doPost(String Url, Map<String,String> params){
        HttpPost post = new HttpPost(Url);
        //把测试数据放到list集合里面
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        //取出所有map中的参数名
        Set<String> keys = params.keySet();
        //通过循环将参数保存到list
        for(String name :keys){
            String value =  params.get(name);
            parameters.add(new BasicNameValuePair(name,value));
        }
        String reasult ="";
        try {
            post.setEntity(new UrlEncodedFormEntity(parameters,"utf-8"));
            //发起请求, //创建客户端
            HttpClient client = HttpClients.createDefault();
            HttpResponse httpResponse = client.execute(post);
            //status=200 是否成功
            int code =  httpResponse.getStatusLine().getStatusCode();
            System.out.println(code);
            //得到字符创
            reasult = EntityUtils.toString(httpResponse.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reasult;
    }


    /*
         已post方式处理接口调用
    */
    public static String doGet(String url, Map<String,String>params){

        Set<String> keys =params.keySet();
        int mark = 1;
        for(String name : keys){
            if(mark ==1){
                url+=("?"+name+"="+params.get(name));
            }else{
                url+=("&"+name+"="+params.get(name));
            }
            mark++;

        }
        System.out.println(url);
        //指定接口提交方式
        HttpGet get = new HttpGet(url);
        //发起请求得到相应数据创建矿护短
        HttpClient httpClient = HttpClients.createDefault();
        //执行客户端并返回给httprespone类型的数据
        HttpResponse httpResponse = null;
        String result = "";
        try {
            httpResponse = httpClient.execute(get);
            //返回状态码
            int code = httpResponse.getStatusLine().getStatusCode();
            System.out.println(code);
            result = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  result;

    }

}
