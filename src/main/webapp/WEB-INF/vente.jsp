<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vente vehicules neufs et occasions</title>
</head>
<body>
<h1>BIENVENUE SUR LA PAGE DES VENTES</h1>
	<c:out  value="${notification} " />
		<c:forEach items="${carslist}" var="car" varStatus="status">
			<form action="" method="post">
				<c:out value="Marque : ${car.brand} model : ${car.model} ann�e : ${car.year} " />
				<input id="carId" name="carId" type="hidden" value="${car.id}">
				<button type="submit">v�rifier la disponibilit�</button>
				</br>
			</form>
		</c:forEach>
	
	
</body>
</html>