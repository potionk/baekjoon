package kakao.three;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> isBuy;
    Object[] gemType;

    public int[] solution(String[] gems) {
        isBuy = new HashSet<>();
        Collections.addAll(isBuy, gems);
        gemType = isBuy.toArray();
        for(int i=gemType.length; i<=gems.length; i++){
            for(int j=0; j<=gems.length-i; j++){
                isBuy = new HashSet<>();
                isBuy.addAll(Arrays.asList(gems).subList(j, j + i));
                if(isAllBuy())
                    return new int[]{j+1, j + i};
            }
        }
        int[] answer = {};
        return answer;
    }

    public boolean isAllBuy() {
        boolean flag=true;
        for(int i=0; i<gemType.length; i++){
            if(!isBuy.contains((String)gemType[i])){
                flag=false;
                break;
            }
        }
        return flag;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int result[] = solution.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
////        int result[] = solution.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
////        int result[] = solution.solution(new String[]{"XYZ", "XYZ", "XYZ"});
////        int result[] = solution.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
//        System.out.println(result[0]+", "+result[1]);
//    }
}