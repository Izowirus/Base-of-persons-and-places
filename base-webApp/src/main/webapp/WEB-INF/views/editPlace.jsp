<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="${title }">
	<jsp:body>
		<t:placesList></t:placesList>
		<div id="text">					
			<form:form action="/places/place-${place.id}/editPlace" modelAttribute="placeDTO" method="post" id="form">
				
				<div class=names>
					<span>Nazwa:</span>
					${place.name }
				</div>
				<div class=names>
					<form:input type="hidden" path="name" value="${place.name }"></form:input>		
				
					<span>Wielkość:</span> 	 
	 				<form:input path="size" id="size" value="${place.size }"></form:input>
					<form:errors path="size" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Gospodarka:</span>
	 				<form:textarea path="industry" id="industry" value="${place.industry }"></form:textarea>
					<form:errors path="industry" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Polityka:</span>
	 				<form:textarea path="politics" id="politics" value="${place.politics }"></form:textarea>
					<form:errors path="politics" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Kultura:</span>
					<form:textarea path="culture" id="culture" value="${place.culture }"></form:textarea>
					<form:errors path="culture" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Fauna:</span>	
					<form:textarea path="fauna" id="fauna" value="${place.fauna }"></form:textarea>
					<form:errors path="fauna" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Flora:</span>	
					<form:textarea path="flora" id="flora" value="${place.flora }"></form:textarea>
					<form:errors path="flora" cssclass="error" />
				</div>
				<div class=names>
					<span>Wojsko:</span>	
					<form:textarea path="military" id="military" value="${place.military }"></form:textarea>
					<form:errors path="military" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Opis:</span>	
					<form:textarea path="description" id="description" value="${place.description }"></form:textarea>
					<form:errors path="description" cssclass="error" />
				</div>
				
				<input type="submit" value="Zapisz" />

			</form:form>
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>