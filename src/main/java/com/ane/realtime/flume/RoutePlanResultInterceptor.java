package com.ane.realtime.flume;//package com.ane.realtime.flume;
//
//import com.alibaba.fastjson.JSON;
//import com.ane.utils.DateUtil;
//import org.apache.commons.compress.utils.Charsets;
//import org.apache.commons.lang.time.FastDateFormat;
//import org.apache.flume.Context;
//import org.apache.flume.Event;
//import org.apache.flume.interceptor.Interceptor;
//
//import java.util.List;
//import java.util.Map;
//
//
///**
// * @author zhangleilei
// * @description kafka topic：route_plan_result_queue 数据用 flume 采集到 hdfs
// * @create 2021/6/16
// */
//public class RoutePlanResultInterceptor implements Interceptor {
//
//    private static FastDateFormat dateFormat = FastDateFormat.getInstance("yyyyMMdd");
//
//
////    private static final Logger logger = LoggerFactory.getLogger(RoutePlanResultInterceptor.class);
//
//    public void initialize() {
//
//    }
//
//    @Override
//    public Event intercept(Event event) {
//        Map<String, String> headers = event.getHeaders();
//        try{
//            // 获取event中的scan_time(时间格式：2021-06-18 02:10:00)
//            String line = new String(event.getBody(), Charsets.UTF_8);
//            String scanTime = JSON.parseObject(line).getString("scanTime");
//
////            System.out.println(scanTime);
//            if (scanTime == null || scanTime.length() <= 0) {
////                System.out.println("---scanTime is null or the length is zero---use system current time");
//                headers.put("scanTime", dateFormat.format(System.currentTimeMillis()));
//            } else {
////                System.out.println("----The event scanTime is----" + scanTime);
//                headers.put("scanTime", DateUtil.getDateYearString(DateUtil.getAllTimestamp(scanTime)));
//            }
//            event.setHeaders(headers);
//        }catch (Exception e){
//            //脏数据,需要sink到一个目录进行核查
//            headers.put("scanTime", "unknow");
//            event.setHeaders(headers);
//            System.out.println(e.toString());
//        }
//        return event;
//
//    }
//
//    @Override
//    public List<Event> intercept(List<Event> events) {
//        for (Event event : events) {
//            intercept(event);
//        }
//        return events;
//
//    }
//
//    @Override
//    public void close() {
//
//    }
//
//    public static class Builder implements Interceptor.Builder {
//
//        @Override
//        public Interceptor build() {
//            return new RoutePlanResultInterceptor();
//        }
//
//        @Override
//        public void configure(Context context) {
//
//        }
//    }
//}
