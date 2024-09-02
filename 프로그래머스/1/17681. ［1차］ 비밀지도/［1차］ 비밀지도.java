class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String map1 = Integer.toBinaryString(arr1[i]);
            String map2 = Integer.toBinaryString(arr2[i]);
            
            // 0을 채워주기
            while (map1.length() < n) {
                map1 = "0" + map1;
            }
            while (map2.length() < n) {
                map2 = "0" + map2;
            }
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j <n; j++){
                if(map1.charAt(j)=='1' || map2.charAt(j)=='1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}