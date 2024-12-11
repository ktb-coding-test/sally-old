import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //신고당한 횟수
        HashMap<String, Integer> reportCount = new HashMap<>();
        // 받은 메일의 수
        HashMap<String, Integer> mailCount = new HashMap<>();
        //신고기록 중복 방지를 위한 저장
        HashMap<String, String> reports = new HashMap<>();
         
        for(String id : id_list){
            reportCount.put(id, 0);
            mailCount.put(id, 0);
        }
        for(int i=0; i<report.length; i++){
            String[] parts = report[i].split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            String key = reporter+" "+reported;
            if(!reports.containsKey(key)){
                reports.put(key, reported); // 새로운 신고기록만 저장
                reportCount.put(reported, reportCount.get(reported)+1);
            }
        }
        for(String key : reports.keySet()){
            String[] parts = key.split(" ");
            String reporter = parts[0];
            String reported = reports.get(key);
            
            if(reportCount.get(reported) >= k){
                mailCount.put(reporter, mailCount.get(reporter)+1);
            }
        }
        int[] result = new int[id_list.length];
        for(int i = 0; i<id_list.length; i++){
            result[i] = mailCount.get(id_list[i]);
        }
        
        return result;
    }
}