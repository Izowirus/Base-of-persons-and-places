<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="${title }">
	<jsp:body>
	<t:personList></t:personList>
		<div id="text">					
			<form:form action="/profiles/addPerson" modelAttribute="personDTO" method="post" id="form">
				
				<div class=names>
					<span>Nick:</span>
					<form:input path="nick" id="nick" ></form:input>
					<form:errors path="nick" cssclass="error" />
				</div>
				<div class=names>		
				
					<span>Imię:</span> 	 
	 				<form:input path="name" id="name" ></form:input>
					<form:errors path="name" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Nazwisko:</span>
	 				<form:input path="surname" id="surname" ></form:input>
					<form:errors path="surname" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Wiek:</span>
	 				<form:input path="age" id="age" ></form:input>
					<form:errors path="age" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Data urodzenia:</span>
					<form:input path="birthday" id="birthday" type="date" ></form:input>
					<form:errors path="birthday" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Pochodzenie:</span>	
					<form:input path="origin" id="origin" ></form:input>
					<form:errors path="origin" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Umiejętności:</span>	
					<form:input path="skills" id="skills" ></form:input>
					<form:errors path="skills" cssclass="error" />
				</div>
				<div class=names>
				

				<!-- 	<input list="types">
					<datalist id="types">
					<c:forEach var="relationshipType" items="${typeList}">
	  					<option value="${relationshipType.type}">
					</c:forEach>
					</datalist>  -->
				</div>
				
				
				<input type="submit" value="Zapisz" />

			</form:form>
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>