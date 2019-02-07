
public class Exercise02_Math {
	 static double distance(double lat1, double lng1, double lat2, double lng2) {
		 						// 위도		 	경도
		    double earthRadius = 3958.75; 
		    
		    double dLat = Math.toRadians(lat2-lat1);
		    
		    double dLng = Math.toRadians(lng2-lng1);
		    
		    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		    		
		               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
		               
		               Math.sin(dLng/2) * Math.sin(dLng/2);
		    
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		    
		    double dist = (earthRadius * c);

		    return dist;
	 }
	public static void main(String[] args) {
		// 위도, 경도 두개를 할때 거리 계산
		// 강남역 좌표
		double x1 = 127.0254323; // 경도 lon 
		double y1 = 37.497942; // 위도 lat
		
		// 집 
		double x2 = 127.116265;
		double y2 = 37.253402;
		
		// 잠실
		double x3 = 127.0979449;
		double y3 = 37.5132612;
				
		
		// 이 두 좌표의 거리는 km 일까?
		
		/*
		 
		    경도 1도의 거리 (km단위) = cos( 위도 ) * 6400 * 2 * 3.14 / 360
			위도 1도의 거리는 아래와 같이 계산할 수 있고 대략 111 km 입니다.
			위도 1도의 거리 (km단위) = 6400 * 2 * 3.14 / 360
			위의 공식과 값을 이용하여서 2개의 위도, 경도의 거리를 계산하는 공식은 다음과 같습니다.

			X = ( cos( 위도#1 ) * 6400 * 2 * 3.14 / 360 ) * | 경도#1 - 경도#2 |
			Y = 111 * | 위도#1 - 위도#2 |
			D = √ ( X² + Y² )
			
		 */
		
		double d = distance(y1,x1,y2,x2);
		System.out.println("강남 - 용인 : "+d+" km");
		double dd = distance(y1,x1,y3,x3);
		System.out.println("강남 - 잠실 : "+dd+" km");
		 
		/* ########소수점 절사 방식########
		 double numnber = 77.7777;

		 String num = String.format("%.1f" , number);

		 system.out.println("number="+number);	 //number = 77.7 
			 		
		*/
		String ds = String.format("%.2f", d);
		String dds = String.format("%.2f", dd);
		
		System.out.println("강남 - 용인 : "+ds+" km");
		System.out.println("강남 - 잠실 : "+dds+" km");

	}
}
