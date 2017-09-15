<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title" required="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>${title }</title>
<meta name="description" content="Baza fikcyjnych postaci"/>
<meta name="keywords" content="baza, postacie, profile"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="<c:url value="/resources/style.css"/>"/>
</head>
<body>
<!-- <h1>Baza </h1> -->
<div id="contener">
	<div id="logo">
		<a href="<c:url value="/index"/>">
			<img src="<c:url value="/resources/Title.png"/>"  alt="title" id="title"/>
		</a>
	</div>
	<div id="menu">
		<span>
			<a href="<c:url value="/profiles"/>">Osoby</a>
		</span>
		<span>
			<a href="<c:url value="/places"/>">Miejsca</a>
		</span>
	</div>
	<div id="content">
		<jsp:doBody/>
	</div>
	<footer>
		Strona fikcyjnych postaci
	</footer>
</div>
<script>
function resizeDivs() {
    var main = document.getElementById('contener').offsetHeight;
    var sidebar = document.getElementById('nav').offsetHeight;
    if (sidebar > main) {
        main = sidebar;
        document.getElementById('contener').style.height = document.getElementById('nav').style.height = main -300 + 'px'
    } else {
        sidebar = main;
        document.getElementById('nav').style.height = document.getElementById('contener').style.height = sidebar -300 + 'px'
    }
}
window.onload = resizeDivs;
</script>
</body>
</html>
