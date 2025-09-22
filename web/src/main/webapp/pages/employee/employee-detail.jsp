<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
</head>
<body>
<h1>An example project for using old struts 1.x in Spring Boot.</h1>

<h2>Employee detail page</h2>

<b>ID</b>: <c:out value="${item.id}"/> <br/>
<b>Name</b>: <c:out value="${item.name}"/>  <br/>
<b>E-mail</b>: <c:out value="${item.email}"/>  <br/>

<br/>
<br/>
</body>
</html>