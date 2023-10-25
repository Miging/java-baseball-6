package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


/*1. 숫자 형식
첫번째 자리,두번째 자리,세번째 자리를 나누어야함
문자열 표준 함수가 정의되어 있는 string 자료형으로 처리하는 것이 좋아보임
*/

public class Application {
    static void isThreeDigitNumbers(String input) {
        if(input.length()!=3) throw new IllegalArgumentException("범위 오류");
        char first=input.charAt(0);
        char middle=input.charAt(1);
        char last=input.charAt(2);
        if(first==middle || middle==last||last==first) throw new IllegalArgumentException("중복된 숫자 존재");
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아님");
        }
    }
    public static void main(String[] args) {
        // TODO: 숫자야구 프로그램 구현
        // 1. 숫자형식 구현
        // 2. 컴퓨터 랜덤 구현
        // 3. 정답 구현
        //에러판단 변수 정의
        boolean isnoterror=true;
        while (isnoterror){
            List<Integer> computer=new ArrayList<>();
            while (computer.size()<3){
                int randomNumber= Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randomNumber)){
                    computer.add(randomNumber);
                }
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.println("숫자를 입력해주세요 : ");
            String input=Console.readLine();
            //입력에서 잘못된 값 유형시 에러
            try {
                //에러 판단 함수
                isThreeDigitNumbers(input);
            }catch (IllegalArgumentException e){
                System.out.println(e);
                isnoterror=false;
            }
        }
    }

}
