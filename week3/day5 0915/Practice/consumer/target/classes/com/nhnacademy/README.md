Producer-Consumer
Producer - Consumer ( 생산자와 소비자)
bounded-buffered buffer problem ( 제한된 버퍼 문제)라고 표한하기도 함.
Multi process 동기화 문제의 전형적인 예 입니다.
Producer(생산자)는 데이터를 생성하고 이를 버퍼에 넣음
동시에 Consumer(소비자)는 한 번에 한 조각씩 데이터를 소비합니다. 즉 버퍼에서 데이터를 소비 합니다.
Inline-image-2023-09-14 21.20.53.000.png

문제
Producer(생산자)는 버퍼가 가득 찬 경우 버퍼에 데이터를 추가하려고 시도하지 않습니다.
Consumer(소비자)는 빈 버퍼에서 데이터를 제거하려고 시도하지 않도록 해야 합니다.
해결방법
Producer(생산자)는 버퍼가 가득 차면 sleep(절전)모드로 전환하거나 데이터를 삭제해야 합니다.
다음에 Consumer(소비자)가 버퍼에서 Item을 제거하면 생산자에게 알리고 생산자는 버퍼를 다시 채우기 시작합니다.
같은 방식으로 소비자는 버퍼가 비어 있는 것을 발견하면 sleep(절전)모드로 전환할 수 있습니다.
다음에 생산자가 데이터를 버퍼에 넣으면 잠사는 소비자가 깨어납니다.
잘못 개발하면 생산자와 소비자가 모두 활성화되기를 기다리는 교착상태가 발생할 수 있습니다.
구현
버퍼역할은 LinkedList를 이용해서 구현합니다. 즉 대기열에 있는 작업 목록을 저장 합니다.
LinkedList의 Capacity를(가용 용량)를 체크하여 가득차 있는지 체크합니다.
Buffer가 가득 차면 목록에 삽입하지 않고 비어 있으면 목록에서 제거하지 않도록 제어합니다.
package com.nhnacademy.ex01;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class PCManager {
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int bufferSize;

    public PCManager(int bufferSize) {
        this.bufferSize = bufferSize;
    }
    public void produce() throws InterruptedException {
        int data = 0;
        //todo 생산자 구현
    }

    public void consume() throws InterruptedException {
       //todo 소비자 구현
    }
}


출력
2:00:15.296 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 0
22:00:16.301 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 1
22:00:17.305 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:1
22:00:18.308 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:2
22:00:19.308 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 2
22:00:20.313 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 3
22:00:21.318 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:3
22:00:22.323 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:4
22:00:23.325 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 4
22:00:24.325 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 5
22:00:25.330 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:5
22:00:26.335 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:6
22:00:27.340 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 6
22:00:28.342 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 7
22:00:29.346 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:7
22:00:30.348 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:8
22:00:31.351 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 8
22:00:32.354 [Thread-0] INFO com.nhnacademy.ex01.PCManager - 생산자-데이터 생성 : 9
22:00:33.356 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:9
22:00:34.360 [Thread-1] INFO com.nhnacademy.ex01.PCManager - 소비자-소비:10

....
