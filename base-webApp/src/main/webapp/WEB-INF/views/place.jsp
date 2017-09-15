<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="${title }">
	<jsp:body>
		<t:placesList></t:placesList>
		<div id="text">
			<div class="names">
				<span>Nazwa:</span>
				${place.name }
			</div>
			<div class=names>
				<span>Wielkość:</span>
				${place.size }
			</div>
			<div class=names>
				<span>Gospodarka:</span>
				${place.industry }
			</div>
			<div class=names>
				<span>Polityka:</span>
				${place.politics }
			</div>
			<div class=names>
				<span>Kultura:</span>
				${place.culture }
			</div>
			<div class=names>
				<span>Fauna:</span>
				${place.fauna }
			</div>
			<div class=names>
				<span>Flora:</span>
				${place.flora }
			</div>
			<div class=names>
				<span>Wojsko:</span>
				${place.military }
			</div>
			<div class=names>
				<span>Opis:</span>
				${place.description }
			</div>
			<c:if test="${Owner ==true}">
			<form class="button" action="/places/place-${place.id}/delete" method=post>
			<input type="submit" value="Usuń profil" />
			</form>
			<form class="button" action="/places/place-${place.id}/editPlace">
   			<input type="submit" value="Edytuj" />
			</form>
			</c:if>
	
	
			
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>