# 자바로 배우는 리팩토링 입문 CH1

## 매직 넘버를 기호 상수로 치환

- 매직넘버
  - 소스 코드에 특정한 숫자를 직접 적는 것
- 매직넘버를 사용하지 말아야하는 이유
  - 매직 너버의 의미를 알기 어렵다
  - 매직넘버는 수정하기가 어렵다
    - 100이라는 매직넘버를 control + f해서 찾는다고 해보자.
      - 아찔하다

## 자바에서 기호 상수를 만드는 방법

- public static final 클래스 필드
- enum 사용
- 클래스로 분리



## 상수 의존 관계

- 기호 상수에 의존하는 다른 매직 넘버를 찾아서 기호 상수를 사용한 표현식으로 변환
- 작업 영역 길이는 최대 입력 길이의 2배 이다.

```JAVA
public static final int MAX_INPUT_LENGTH = 100;
public static final int WORK_AREA_LENGTH = 200;
```

- 위 처럼 상수를 따로 만든다면 의존관계 표현이 되지 않는다.
- 아래 처럼 표현식으로 의존 관계를 표현해야 한다.

```JAva
public static final int MAX_INPUT_LENGTH = 100;
public static final int WORK_AREA_LENGTH = MAX_INPUT_LENGTH * 2;
```



### 바이트 코드에 내장된 상수에 주의하기

- 상수를 변경했을 때 모든 소스코드를 리컴파일 하면 정상동작
- 그러나 상수를 변경하고 변경한 상수의 소스코드만 컴파일 한다면?
  - 해당 함수를 참조하는 다른 곳에서는 변경 되지 않는다.

