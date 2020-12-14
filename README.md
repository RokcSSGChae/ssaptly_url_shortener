## ssaptly
스토브 개발 캠프 첫번째 과제 URL SHORTENER 구현을 위한 레포지토리입니다.

# 😊 공통 요구사항
- URL 입력 폼 제공
- 단축 후 결과 출력
- 동일한 URL 입력 시 동일한 shortening 결과 값 나와야 함
- shortening 결과 값은 8문자 이내로 생성
- 브라우저가 shortening URL을 입력하면 원래 URL로 리다이렉트
- 도메인은 localhost 처리
- 입력과 출력 환경은 웹 페이지 형태로 제작하는 것을 권장

# 😎 구현할 기능 목록
- 숫자를 8문자 이내의 문자열로 변환하는 기능
  - BASE62
- 8문자 이내의 문자열을 숫자로 다시 변환하는 기능
- 변환한 결과 값을 화면에 ajax로 띄우는 기능
- localhost:8888/ + 8문자 입력시 해당하는 URL로 리다이렉트하는 기능

