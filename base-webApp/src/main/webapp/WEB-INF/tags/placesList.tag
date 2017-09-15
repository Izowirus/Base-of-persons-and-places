<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

		<div id="nav">
			<form:form action="/places/search" modelAttribute="searchDTO" method="post" id="form">
				<form:input path="nameToSearch" id="nameToSearch" ></form:input>
				<input type="submit" value="Szukaj" id=search-button>
			</form:form>
			<c:forEach var="Place" items="${List}">
	  
	   			 <a href="<c:url value="/places/place-${Place.id}"/>">${Place.name }</a></br>
			</c:forEach>
		</div>
		<div id="secondMenu">
		<sec:authorize access="isAuthenticated()">
			<span>
				<a href="<c:url value="/places/addPlace"/>">Dodaj nowe miejsce</a>
			</span>
			</sec:authorize>
			<span>
				<a href="<c:url value="/contact"/>">Kontakt</a>
			</span>
			
				<sec:authorize access="isAnonymous()">
				<span>
 					<a href="<c:url value="/register"/>">Zaloguj się</a>
 				</span>
				</sec:authorize>	
			
				<span>
				<sec:authorize access="isAuthenticated()">
				
					<a href="<c:url value="/profile"/>">Twój profil</a>
				</sec:authorize>
					</span>
		
			
		</div>	

