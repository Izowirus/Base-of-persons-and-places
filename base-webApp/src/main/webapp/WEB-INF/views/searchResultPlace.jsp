<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="Baza">
	<jsp:body>
	<t:placesList></t:placesList>
		<div id="text">
			<c:forEach var="place" items="${searchingResultPlace}">
				<div class="place-item">
					<h3><a href="<c:url value="/places/place-${place.id}"/>">${place.name }</a></h3>
				
				</div>
			</c:forEach>	
			
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate></html>