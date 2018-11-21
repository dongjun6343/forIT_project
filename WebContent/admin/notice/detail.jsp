<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<div class="main-content">
   <!-- Section : inner-header -->
   <section
      class="inner-header divider parallax layer-overlay overlay-dark-5"
      data-bg-img="/resources/images/newslist.jpg">
      <div class="container pt-70 pb-20">
         <!-- Section Content -->
         <div class="section-content">
            <div class="row">
               <div class="col-md-12">
                  <h2 class="title text-white">공지사항 상세보기</h2>
                  <ol class="breadcrumb text-left text-white">
                     <li><a href="/">&nbsp;</a></li>
                  </ol>
               </div>
            </div>
         </div>
      </div>
   </section>


   <!-- main 
   폼넣기
중복되는부분빼고
    -->

  <form role="form" method="post" class="form-horizontal">
      <input type="hidden" name="validation">
      <div class="box-body box-form-custom">
         <div class="form-group input-short">
            <div class="container">
            <!-- /. side Menu  -->
               <div class="col-md-2 mt-30 hidden-xs hidden-sm">
                  <div class="sidebar sidebar-left mt-sm-30">
                     <div class="widget">
                        <h5 class="widget-title line-bottom">
                        <a href="introGroup">커뮤니티 등록</a>
                        </h5>
                     <div class="categories">
                        <ul class="list list-border angle-double-right">
                           <li><a href="/admin/register">공지사항 등록 </a></li>
                           <li><a href="/imgGallery/list">오늘의 과제 등록</a></li>
                        </ul>
                     </div>
                     </div>
                  </div>
               </div>
            
               <div class="col-md-9 blog-pull-right">
                  <div class="row">
                     <div style="height: 50px;">
                        <h4 class="line-bottom mt-20 mb-20 text-theme-colored">공지사항
                           상세보기</h4>
                     </div>


                     <!--  readonly="readonly" : 고칠수 없게 막는 부분 -->
                     <div class="form-group input-short">
                        <label for="exampleInputEmail1" class="col-sm-2 control-label">제목<span
                           class="must-mark"></span></label>
                        <div class="col-sm-10">
                        <!-- input type의 name중요시 -->
                           <input type="text" name="nTitle" class="form-control"
                             value="${noticeVO.nTitle}" readonly="readonly">
                        </div>
                     </div>

                     <div class="form-group input-short">
                        <label for="exampleInputEmail1" class="col-sm-2 control-label">내용<span
                           class="must-mark"></span></label>
                        <div class="col-sm-10">
                           <input type="text" name="nContent" class="form-control"
                             value="${noticeVO.nContent}" readonly="readonly"> <span id="nContent"></span>
                        </div>
                     </div>
                     
                    <div class="form-group input-short">
                        <label for="exampleInputEmail1" class="col-sm-2 control-label">작성자<span
                           class="must-mark"></span></label>
                        <div class="col-sm-10">
                           <input type="text" name="adminId" class="form-control"
                             value="${noticeVO.adminId}" readonly="readonly"> <span id="nContent"></span>
                        </div>
                     </div>
                     
                     


                     <!-- /.box-body -->

<div class="box-footer btn-group-center">
                   
                       <button id='modifyBtn' type="button" class="btn btn-default" 
					onclick="location.href='/adminNotice?command=adminNoticeModifyForm&nNum=${noticeVO.nNum}'">
							<i class="fas fa-clipboard-list">수정</i>
						</button>	  
                        
                <%--         <button id='deleteBtn' type="button" class="btn btn-default" 
					onclick="location.href='/adminAssign?command=adminAssignDelete&assNum=${AssignmentVO.assNum}'">
							<i class="fas fa-trash-alt">삭제</i>
						</button>
                 --%>       
					<button id='listBtn' type="button" class="btn btn-default" 
					onclick="location.href='/adminNotice?command=adminNoticeList'">
							<i class="fas fa-clipboard-list">글목록</i>
						</button>
                  </div>
               </div>
            </div>   
         </div>
      </div>
   </form>
</div>


<!-- /.content -->


<script>
   var result = '${msg}';

   if (result == 'SUCCESS') {
      alert("처리가 완료되었습니다.");
   }
</script>
<!-- 스크립트 메세지 -->

<!-- 페이지이동 스트립트 -->

<!-- <script>
   $(document).ready(
         function() {

            $('#modifyBtn').on(
                  "click",
                  function(event) {

                     self.location = "/admin/assignment/modify.jsp"
                           + '${pageMaker.makeQuery(1)}'
                           + "&modifyBtn="
                           + $("#searchType option:selected").val()
                           + "&keyword=" + $('#keywordInput').val();

                  });

            $('#newBtn').on("click", function(evt) {

               self.location = "/admin/assignment/register.jsp";

            });

         });
</script> -->

<!-- 검색버튼, 등록버튼 스크립트 -->



<form>
   <!--  id="jobForm"  -->
   <input type='hidden' name="page" value='${pageMaker.cri.perPageNum}'>
   <input type='hidden' name="perPageNum" value='${pageMaker.cri.perPageNum}'>

</form>






<%@include file="../include/footer.jsp"%>