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
			
			// 현재 날짜 구하기
			DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
			Date nowDate = new Date();
			String tempDate = sdFormat.format(nowDate);
			
			
			String serviceKey = "=UmU5EoBOt1mOKZA2%2F01kyOqnL0wPMpGw4N47LjKZZUIjPQ3XKdOrV%2F9u%2Bb8O%2FHs%2BQkzyEHZOc4Wr%2BzHWu6OFyw%3D%3D";  
			 
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
		    urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + serviceKey); /*Service Key*/
		    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
		    urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
		    urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(tempDate, "UTF-8")); /*오늘날짜*/
		    urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0600", "UTF-8")); /*06시 발표(정시단위) */
		    urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
		    urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
		   
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
		    String line;// 버퍼 읽는 용도
		    while ((line = bf.readLine()) != null) {
		        sb.append(line);//한줄씩 읽으며 추가
		    }
		    bf.close();
		    conn.disconnect();
		    String result =sb.toString();// 받아온 데이터를 문자열로 저장
		    
		    
		    //JSON parser를 만들어 만들어진 문자열 데이터를 객체화
		    JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
			JSONObject parse_response = (JSONObject) jsonObj.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");// response 로 부터 body 찾아오기
			JSONObject parse_items = (JSONObject) parse_body.get("items");// body 로 부터 items 받아오기
			// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다.
			JSONArray parse_item = (JSONArray) parse_items.get("item");
																		
			JSONObject obj;//parse item이 배열형태이므로 하나씩 데이터를 가져올 때 사용한다.
			System.out.println();
		
			for(int i = 0 ; i < parse_item.size(); i++) {
				obj = (JSONObject)parse_item.get(i);
			
				System.out.println(obj.toString());	//객체별로 출력
				System.out.println();

			}
			
			
			}
		catch(Exception e){ 
			System.out.println(e.getMessage()); 
		}
	}

			
	 
		
}

