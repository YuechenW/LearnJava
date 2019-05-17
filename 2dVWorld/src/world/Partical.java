package world;

import java.math.BigDecimal;

public class Partical {
	private double lat;
	private double lng;
	private double quality;
	private double gravitation;
	private static double WORLD_RADIUS = 6378.137;//抽象为地球
	private static double G = 6.67E-11;
	
	public Partical() {
		
	}

	public Partical(double lat, double lng, double quality) {
		this.lat = lat;
		this.lng = lng; 
		this.quality = quality;
		this.gravitation = this.quality*9.8;
	}

	public double getLat() {
		return lat;
	}
	
	public double getLng() {
		return lng;
	}
	
	public double getQua() {
		return quality;
	}
	
	public double getGra() {
		return gravitation;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public void setQua(double qua) {
		this.quality = qua;
	}
	
	public void setGra(double gra) {
		this.gravitation = gra;
	}
	
	private static double getRadian(double degree) {
		return degree * Math.PI / 180.0;
	}
	
	public static double getDis(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = getRadian(lat1);
		double radLat2 = getRadian(lat2);
		double a = radLat1 - radLat2;// 两点纬度差
		double b = getRadian(lng1) - getRadian(lng2);// 两点的经度差
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
				* Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));//来自谷歌地图的计算公式
		s = s * WORLD_RADIUS;
		return s * 1000;
	}
	
	public static BigDecimal getGravitation(double qua1, double qua2, double dis) {//得到引力
		double a1 = (qua1*qua2);
		double a2 = (Math.pow(dis,2));
		BigDecimal mg = new BigDecimal(G);		
		BigDecimal ma1 = new BigDecimal(a1);
		BigDecimal ma2 = new BigDecimal(a2);
		BigDecimal ma3 = ma1.multiply(mg);
		BigDecimal div = ma3.divide(ma2,20, BigDecimal.ROUND_HALF_EVEN);
		return div;
	}

	@Override
	public String toString() {
		return "质点的纬度=" + lat + ", 经度为" + lng + ", 质量为" + quality + "千克" + "，万有引力为(重力)" + gravitation + "牛顿";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quality);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public boolean equals(Partical par) {
		if((this.getLat()==par.getLat())&&(this.getLng()==par.getLng())&&(this.getQua()==par.getQua()))
			return true;
		else
			return false;
	}
	
}
