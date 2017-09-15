<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="Baza">
	<jsp:body>
		<t:placesList></t:placesList>
		
		<div id="text">
				<c:forEach var="place" items="${places }">
				<div class="place-item">
				<a href="<c:url value="/places/place-${place.id}"/>"><h3>${place.name}</h3></a>
				${place.size} 

				</div>
			</c:forEach>
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>