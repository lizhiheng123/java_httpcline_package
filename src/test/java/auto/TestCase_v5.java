package auto;
/*完成登录接口的测试*/

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class TestCase_v5 {
    @Test(dataProvider = "datas")
    public static void test1(String parameter) {
        String Url = "http://47.101.132.45:8081/api/user/pop/username/login";
        Map<String, String> params =(Map<String, String>) JSONObject.parse(parameter);
        System.out.println(HttpUtil.doPost(Url, params));
    }

    @DataProvider
    public Object[][] datas() {
        int [] rows = {2,3,4,5,6,7};
        int [] cells = {6};
        Object[][] datas = ExcelUtil.datas("src/test/resources/TestCase_v2.xlsx",rows,cells);
        return datas;
    }

}
