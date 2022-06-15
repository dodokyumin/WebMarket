<%@page import="com.webmarket.domain.repository.ProductRepository"%>
<%@page import="com.webmarket.domain.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <jsp:useBean id="repository"
	class="com.webmarket.data.ProductRepository" scope="session"></jsp:useBean> --%>
<html>
<head>
<meta charset="UTF-8" />
<title>상품 목록</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
</head>
<body>
<div class="p-5 bg-primary text-white">
      <div class="container">
      <%
      String name = (String) session.getAttribute("name");
      
      %>
        <h1 class="display-3">상품목록</h1>
      </div>
    </div>
    
    <div class="contianer">
			<div class="row" align="center">
				<%
				//세션 사용해보기
				//String name = (String) session.getAttribute("name");
	            //int age = (int) session.getAttribute("age");
	            
	            //out.print(session.getAttribute("foods"));
	            
				//싱글턴 패턴
					//ProductRepository repository = ProductRepository.getInstance();
					//List<Product> products = repository.getAllProducts();
					
					//List<Product>타입으로 형변환
					 List<Product> products = (List<Product>) session.getAttribute("products");
					 
					for(int i = 0; i < products.size(); i++){
						Product product = products.get(i);
				%>
				<div class="col-md-4">
					<h3><%= product.getName() %></h3>
					<p><%= product.getDescription() %></p>
					<p><%= product.getUnitPrice() %> 원 </p>
					<p><a href="product.jsp?id=<%= product.getId() %>" class = "btn btn-secondary">상세 정보 &raquo;</a></p>
				</div>
				<%
				}
				%>
			</div>
		</div>
    
	<%-- <%
	//7번 라인의 빈즈 코드가 결국 아래  new해준 것과 같은 것. 굳이?
	//ProductRepository repository = new ProductRepository;
	List<Product> products = repository.getAllProducts();
	out.print(products);
	%> --%>
</body>
</html>