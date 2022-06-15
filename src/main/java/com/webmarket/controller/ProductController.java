package com.webmarket.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmarket.domain.model.Product;
import com.webmarket.domain.repository.ProductRepository;

@WebServlet(name = "ProductController", urlPatterns = {"/products.do","/processAddProduct.do"}) //jsp를 통과할 코드가 이 경로의 코드를 통과함 .do를 쓰는 이유? 그냥 코딩 룰.
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = -4873067786040482711L; //시리얼라이즈 번호를 정의해주는 것이 코딩 룰

	@Override	//get방식의 데이터는 여기 메서드를 통과
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("!");
		// 요청 주소 (/products.do)
        String command = req.getRequestURI().substring(req.getContextPath().length());

        ProductRepository repository = ProductRepository.getInstance();

        if (command.equals("/products.do")) {
            // 싱글턴 패턴
            List<Product> products = repository.getAllProducts();
            req.getSession().setAttribute("products", products);

        } else if (command.equals("/processAddProduct.do")) {
            // 한글 처리
            req.setCharacterEncoding("UTF-8");
            // POST로 넘어온 것
            String productId = req.getParameter("productId");
            String name = req.getParameter("name");
            int unitPrice = Integer.valueOf(req.getParameter("unitPrice"));
            String description = req.getParameter("description");
            String manufacturer = req.getParameter("manufacturer");
            String category = req.getParameter("category");
            int unitsInStock = Integer.valueOf(req.getParameter("unitsInStock"));
            String condition = req.getParameter("condition");

            Product product = new Product(productId, name, unitPrice);
            product.setDescription(description);
            product.setManufacturer(manufacturer);
            product.setCategory(category);
            product.setUnitsInStock(unitsInStock);
            product.setCondition(condition);

            repository.addProduct(product);
        }

        System.out.println("통과!!!!!!!!!!!!!!!!!");

        // products.jsp 로 이동
        req.getRequestDispatcher("products.jsp").forward(req, resp);
		
		//마지막으로 사용자 입장에서 브라우저 url을 봤을 때 jsp파일과 정보가 가려져있고 products.do가 나타난다.
	}
	
	@Override	//post방식의 데이터는 여기 메서드를 통과
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
