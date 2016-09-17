<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<ul class="pager">
					<li
						class="previous<c:if test="${!page.hasPrevious}"> disabled</c:if>"><a
						href="?pageIndex=${page.pageIndex-1}&pageSize=${page.pageSize}&${searchParams}" <c:if test="${!page.hasPrevious}">onclick="return false"</c:if> >
						←前一页</a></li>
					<li>${page.pageIndex}</li>
					<li class="next<c:if test="${!page.hasNext}"> disabled</c:if>"><a
						href="?pageIndex=${page.pageIndex+1}&pageSize=${page.pageSize}&${searchParams}" <c:if test="${!page.hasNext}" >onclick="return false"</c:if> >
						下一页→</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
-->
<div class="pagination pagination-centered">
	<ul>
		<li	class="<c:if test="${!page.hasPrevious}"> disabled</c:if>"><a
			href="?pageIndex=${page.pageIndex-1}&pageSize=${page.pageSize}&${searchParams}" <c:if test="${!page.hasPrevious}">onclick="return false"</c:if> >
			←前一页</a></li>
		<li class="active">
			<a href="#">${page.pageIndex}</a>
		</li>
		<li class="<c:if test="${!page.hasNext}"> disabled</c:if>"><a
			href="?pageIndex=${page.pageIndex+1}&pageSize=${page.pageSize}&${searchParams}" <c:if test="${!page.hasNext}" >onclick="return false"</c:if> >
			下一页→</a></li>
	</ul>
</div>
