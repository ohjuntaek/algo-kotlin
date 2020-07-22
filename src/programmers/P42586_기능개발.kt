package programmers

import java.util.*

fun main() {
    println(Arrays.toString(Solution().solution(intArrayOf(99,99,99,99,99), intArrayOf(3,3,3,3,3))))
}

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()

        var idxSpeed = 0

        while (true) {
            var count = (100 - progresses[idxSpeed]) / speeds[idxSpeed]
            var remain = (100 - progresses[idxSpeed]) % speeds[idxSpeed]
            if (remain != 0) count++
            for (i in idxSpeed until speeds.size) {
                progresses[i] += (count * speeds[i])
            }
            var r = 0
            for (i in idxSpeed until speeds.size) {
                if (progresses[i] >= 100) {
                    idxSpeed++
                    r++
                } else {
                    break;
                }
            }
            answer.add(r)
            if (idxSpeed == speeds.size) break
        }

        return answer.toIntArray()
    }
}


/*
1. 요구사항
- 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다!
- 즉, 먼저 있는 기능이 먼저 배포되야한다.
- 출력은 각 배포마다 몇개가 배포되는지 리턴하는 배열이다.
{93, 30, 55}, {1, 30, 5}, {2,1}

2. 예시
[93, 30, 55]
[1, 30, 5]
- 어차피 위에랑 밑에랑 사이즈는 항상 같음
- 맨 앞에 speeds 로 맨 앞에 progresses 가 100이 될 때까지 주차를 늘림
- 아니 막 100 넘어가고 이래도 되겠지 당연히?
- 그러면 예제에서 [100, 240, 90] 에서 100 넘는 넘 있으면 배열에 추가시키고 인덱스 증가시키기
- 그리고 나머지도 100 넘게
- 굳이 while 돌릴 필요 없이 그냥 계산식으로 쑥쑥 넘어가도 될 듯

3. 구현
- 시간 없다 고고

4. 주의사항

*/