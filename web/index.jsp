<%--
  Created by IntelliJ IDEA.
  User: HighProphet
  Date: 2015/9/6
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>VitaFramework</title>
	<script src="/vitaframework/dwr/engine.js"></script>
	<script src="/vitaframework/dwr/interface/customerAction.js"></script>
	<script type="text/javascript">
		function doSth() {
			var person;
			person.name = "prophet";
			person.age = 2;
			person.salary = 23.32;
			custmerAction.doSomething(persion, function (result) {
				alert(result);
			})
		}
		doSth();

	</script>
</head>
<body>
<form action="index" enctype="multipart/form-data" method="post">
	<label>upload</label>
	<input type="file" name="file"/>
	<input type="text" name="info">
	<input type="submit" value="submit">
</form>
</body>
</html>
