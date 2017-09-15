<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="Baza">
	<jsp:body>
	<t:personList></t:personList>
		<div id="text">
			<c:forEach var="person" items="${searchingResult}">
				<div class="person-item">
					<h3><a href="<c:url value="/profiles/person-${person.id}"/>">${person.nick }</a></h3>
					${person.name} ${person.surname}
					
				</div>
			</c:forEach>	
			
		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate></html>