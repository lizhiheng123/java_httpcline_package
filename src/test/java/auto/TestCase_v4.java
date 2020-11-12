package auto;
/*完成登录接口的测试*/

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

//post方法传递
public class TestCase_v4 {
    @Test(dataProvider = "datas")
    public static void test1(String username, String password) {
        System.out.println("username" + username + ",password" + password);
        String Url = "http://47.101.132.45:8081/api/user/pop/username/login";
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        System.out.println(HttpUtil.doPost(Url, params));
    }

    @DataProvider
    public Object[][] datas() {
        int [] rows = {2,3,4,5,6,7};
        int [] cells = {6,7};

        Object[][] datas = ExcelUtil.datas("src/test/resources/TestCase_v1.xlsx", rows,cells);
        return datas;
    }

}
