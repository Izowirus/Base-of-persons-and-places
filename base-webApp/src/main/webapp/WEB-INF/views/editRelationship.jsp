<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="${title }">
	<jsp:body>
		<t:personList></t:personList>
		<div id="text">					
			<form:form action="/profiles/editRelationship-${relationship.id}" modelAttribute="relationshipDTO" method="post" id="save"> 
				
				<div class=names>
					<span>Nick pierwszy:</span>
					${person.nick }
					<form:input type="hidden" path="nick"></form:input>	
				</div>
				<div class=names>
		
					<span>Nick drugi:</span>
					${personSecond.nick }
					<form:input type="hidden" path="nickSecond"></form:input>	
				</div>
				<div class=names>
				
					<span>Rodzaj relacji:</span>	
				 
			
					<form:input path="type" list = "types" ></form:input>
					<datalist id="types">
					<c:forEach var="relationshipType" items="${typeList}">
	  					<option value="${relationshipType.type}">
					</c:forEach>
					</datalist> 
					
					</br>
					<span>${personSecond.nick } dla ${person.nick } to ${relationship.relationshipType.type}.</span>
				
				
				
			</div>

			</form:form>
									
				<form class="button" action="/profiles/editRelationship-${relationship.id }/delete" method="post" id="delete">				
				</form>
				<input type="submit" value="Usuń relację" form="delete"/>
   				<input type="submit" value="Zapisz" form="save" />
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>