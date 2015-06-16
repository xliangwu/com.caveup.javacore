package com.learn.core.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OrderQuery {

    public static void main(String[] args) {
        long base = 100000000000L;
        for (long i = 1; i < 899999999999L; i++) {
            String url = "https://sp0.baidu.com/9_Q4sjW91Qh3otqbppnN2DJv/pae/channel/data/asyncqury?cb=jQuery110209804386168252677_1427245789385&appid=4001&com=shunfeng&nu=909457415730&vcode=&token=&_=1427245789389";
            String content = getHtml(url);
            if (!content.contains("201")) {
                System.out.println(url);
                System.out.println(content);
            }
            break;
        }

    }

    public static String getHtml(String urlString) {
        try {
            StringBuffer html = new StringBuffer();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while ((temp = br.readLine()) != null) {
                html.append(temp).append("\n");
            }
            br.close();
            isr.close();
            return html.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
