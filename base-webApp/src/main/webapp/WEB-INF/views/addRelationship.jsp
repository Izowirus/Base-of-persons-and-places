<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="${title }">
	<jsp:body>
		<t:personList></t:personList>
		<div id="text">					
			<form:form action="/profiles/person-${person.id}/addRelationship" modelAttribute="relationshipDTO" method="post" id="form"> 
				
				<div class=names>
					<span>Nick:</span>
					${person.nick }
				</div>
				<div class=names>
		
					<span>Nick:</span>
					<form:input path="nickSecond" id="nickSecond" ></form:input>
					<form:errors path="nickSecond" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Rodzaj relacji:</span>	
				 
			
					<form:input path="type" list = "types"></form:input>
					<datalist id="types">
					<c:forEach var="relationshipType" items="${typeList}">
	  					<option value="${relationshipType.type}">
					</c:forEach>
					</datalist> 
					
					</br>
					<span>Osoba, której nick wpiszesz, to dla ${person.nick } powiązanie, które wybierzesz.</span>
				
			</div>


				<input class="button" type="submit" value="Zapisz" />

			</form:form>

		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>