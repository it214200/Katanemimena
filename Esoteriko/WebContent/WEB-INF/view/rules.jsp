<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

   <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
<title>Insert title here</title>
</head>


<body>

	<nav class="navbar navbar-light bg-light">
  		<a class="navbar-brand" href="/Esoteriko/">
    		<img src="${pageContext.request.contextPath}/resources/dit-logo.png" alt = "image" width="150" height="60" class="d-inline-block align-top"/>
    		Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Κανόνες
  		</a>
	</nav>

	<br>
	<ul class="list-group list-group-flush">
		<li class="list-group-item" style="width: 800px"><b>Κανόνες</b></li>
  		<li class="list-group-item" style="width: 800px">1.Όλοι οι φοιτητές δικαιούνται να κάνουν μια αιτηση στο κάθε εξάμηνο</li>
  		<li class="list-group-item" style="width: 800px">2.Ο μέγιστος αριθμός δικαιούχων είναι το 80% του συνολικού αριθμού φοιτητών ανά τμήμα</li>
  		<li class="list-group-item" style="width: 800px">3.Όλα τα τμήματα έχουν δικαιούχους σίτισης εκτός από το τμήμα newcomers των νεοσύλλεκτων</li>
		<li class="list-group-item" style="width: 800px">4.Η λίστα των δικαιούχων της σίτισης διαμορφώνεται με βάση τους πόντους που έχει συγκεντρώσει ο κάθε φοιτητής</li>  		
  		<li class="list-group-item" style="width: 800px">5.Αν ο φοιτήτης έχει μηδενικό εισόδημα ή οι γονείς του είναι άνεργοι τότε αυτομάτως δικαούται σίτιση</li>
  		<li class="list-group-item" style="width: 800px">6.Αν το εισόδημα είναι μικρότερο των 10.000 ευρώ τότε παίρνει 100 πόντους</li>
  		<li class="list-group-item" style="width: 800px">7.Αν το εισόδημα είναι από 10.000 μέχρι 15.000 ευρώ τότε παίρνει 30 πόντους</li>
  		<li class="list-group-item" style="width: 800px">8.Αν έχει αδέρφια που σπουδάζουν παίρνει 20 πόντους ανά αδερφό</li>
  		<li class="list-group-item" style="width: 800px">9.Αν είναι από διαφορετική πόλη από τη πόλη που φοιτά παίρνει 50 πόντους</li>		
	</ul>

	<br>
	<input type="button" class="btn btn-danger" value="Επιστροφή"
			onclick="window.location.href='/Esoteriko';" />

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>