<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sorties cinema</title>
</head>
<body>
<h1>Voici les sorties de films de cette semaine</h1>
	<!-- balise jstl pour affichage -->
	<p><c:out value="Spiderman!"></c:out></p>
	<!-- balise jstl pour declarer une variable et sa portée (scope) -->
	<c:set var="auteur" value="reitman" scope="page" />
	<!-- balise jstl pour affichage d'une variable. Si la variable est null ou inexistante, on affiche le texte entre les balises-->
	<p><c:out value="${auteur}">Spiderman inconnu</c:out></p>
	<!-- balise jstl pour supprimer une variable et sa portée (scope) -->
	<c:remove var="auteur" scope="page" />
	<p><c:out value="${auteur}">valeur supprimée</c:out></p>
	
</body>
</html>