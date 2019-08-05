<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="../css/board.css" type="text/css" />  <!-- 사용할 css파일 지정 -->

</head>
<body>
<form action="insert_action.jsp" method="post">
  <table>
     <caption>글쓰기</caption>
   <tr>                                   <!-- tr : 테이블행 -->
      <th>제목</th>                       <!-- th : 테이블헤드 -->
      <td><input type="text" name ="title"  autofocus="autofocus" required="required"/></td>
                                      <!-- autofocus="autofocus" : 시작 시 마우스 위치하도록-->
                                      <!-- required="required" : 반드시 작성하도록 -->
   </tr>
   
   <tr>                                   
      <th>이름</th>                     
      <td><input type="text" name ="name" required="required"/></td>
   </tr>
   
   <tr>                                  
      <th>비밀번호</th>                      
      <td><input type="password" name ="password" required="required" /></td>
   </tr>
   
   <tr>                                 
      <th>내용</th>                      
      <td><textarea rows="5" cols="50" name="content" required="required"></textarea></td>
   </tr>
   
   <tr>
      <td colspan="2" align="center">   
         <input type="submit" value="완료" />
      
      </td>
   
   
   </tr>
   
   
  </table>


</form>

</body>
</html>