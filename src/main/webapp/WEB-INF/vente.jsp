<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vente vehicules neufs et occasions</title>
</head>
<body>
<h1>BIENVENUE SUR LA PAGE DES VENTES</h1>
	<!-- affichage des notifications -->
	<c:out  value="${notification} " />
		
		<!-- affichage de la liste des voitures avec un bouton pour en reserver une pour essai -->
		<c:forEach items="${carslist}" var="car" varStatus="status">
			<form action="" method="post">
				<c:out value="Marque : ${car.brand} model : ${car.model} année : ${car.year} " />
				<input id="carId" name="carId" type="hidden" value="${car.id}">
				<button type="submit">vérifier la disponibilité</button>
				</br>
			</form>
		</c:forEach>
	
	
</body>
</html>