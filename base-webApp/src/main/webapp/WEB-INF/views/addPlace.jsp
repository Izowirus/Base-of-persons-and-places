<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="${title }">
	<jsp:body>
	<t:placesList></t:placesList>
		<div id="text">					
			<form:form action="/places/addPlace" modelAttribute="placeDTO" method="post" id="form">
				
				<div class=names>
					<span>Nazwa:</span>
					<form:input path="name" id="name" ></form:input>
					<form:errors path="name" cssclass="error" />
				</div>
				<div class=names>		
				
					<span>Wielkość:</span> 	 
	 				<form:input path="size" id="size" ></form:input>
					<form:errors path="size" cssclass="error" />
				</div>
				<div class=names>
					<span>Gospodarka:</span>
	 				<form:textarea path="industry" id="industry" ></form:textarea>
					<form:errors path="industry" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Polityka:</span>
	 				<form:textarea path="politics" id="politics" ></form:textarea>
					<form:errors path="politics" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Kultura:</span>
					<form:textarea path="culture" id="culture" ></form:textarea>
					<form:errors path="culture" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Fauna:</span>	
					<form:textarea path="fauna" id="fauna" ></form:textarea>
					<form:errors path="fauna" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Flora:</span>	
					<form:textarea path="flora" id="flora" ></form:textarea>
					<form:errors path="flora" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Wojsko:</span>	
					<form:textarea path="military" id="military" ></form:textarea>
					<form:errors path="military" cssclass="error" />
				</div>
				<div class=names>
				
					<span>Opis:</span>	
					<form:textarea path="description" id="description" ></form:textarea>
					<form:errors path="description" cssclass="error" />
				</div>
				<input type="submit" value="Zapisz" />

			</form:form>
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>