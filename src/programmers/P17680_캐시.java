package programmers;

import kotlin.collections.ArrayDeque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P17680_캐시 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }

    // n, s, p

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            if (cacheSize == 0) {
                return cities.length * 5;
            }

            List<String> cache = new ArrayList<>();
            cities = Arrays.stream(cities).map(String::toLowerCase).toArray(String[]::new);
            for (String city : cities) {
                boolean isExist = cache.stream().anyMatch(city::equalsIgnoreCase);
                if (isExist) {
                    cache.remove(city);
                    cache.add(city);
                    answer += 1;
                } else {
                    if (cache.size() >= cacheSize) {
                        cache.remove(0);
                    }
                    cache.add(city);
                    answer += 5;
                }
//                System.out.println(answer);
            }
            return answer;
        }
    }

/**
 - db 캐시 크기에 따른 실행시간 측정 프로그램 작성
 - 입력
 - cacheSize(0~30), cities(최대 사이즈 100,000)
 - 각 도시이름은 공백, 숫자, 특수문자가 없는 영문자임. 대소문자 구분을 하지 않는다. 최대 20자이다,
 - 입력된 도시이름 배열을 순서대로 처리할 때, 총실행시간을 출력한다.
 - 캐시 교체 알고리즘은 LRU를 사용한다.
 - cache hit 일 경우 실행시간은 1이다.
 - cache miss일 경우 실행시간은 5이다.

 2. 예시

 - [Jeju, Pangyo, Seoul, NewYork, LA, Jeju, Pangyo, Seoul, NewYork, LA]	, 캐시크기 3

 */
}
