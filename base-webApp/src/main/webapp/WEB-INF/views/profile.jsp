<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="Baza">
	<jsp:body>
	<t:mainTag></t:mainTag>

		<div id="text">
		<div class="names">
				<span>Nazwa użytkownika:</span>
				<sec:authentication property="principal.username" />
			</div>
			<div class=names>
				<span>Email:</span>
				${user.mail }
			</div>
			<div class=names>
				<span>Profile osób, które stworzyłeś:</span>
				<div class=rel>
				<c:forEach var="person" items="${PersonsList}">	  		
	  				<a href="<c:url value='/profiles/person-${person.id}'/>">${person.nick} </a>
				</c:forEach>
				</div>
				
			</div>
			<div class=names>
				<span>Profile miejsc, które stworzyłeś:</span>
				<c:forEach var="place" items="${PlacesList}">	  		
	  				<a href="<c:url value='/places/place-${place.id}'/>">${place.name} </a>
				</c:forEach>
			
			</div>
			<form class="button" action="/logout">
			<input type="submit" value="Wyloguj się" />
			</form>
			
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>