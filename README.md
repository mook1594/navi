# navi

### 목표
- 시작, 이동 과정 데이터, 종료 데이터를 수신 후 유효한 정보인지 판단

### 요구사항
- 내비 종료시 사용자의 위치에 따라 업무 인정과 불인정으로 나눠 저장
- 결과 저장 데이터 [transactionId, 출도착일시, 출발지, 도착지, 출발지, 주행거리, 위도, 경도]
- 수신되는 데이터별 조건
  #### <내비 시작>
  

  #### <사용자의 현재 위치 정보와 남은 거리>
  - 1초에 한번씩 위치정보가 수신
  - GPS의 이동거리(위도, 경도 계산)가 500m 이내인 경우엔 결과 테이블에 저장하지 않음.
  - 1시간 동안 위치가 변경 되지 않으면 결과를 저장하지 않음.
  - 내비 시작 후 24시간 동안 위치 정보가 수신 되지 않으면 저장하지 않음.
  - 종료 후에 위치 정보가 업데이트 되는 경우 무시

  #### <내비 종료>
  - 설정된 목적지와 내비 종료 위치가 100m 이내이면 업무인정 종료. 그외엔 불인정 처리.

### 조건
- 동시 1000명의 사용자가 사용할 수 있는 시스템 설계

### 샘플데이터 
##### 1. 업무 인정 종료
[데이터](./src/test/resources/SampleDataForSuccess.json)
##### 2. 업무 불인정 종료
[데이터](./src/test/resources/SampleDataForFail.json)
##### 3. 결과 저장 안함
[데이터](./src/test/resources/SampleDataForNotSave.json)

### 작업 내용 
- 비즈 내비 시작 했을 때 동작 구현 
- 사용자의 현재 위치 정보 수신했을때 동작 구현
- 내비 종료 데이터 수신했을때 동작 구현 
- 로그 처리 
- 부하 확인 

### 환경 구축
- java8 / Spring
- NoSql
- 
