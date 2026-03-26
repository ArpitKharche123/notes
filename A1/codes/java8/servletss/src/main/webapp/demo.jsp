<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- Directive Tag:
    Used to import external resources in a JSP file. -->
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Declaration Tag
	used to declare the global variables
	and methods of a java.
	
	Anything inside this tag will be present
	outside the service() method! -->
	<%!
	    int x = 10;
	    int y = 20;
	
	    public int multiply(int a, int b) {
	        return a * b;
	    }
	%>
	
	<!-- Scriptlet Tag
	
	Used to create local variables or in method logics.
	
	Anything inside this tag will be returned 
	within the service() method!. -->
	<%
	    int a = 5;
	    int b = 6;
	    int sum = a + b;
	
	    // Using List (imported using directive)
	    List<String> names = new ArrayList<>();
	    names.add("Ram");
	    names.add("Shyam");
	    names.add("Mohan");
	%>
	
	<!--Expression Tag
	
	Used to print/display results on web browser.
	  -->	
	Value of x = <%= x %> <br>
	Value of y = <%= y %> <br>
	
	Multiply = <%= multiply(3,4) %> <br>
	First name = <%= names.get(0) %> <br>
	
	Sum = <%= sum %> <br>
</body>
</html>