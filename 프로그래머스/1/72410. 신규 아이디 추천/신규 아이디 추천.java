import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계: 모든 대문자를 소문자로 변환
        String answer = new_id.toLowerCase();

        // 2단계: 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)만 남기기
        StringBuilder sb = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c == '-') || (c == '_') || (c == '.')) {
                sb.append(c);
            }
        }

        // 3단계: 연속된 마침표(.)를 하나의 마침표(.)로 치환
        StringBuilder newsb = new StringBuilder();
        boolean dot = false; // 전에 마침표가 없다고 판단
        for (char c : sb.toString().toCharArray()) {
            if (c == '.') {
                if (!dot) {
                    newsb.append(c);
                    dot = true;
                }
            } else {
                newsb.append(c);
                dot = false;
            }
        }

        // 4단계: 마침표(.)가 처음이나 끝에 위치하면 제거
        if (newsb.length() > 0 && newsb.charAt(0) == '.') {
            newsb.deleteCharAt(0);
        }
        if (newsb.length() > 0 && newsb.charAt(newsb.length() - 1) == '.') {
            newsb.deleteCharAt(newsb.length() - 1);
        }

        // 5단계: 빈 문자열이면 "a" 대입
        if (newsb.length() == 0) {
            newsb.append('a');
        }

        // 6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 제거
        if (newsb.length() >= 16) {
            newsb.setLength(15);
            // 제거 후 마지막이 마침표(.)라면 제거
            if (newsb.charAt(newsb.length() - 1) == '.') {
                newsb.deleteCharAt(newsb.length() - 1);
            }
        }

        // 7단계: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        while (newsb.length() < 3) {
            newsb.append(newsb.charAt(newsb.length() - 1));
        }

        // 최종 결과를 answer에 저장하고 반환
        answer = newsb.toString();
        return answer;
    }
}
