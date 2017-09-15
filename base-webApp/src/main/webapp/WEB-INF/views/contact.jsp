<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:pageTemplate title="Baza">
	<jsp:body>
	<t:mainTag></t:mainTag>

		<div id="text">
		<div class="names">
		</br>
			<font size="5">W razie problemów proszę o kontakt na mail: izowirus@gmail.com</font>
				
			</div>
		<div class ="cat">
		<img src="/resources/cat.jpg"alt="cat" id="cat" style="max-width: 400px;">
		</div>

		</div>
		<div style="clear:both;"></div>
	</jsp:body>
	
</t:pageTemplate>