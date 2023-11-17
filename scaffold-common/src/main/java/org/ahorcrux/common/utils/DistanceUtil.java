//package org.ahorcrux.common.utils;
//
//import org.gavaghan.geodesy.Ellipsoid;
//import org.gavaghan.geodesy.GeodeticCalculator;
//import org.gavaghan.geodesy.GlobalCoordinates;
//
//import java.math.BigDecimal;
//
//public class DistanceUtil {
//
//    /**
//     *
//     * @param longitudeFrom
//     * @param latitudeFrom
//     * @param longitudeTo
//     * @param latitudeTo
//     * @return 返回⽶
//     */
//    public static double getDistance(double longitudeFrom, double latitudeFrom, double longitudeTo, double latitudeTo) {
//        GlobalCoordinates source = new GlobalCoordinates(latitudeFrom, longitudeFrom);
//        GlobalCoordinates target = new GlobalCoordinates(latitudeTo, longitudeTo);
//        return new GeodeticCalculator().calculateGeodeticCurve(Ellipsoid.Sphere, source, target).getEllipsoidalDistance();
//    }
//    /**
//     * 根据经纬度，计算两点间的距离
//     * @param locationLng
//     * @param locationLat
//     * @param currentLng
//     * @param currentLat
//     * @param accurate
//     * @return 返回单位千⽶
//     */
//    public static double getDistance(String locationLng, String locationLat, String currentLng, String currentLat, int accurate){
//        double distance = getDistance(Double.parseDouble(locationLng), Double.parseDouble(locationLat), Double.parseDouble(currentLng), Double.parseDouble(currentLat));
//        if (accurate < 0) {
//            throw new RuntimeException("精确度必须是正整数或零");
//        }
//        return new BigDecimal(distance).divide(new BigDecimal(1000),accurate, BigDecimal.ROUND_HALF_UP).doubleValue();
//    }
//}
//
