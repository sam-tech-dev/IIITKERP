<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Multiple Files Upload</h1>
<form action="../UploadMultipleFiles" method="POST" enctype="multipart/form-data">
Select file 1: <input type="file" name="file1" size="50" /><br />
Select file 2: <input type="file" name="file2" size="50" /><br />
Select file 3: <input type="file" name="file3" size="50" /><br />
Select file 4: <input type="file" name="file4" size="50" /><br />
Select file 5: <input type="file" name="file5" size="50" /><br />
<br /> <input type="submit" value="Upload" />
</form>
</center>
</body>
</html>