<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! EX01  
</h1>

<h1>
	post request
</h1>

<form action="d" method="post">
	<input type="text" name="name">
	<input type= "submit" />
</form>

<P>  The time on the server is ${serverTime}. </P>

<a id="my-link" href="#">/sample/ex02Bean?list[0].name=aaa%list[1].name=bbb&list[2].name=ccc</a>

<script>
var url = $("#my-link").text();
var encoded = encodeURI(url.trim());
console.log(encoded);
$("#my-link").attr("href", encoded);
</script>

</body>
</html>
