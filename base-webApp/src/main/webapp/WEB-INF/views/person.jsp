<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:pageTemplate title="${title }">
	<jsp:body>
		<t:personList></t:personList>
		<div id="text">
			<div class="names">
				<span>Nick:</span>
				${person.nick }</br>
			</div>
			<div class=names>
				<span>Imię:</span>
				${person.name }</br>
			</div>
			<div class=names>
				<span>Nazwisko:</span>
				${person.surname }</br>
			</div>
			<div class=names>
				<span>Wiek:</span>
				${person.age }</br>
			</div>
			<div class=names>
				<span>Data urodzenia:</span>
				<fmt:formatDate  value="${person.birthday }" pattern="dd-MMM-yyyy"/>
			</div>
			<div class=names>
				<span>Pochodzenie:</span>
				<a href="<c:url value="/places/${person.origin}"/>">${person.origin }</a>
				<!-- ${person.origin }</br> -->
			</div>
			<div class=names>
				<span>Umiejętności:</span>
				${person.skills }</br>
			</div>
			<div class=names>
				<span>Powiązania:</span>
				
				<div class=rel>
				<c:forEach var="relationship" items="${ListRelations}">
	  		
	  				<a href="<c:url value="/profiles/person-${relationship.person_second.id}"/>">${relationship.person_second.nick} (${relationship.relationshipType.type}), </a>
	  			
				</c:forEach>
				<c:forEach var="relationship" items="${ListRelationsSecond}">
	  		
	  				<a href="<c:url value="/profiles/person-${relationship.person_owner.id}"/>">${relationship.person_owner.nick} (${relationship.relationshipType.typeSecond}), </a>
	  			
				</c:forEach>
				</div>
			</div>		
			<c:if test="${Owner ==true}">
			<form class="button" action="/profiles/person-${person.id}/delete" method=post>
			
			<input type="submit" value="Usuń profil" />
			</form>
			</c:if>
			<c:if test="${Owner ==true}">
			<form class="button" action="/profiles/person-${person.id}/edit">	
   			<input type="submit" value="Edytuj" />   			
			</form>
			</c:if>
	
	
			
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>