<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		<div id="nav">
			Dziś urodziny mają:</br></br>
			<c:forEach var="Person" items="${dayList}">
	  
	   			 <a href="<c:url value="/profiles/person-${Person.id}"/>">${Person.nick }</a></br>
			</c:forEach>
		</div>
		<div id="secondMenu">

			<span>
				<a href="<c:url value="/contact"/>">Kontakt</a>
			</span>
			<span>
				<sec:authorize access="isAnonymous()">
 					<a href="<c:url value="/register"/>">Zaloguj się</a>
				</sec:authorize>
				
			</span>
			<span>
				<sec:authorize access="isAuthenticated()">
					<a href="<c:url value="/profile"/>">Twój profil</a>
				</sec:authorize>
			</span>
		</div>	

