<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="welcome.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap">
</head>
<body>
	<header class="header">
		<div align="center">
			<button onclick="goBack()">
				<i class="fa-solid fa-left-long"></i>
			</button>
		</div>
		<div align="center">
			<h2>
				Bem-vindo ao meu e-commerce
				<%=session.getAttribute("loggedInUserName")%></h2>
		</div>
		<div align="center">
			<a href="exibirCarrinho.action"> <!-- Adicione este link para redirecionar para a página do carrinho -->
				<button>
					<i class="fa-solid fa-cart-shopping"></i>
				</button>
			</a>
		</div>

	</header>

	<div align="center">
		<form action="welcomeAction" method="get">
			<input type="text" name="searchTerm"
				placeholder="Digite o nome do produto"> <input type="submit"
				value="Pesquisar">
		</form>
	</div>

	<div class="product-container">
		<s:iterator value="products" var="product">
			<div class="product-card">
				<!-- Detalhes do Produto -->
				<img class="product-image"
					src="imgs/<s:property value="#product.productName" />.jpg"
					alt="Product Image">
				<div class="product-details">
					<div class="product-name_price">
						<p class="product-name">
							<s:property value="#product.productName" />
						</p>
						<p class="product-price">
							R$
							<s:property value="#product.productPrice" />
						</p>
					</div>
					<p class="product-description">
						<s:property value="#product.productDescription" />
					</p>

					<!-- Formulário para adicionar ao carrinho para cada produto -->


					<form action="adicionarAoCarrinho.action" method="post"
						class="form">
						<input type="hidden" name="productId" value="${productId}" /> <input
							type="submit" value="Adicionar ao Carrinho" class="form-submit" />
					</form>

				</div>
			</div>
		</s:iterator>
	</div>



	<script>
		function goBack() {
			window.history.back();
		}
	</script>

	<script src="https://kit.fontawesome.com/0a75f244da.js"
		crossorigin="anonymous"></script>
</body>
</html>
