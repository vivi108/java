package Socket;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser;


public class APIExplorer {


	public static void main(String[] args) {

		try{ 
			
			// ���� ��¥ ���ϱ�
			DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
			Date nowDate = new Date();
			String tempDate = sdFormat.format(nowDate);
			
			
			String serviceKey = "=UmU5EoBOt1mOKZA2%2F01kyOqnL0wPMpGw4N47LjKZZUIjPQ3XKdOrV%2F9u%2Bb8O%2FHs%2BQkzyEHZOc4Wr%2BzHWu6OFyw%3D%3D";  
			 
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
		    urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + serviceKey); /*Service Key*/
		    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
		    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*�� ������ ��� ��*/
		    urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*��û�ڷ�����(XML/JSON) Default: XML*/
		    urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(tempDate, "UTF-8")); /*���ó�¥*/
		    urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0600", "UTF-8")); /*06�� ��ǥ(���ô���) */
		    urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*���������� X ��ǥ��*/
		    urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*���������� Y ��ǥ��*/
		   
		    URL url = new URL(urlBuilder.toString());
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
		    System.out.println("Response code: " + conn.getResponseCode());
		       
		    BufferedReader bf;
		    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		        bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    } else {
		        bf = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		    }
		       
		    StringBuilder sb = new StringBuilder();
		    String line;// ���� �д� �뵵
		    while ((line = bf.readLine()) != null) {
		        sb.append(line);//���پ� ������ �߰�
		    }
		    bf.close();
		    conn.disconnect();
		    String result =sb.toString();// �޾ƿ� �����͸� ���ڿ��� ����
		    
		    
		    //JSON parser�� ����� ������� ���ڿ� �����͸� ��üȭ
		    JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
			JSONObject parse_response = (JSONObject) jsonObj.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");// response �� ���� body ã�ƿ���
			JSONObject parse_items = (JSONObject) parse_body.get("items");// body �� ���� items �޾ƿ���
			// items�� ���� itemlist �� �޾ƿ��� itemlist : �ڿ� [ �� �����ϹǷ� jsonarray�̴�.
			JSONArray parse_item = (JSONArray) parse_items.get("item");
																		
			JSONObject obj;//parse item�� �迭�����̹Ƿ� �ϳ��� �����͸� ������ �� ����Ѵ�.
			System.out.println();
		
			for(int i = 0 ; i < parse_item.size(); i++) {
				obj = (JSONObject)parse_item.get(i);
			
				System.out.println(obj.toString());	//��ü���� ���
				System.out.println();

			}
			
			
			}
		catch(Exception e){ 
			System.out.println(e.getMessage()); 
		}
	}

			
	 
		
}

