<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register here....</h1>
<h2>Fill All the information hear...</h2>
<img src="https://sp.yimg.com/ib/th?id=OADD2.7146945637580_1QGYTLJ065MZVQFNLW&pid=21.2&c=16&roil=0.0084&roit=0.0134&roir=0.9958&roib=1&w=442&h=231"
 alt="cars" />
<br>
<form action="saveReg" method="post">
  <pre>
 First Name<input type="text" name="firstName"/>
 Last Name<input type="text" name="lastName"/>
  Email<input type="text" name="email"/>
  Mobile<input type="text" name="mobile"/>
  <input type="submit" value="register"/>
  </pre>

</form>

</body>
</html>