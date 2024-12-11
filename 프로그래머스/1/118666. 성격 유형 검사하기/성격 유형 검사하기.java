class Solution {
public String solution(String[] survey, int[]choices) {
		int[] scores = new int[8];
		String types = "RTCFJMAN";
		for(int i =0; i < survey.length; i++) {
			char a = survey[i].charAt(0);
			char b = survey[i].charAt(1);
			if(choices[i]>4)
				scores[types.indexOf(b)] += choices[i] - 4;
			else
				scores[types.indexOf(a)] += 4 - choices[i];
		}
		StringBuilder sb = new StringBuilder();
		sb.append(scores[0] >= scores[1] ? "R" :"T");
		sb.append(scores[2] >= scores[3] ? "C" :"F");
		sb.append(scores[4] >= scores[5] ? "J" :"M");
		sb.append(scores[6] >= scores[7] ? "A" :"N");
		
		return sb.toString();
	}
}