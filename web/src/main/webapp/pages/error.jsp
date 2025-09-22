<%@page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
</head>
<body>
<h1>An example project for using old struts 1.x in Spring Boot.</h1>
<div style="text-align:center;font-size:medium;background:#f4f4f4;">
    <br />
    <html:errors/>
    <br />
    <p>
      <input type="button" value="back" style="width:70px" onclick="doBack();"></input>
    </p>
    <p></p>
</div>
</body>
</html>