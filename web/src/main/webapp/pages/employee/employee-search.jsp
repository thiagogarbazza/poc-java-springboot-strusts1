<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>

</head>
<body>
<h1>An example project for using old struts 1.x in Spring Boot.</h1>

<h2>Employee search page</h2>

<table style="width: 100%; border: 1px solid black; border-collapse: collapse;">
<tr>
    <td>ID</td>
    <td>Name</td>
    <td>Actions</td>
</tr>

<logic:iterate id="item" name="employeeSearchForm" property="itens">
    <tr>
      <td><bean:write name="item" property="id"/></td>
      <td><bean:write name="item" property="name"/></td>
      <td>
        <a href="/employee/detail.do?id=<bean:write name="item" property="id"/>">Detail</a>
        <a href="javascript:deleteEmployee('<bean:write name="item" property="id"/>');">Delete</a>
      </td>
    </tr>
</logic:iterate>

</table>

<br/>
<br/>
<script>
function deleteEmployee(id) {
  alert('Item' + id);
  debugger;
  document.forms['myForm'].action = `/employee/delete.do?id=${id}`;
  document.forms['myForm'].submit();
}
</script>
</body>
</html>