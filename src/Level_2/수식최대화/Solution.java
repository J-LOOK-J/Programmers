package Level_2.수식최대화;

import java.util.LinkedList;

public class Solution {

    long answer = 0;

    public long solution(String expression) {

        String operators = "*-+";
        String[] split = expression.split("");
        // split으로 분리된 배열을 다음과 같이 반환 형식: {100, *, 50, -, 10}
        LinkedList<String> linkedList = assemble(split, operators);

        String[] operator = {"*", "-", "+"};
        boolean[] visited = new boolean[3];

        dfs(operator, visited, linkedList);

        return answer;
    }

    /* split 분리된 배열을 숫자와 연산자로 나누어 list 에 담아주기 형식: {100, *, 50, -, 10}*/
    public LinkedList<String> assemble(String[] split, String operators) {

        LinkedList<String> linkedList = new LinkedList<>();
        StringBuffer sBuffer = new StringBuffer();

        for (int i = 0; i < split.length; i++) {
            if (!operators.contains(split[i])) {
                sBuffer.append(split[i]);
            }else {
                linkedList.add(String.valueOf(sBuffer));
                sBuffer.delete(0, sBuffer.length());
                linkedList.add(split[i]);
            }
        }
        linkedList.add(String.valueOf(sBuffer));
        return linkedList;
    }


    public void dfs(String[] operator, boolean[] visited, LinkedList<String> list) {

        for (int i = 0; i < 3; i++) {
            if (visited[i] == false) {
                visited[i] = true;

                // list 를 계속 업데이트 해줘야 하기 때문에 true 면 계산한 templist 를 가지고 계산을 이어가고 아닌경우 이전의 list 값을 가지고 계산을 이어간다.
                LinkedList<String> templist = calculate(operator[i], list);

                // templist.size 를 통해 완료여부 확인 (이유: 모든 연산자가 다 사용되지 않을 수도 있기 때문.)
                if (templist.size() == 1) {
                    long num = Long.parseLong(templist.get(0));
                    num = num < 0 ? num * (-1) : num;
                    answer = answer < num ? num : answer;
                }else {
                    dfs(operator, visited, templist);
                }
                visited[i] = false;
            }
        }   // for
    } //function: dfs


    public LinkedList<String> calculate(String operator, LinkedList<String> list) {

        LinkedList<String> tempList = new LinkedList<>(list);

        int index = list.indexOf(operator);

        // 해당 연산자가 없을때까지 반복
        while (index != -1) {
            long newNum = 0;

            switch (operator) {
                case "*":
                    newNum = Long.parseLong(tempList.get(index - 1)) * Long.parseLong(tempList.get(index + 1));
                    break;
                case "-":
                    newNum = Long.parseLong(tempList.get(index - 1)) - Long.parseLong(tempList.get(index + 1));
                    break;
                case "+":
                    newNum = Long.parseLong(tempList.get(index - 1)) + Long.parseLong(tempList.get(index + 1));
                    break;
            }

            // templist 재구성
            tempList.remove(index - 1);
            tempList.remove(index - 1);
            tempList.remove(index - 1);
            tempList.add(index - 1, String.valueOf(newNum));

            index = tempList.indexOf(operator);
        }
        // 재구성된 list 를 반환해 계산을 이어가도록...
        return tempList;
    } // function: calculate

}
