<%@ page language="java" pageEncoding="UTF-8"%>
<!-- Header -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark mt-3 mb-3">
		<ul class="navbar-nav mr-auto">
      		<li class="nav-item active">
        		<a class="nav-link" href="/home.hta">홈</a>
      		</li>
      		<c:if test="${not empty loginUser }">
     		<li class="nav-item">
        		<a class="nav-link" href="/todo/list.hta">할일 관리</a>
      		</li>
      		</c:if>
    	</ul>
    	<ul class="navbar-nav navbar-dark bg-dark justify-content-end">
    	<c:choose>
    		<c:when test="${empty loginUser }">
      		<li class="nav-item">
        		<a class="nav-link" href="/register.hta" onclick="openRegisterformModal(event)">회원가입</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="/login.hta" onclick="openLoginformModal(event)">로그인</a>
      		</li>
      		</c:when>
      		<c:otherwise>
      		<li class="nav-item">
        		<a class="nav-link" href="/logout.hta">로그아웃</a>
      		</li>
      		</c:otherwise>
      	</c:choose>
    	</ul>
	</nav>