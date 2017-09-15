<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="Baza">
	<jsp:body>
	<t:mainTag></t:mainTag>

		<div id="text">
		<form:form action="/register" modelAttribute="UserDTO" method="post" id="register">
				<div class=names>
					<span>Nazwa:</span>
					<form:input  name="name" path="name" id="name" ></form:input>
					
				</div>
				<form:errors path="name" cssclass="error" />
				<div class=names>		
				
					<span>Hasło:</span> 	 
	 				<form:input name= "password" path="password" id="password" type="password"></form:input>
	 				
				</div>
				<form:errors path="password" cssclass="error" />
				<div class=names>		
				
					<span>Mail:</span> 	 
	 				<form:input name="mail" path="mail" id="mail" ></form:input>
	 				
				</div>
				<form:errors path="mail" cssclass="error" /></br>
				<input type="submit" value="Zarejestruj się" />
				</form:form>
		
				<form:form action="/login"  method="post" id="login">
				<div class=names>
					<span>Nazwa:</span>
					<input  name="name" path="name" id="name" ></input>
				</div>
				<div class=names>		
				
					<span>Hasło:</span> 	 
	 				<input name= "password" path="password" id="password" type="password"></input>
				</div>
				</br>
				<input type="submit" value="Zaloguj się" />
				</form:form>
				<div style="clear:both;"></div>
		</div>
	
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>