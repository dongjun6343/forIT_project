<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<div class="main-content">
	<!-- Section : inner-header // adminAssign?command=adminAssignList  -->
	<section
	
		class="inner-header divider parallax layer-overlay overlay-dark-5"
		data-bg-img="/resources/images/newslist.jpg">
		<div class="container pt-70 pb-20">
			<!-- Section Content -->
			<div class="section-content">
				<div class="row">
					<div class="col-md-12">
						<h2 class="title text-white">오늘의과제</h2>
						<ol class="breadcrumb text-left text-white">
							<!--  <li><a href="/adminAssign?command=adminAssignList"></a></li> -->
						</ol>
					</div>

				</div>

			</div>
		</div>
	</section>

	<!-- main  -->
	<section>


		<div class="container">
			<dic class="row"> </dic>
			<div class="col-sm-9 blog-pull-right">
				<div class="row">
					<div class="col-md-12 mt-10">
						<h4 class="line-bottom mt-20 mb-20 text-theme-colored">오늘의과제
							게시판</h4>
						<hr>
						<div data-example-id="striped-table" class="bs-example">
							<table class="table table-striped">
								<thead>

									<tr>
										<th>번호</th>
										<th class="board-title-middle">제목</th>
										<th>작성자</th>
										<th class="hidden-xs">날짜</th>
										<th>조회수</th>
									</tr>
								</thead>
							
					<c:forEach items="${assignmentList}" var="AssignmentVO">

                     <tr>
                     <!-- AssignmentVO에 있는 변수랑 같아야함! -->
                        <td>${AssignmentVO.assNum}</td>
                        <!-- title를 눌렀을 때 상세보기 페이지로 이동 -->
                        <td><a href="/adminAssign?command=adminAssignDetail&assNum=${AssignmentVO.assNum}">${AssignmentVO.assTitle}</a></td>
                        <td>${AssignmentVO.adminId}</td>
                        <td>${AssignmentVO.assDate}</td>
                        <td>${AssignmentVO.assCount}</td>
                     </tr>
                     
                		  </c:forEach>

							</table>
						</div>
					</div>
				</div>


				<!-- 페이징 -->
				<div class="row">
					<div class="col-sm-12">
						<nav>
							<div class="text-center">
								<ul class="pagination theme-colored xs-pull-center mb-xs-40">
									<li><a href="#" aria-label="Previous"> <span
											aria-hidden="true">«</span>
									</a></li>
									<c:if test="${paging.pageNum > 1}">
										<li><a
											href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
									</c:if>

									<c:forEach begin="${paging.pageNum}"
										end="${paging.pageNum + 9}" var="idx">
										<li>
											<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
										</li>
									</c:forEach>

									<c:if test="${paging.lastPage == paging.pageNum}">
										<li><a
											href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
									</c:if>
									<li><a href="#" aria-label="Next"> <span
											aria-hidden="true">»</span>
									</a></li>
								</ul>
							</div>
						</nav>
					</div>
				</div>
				<div class="row">
					
					<!-- 등록폼  url 설정해주기-->
				
					<div class="col-md-2 mt-5 pull-right" >
							
				<button id='registerBtn' type="submit" class="btn btn-default" onclick="location.href='/admin/assignment/register.jsp'">
							
							<i class="fa fa-pencil" >등록</i> 
						</button>	
		
					</div>
					
				</div>
</div></div></section></div>
				<!-- 정렬 기준을 정하는 콤보박스 -->
				<!-- 항목 클릭 시, 페이지를 이동하는 콤보박스. 링크의 마지막에 listType의 value dd/da/vc를 넣어준다. -->
         
         
         
         
        
                              
                                 
         
               <!-- 검색 기능 콤보박스 -->
               <!-- 검색 텍스트필드 -->
 <script>
   var result = '${msg}';

   if (result == 'SUCCESS') {
      alert("처리가 완료되었습니다.");
   }
</script>        
<%@include file="../include/footer.jsp"%>