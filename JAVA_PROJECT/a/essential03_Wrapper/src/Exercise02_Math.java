
public class Exercise02_Math {
	public static void main(String[] args) {
		// 위도,경도 두개를 알때 거리 계산
		// 강남
		double x1 = 127.0254323;
		double y1 = 37.497942;
		// 잠실
		double x2 = 127.0979449;
		double y2 = 37.5132612;
		
		// 이 두 좌표의 거리는 몇 km 일까?
		double theta = x1 - x2;
		double dist = Math.sin(Math.toRadians(y1)) * Math.sin(Math.toRadians(y2)) +
				Math.cos(Math.toRadians(y1)) * Math.cos(Math.toRadians(y2)) * Math.cos(Math.toRadians(theta));
		
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		
		dist = dist * 1.609344;
		System.out.println(dist +" KM");

	}
}
