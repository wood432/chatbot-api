package cn.wood.chatapi.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        //httpClient主要是封装数据信息的
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112844228554/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=BF864EB0-5FA3-FC47-6E68-B4DFA6FE75C6_40487504EBADC427; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812854588258112%22%2C%22first_id%22%3A%2218c7be6ed7e85d-079748451c05e68-26001951-1327104-18c7be6ed7fde3%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjN2JlNmVkN2U4NWQtMDc5NzQ4NDUxYzA1ZTY4LTI2MDAxOTUxLTEzMjcxMDQtMThjN2JlNmVkN2ZkZTMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTI4NTQ1ODgyNTgxMTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812854588258112%22%7D%2C%22%24device_id%22%3A%2218c7be6ed7e85d-079748451c05e68-26001951-1327104-18c7be6ed7fde3%22%7D; zsxqsessionid=5c810d4186b0e2142ae5d2961e481bcf; abtest_env=beta\n");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println("res = " + res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/588414822128184/comments");

        post.addHeader("cookie", "zsxq_access_token=BF864EB0-5FA3-FC47-6E68-B4DFA6FE75C6_40487504EBADC427; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812854588258112%22%2C%22first_id%22%3A%2218c7be6ed7e85d-079748451c05e68-26001951-1327104-18c7be6ed7fde3%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjN2JlNmVkN2U4NWQtMDc5NzQ4NDUxYzA1ZTY4LTI2MDAxOTUxLTEzMjcxMDQtMThjN2JlNmVkN2ZkZTMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTI4NTQ1ODgyNTgxMTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812854588258112%22%7D%2C%22%24device_id%22%3A%2218c7be6ed7e85d-079748451c05e68-26001951-1327104-18c7be6ed7fde3%22%7D; zsxqsessionid=5c810d4186b0e2142ae5d2961e481bcf; abtest_env=beta\n");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String JsonParam = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我也不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(JsonParam, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        httpClient.execute(post);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
