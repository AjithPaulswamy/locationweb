<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Location</title>
</head>
<body>

<form action="updateLoc" method="post">
<!-- Boot Strap - Pre tag-->
<pre>
Id : <input type="text" name="id" value="${location.id}" readonly="true"/>
Code : <input type="text" name="code" value="${location.code}"/>
Name : <input type="text" name="name" value="${location.name}"/>
Type : Urban <input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'Checked':'Unchecked'}/>
       Rural <input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'Checked':'Unchecked'}/>
<input type="submit" value="Update"/>
<a href="displayLoc">Cancel</a>
</pre>
</form>

</body>
</html>