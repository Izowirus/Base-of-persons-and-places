<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="${title }">
	<jsp:body>
		<t:personList></t:personList>
		<div id="text">					
			<form:form action="/profiles/person-${person.id}/edit" modelAttribute="personDTO" method="post" id="form">
				
				<div class=names>
					<span>Nick:</span>
					${person.nick }
				</div>
				<div class=names>
					<form:input type="hidden" path="nick" value="${person.nick }"></form:input>	
				
					<span>Imię:</span> 	 
	 				<form:input path="name" id="name" value="${person.name }"></form:input>
					<form:errors path="name" cssclass="error" />
				</div
				><div class=names>
				
					<span>Nazwisko:</span>
	 				<form:input path="surname" id="surname" value="${person.surname }"></form:input>
					<form:errors path="surname" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Wiek:</span>
	 				<form:input path="age" id="age" value="${person.age }"></form:input>
					<form:errors path="age" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Data urodzenia:</span>
					<form:input path="birthday" id="birthday" type="date" value="${person.birthday }"></form:input>
					<form:errors path="birthday" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Pochodzenie:</span>	
					<form:input path="origin" id="origin" value="${person.origin }"></form:input>
					<form:errors path="origin" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Umiejętności:</span>	
					<form:input path="skills" id="skills" value="${person.skills }"></form:input>
					<form:errors path="skills" cssclass="error" />
				</div>
				<div class=names>
				<span>Powiązania:</span>
				
				<div class=rel>
				<c:forEach var="relationship" items="${ListRelations}">
	  		
	  				<a href="<c:url value="/profiles/editRelationship-${relationship.id }"/>">${relationship.person_second.nick} (${relationship.relationshipType.type}), </a>
	  			
				</c:forEach>
				<c:forEach var="relationship" items="${ListRelationsSecond}">
	  		
	  				<a href="<c:url value="/profiles/editRelationship-${relationship.id }"/>">${relationship.person_owner.nick} (${relationship.relationshipType.typeSecond}), </a>
	  			
				</c:forEach>
				</div>
			</div>		

				

			</form:form>
			<form  id="add" action="/profiles/person-${person.id}/addRelationship">				
			</form>
			<input class="button" type="submit" value="Dodaj relację" form="add"/>
			<input class="button" type="submit" value="Zapisz" form="form"/>
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>