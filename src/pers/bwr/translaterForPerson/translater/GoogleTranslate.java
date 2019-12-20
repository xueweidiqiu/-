package pers.bwr.translaterForPerson.translater;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

import pers.bwr.translaterForPerson.translater.fat.Translater;

public class GoogleTranslate implements Translater {

	@Override
	public String translateLine(String translateThem) {
		/*
		 * 非本人代码
		 */
		/*
		*第一种方式post请求
		*/
		String jsonResult = this.translaterName() + "翻译出错";
		
		JSONObject result = new JSONObject();
		JSONObject jsons = new JSONObject();
		jsons.put("key","value");
		translateThem = translateThem.replace(" ", "%20");
		try {
		            URL url = new URL("http://translate.google.cn/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=zh_CN&q=" + translateThem);
		            //打开和url之间的连接
		            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		            PrintWriter out = null;
		            //请求方式 这里设置你需要请求的方式
//		           conn.setRequestMethod("POST");
//		           //设置通用的请求属性
		            conn.setRequestProperty("accept", "*/*");
		            conn.setRequestProperty("connection", "Keep-Alive");
		//  这里设置请求头
		            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
		            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
		            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
		            conn.setDoOutput(true);
		            conn.setDoInput(true);
		            //获取URLConnection对象对应的输出流
		            out = new PrintWriter(conn.getOutputStream());
		            //发送请求参数即数据
		            out.print(result);
		            //缓冲数据
		            out.flush();
		            //获取URLConnection对象对应的输入流
		            InputStream is = conn.getInputStream();
		            //构造一个字符流缓存
		            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		            String str = "";
		            com.alibaba.fastjson.JSONObject jsonss = null;
		            while ((str = br.readLine()) != null) {
		            	//System.out.println(str);
		                jsonss =com.alibaba.fastjson.JSONObject.parseObject(str);
		            }
		            //System.out.println("获取到的报文数据为："+jsonss);
		            
		            jsonResult = jsonss.getJSONArray("sentences").getJSONObject(0).getString("trans");
		            //System.out.println(jsonResult);
		            //关闭流
		            is.close();
		            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
		            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上 disconnect后正常一些。
		            conn.disconnect();
		            //System.out.println("结束");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		return jsonResult;


	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "Google翻译";
	}

}
