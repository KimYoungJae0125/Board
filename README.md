## Template Engine

## Frontend

### SCSS
- CSS에서 변수 및 상속, 혼합, 중첩 등의 다양한 기능을 사용가능하게 해주는 전처리기   
- Sass 3 버전부터 등장하였으며, Sass와는 달리 기존 CSS와 문법이 비슷하다.
#### 파일이 변경되면 자동으로 컴파일
```shell
$ sass --watch src/main/resources/static/scss/:src/main/resources/static/css
```
- ```src/main/resources/static/scss``` : scss 파일이 있는 폴더 경로
- ```:src/main/resources/static/css``` : scss 파일을 컴파일해서 생성할 폴더 경로

### thymeleaf
- JSP와는 달리 HTML 기반으로 작동하며, th: 속성을 이용하여 동적 View를 이용 가능하게 해주는 Template Engine입니다.
- Spring Boot에서는 공식적으로 Thymeleaf를 권장합니다.
> ### dependency<br>
> ``` implementation 'org.springframework.boot:spring-boot-starter-thymeleaf:2.7.0' ```

> ### Reference
> https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

### thymeleaf-layout-dialect
- JSP의 Tiles와 동일한 기능
- 하나의 템플릿을 만들어서 공통으로 사용 가능하게 해주는 라이브러리이다.
> ### dependency<br>
> ``` implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.1.0' ```

> ### Reference
> https://github.com/ultraq/thymeleaf-layout-dialect


## Backend

### adpotJdk11


## Framework

### Spring Boot

### MyBatis

## Build Tool

### Gradle