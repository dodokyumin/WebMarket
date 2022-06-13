<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="repository"
	class="com.webmarket.data.ProductRepository" scope="session"></jsp:useBean>
<html>
<head>
<meta charset="UTF-8" />
<title>상품 목록</title>
</head>
<body>
	<%
	//7번 라인의 빈즈 코드가 결국 아래  new해준 것과 같은 것. 굳이?
	//ProductRepository repository = new ProductRepository;
	List<Product> products = repository.getAllProducts();
	out.print(products);
	%>
</body>