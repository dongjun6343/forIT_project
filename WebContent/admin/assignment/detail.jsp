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
                  <h2 class="title text-white">공지사항</h2>
                  <ol class="breadcrumb text-left text-white">
                     <li><a href="/">&nbsp;</a></li>
                  </ol>
               </div>
            </div>
         </div>
      </div>
   </section>
<!-- Main content -->
<section class="content">
   <div class="row">
      <!-- left column -->
      <div class="col-md-12">
         <!-- general form elements -->
         <div class="box box-primary">
            <div class="box-header">
               <h3 class="box-title">상세보기</h3>
            </div>
            <!-- /.box-header -->

<!-- 원래 주석 X 
<form role="form" action="modifyPage" method="post">

   <input type='hidden' name='bno' value="${boardVO.bno}"> <input
      type='hidden' name='page' value="${cri.page}"> <input
      type='hidden' name='perPageNum' value="${cri.perPageNum}">
   <input type='hidden' name='searchType' value="${cri.searchType}">
   <input type='hidden' name='keyword' value="${cri.keyword}">

</form>
 -->
<form role="form" action="adminAssign" method="post"> 
 			<!--value의 AssignmentVO는 AdminAssignDetailAction에 request.setAttribute("AssignmentVO", aVo);과 동일. -->
            <div class="box-body">
               <div class="form-group">
                  <label for="exampleInputEmail1">제목</label> <input type="text"
                     name='assTitle' class="form-control" value="${AssignmentVO.assTitle}"
                     readonly="readonly">
               </div>
               
         		 <div class="form-group">
                  <label for="exampleInputEmail1">내용</label> <input type="text"
                     name='assContent' class="form-control" value="${AssignmentVO.assContent}"
                     readonly="readonly">
               </div> 
               
               
             <!--    <div class="form-group">
                  <label for="exampleInputPassword1">내용</label>
                  <textarea class="form-control" name="assignContent" rows="3" cols = "30" 
                     readonly="readonly"></textarea>
              
                     
               </div>   -->
               
               
               <div class="form-group">
                  <label for="exampleInputEmail1">작성자</label> <input type="text"
                     name="adminId" class="form-control" value="${AssignmentVO.adminId}"
                     readonly="readonly">
               </div>
            </div>
            <!-- /.box-body -->

            <div class="box-footer">
               <button type="submit" class="btn btn-warning">수정</button>
               <button type="submit" class="btn btn-danger">제거</button>
               <button type="submit" class="btn btn-primary">목록으로</button>
            </div>

</form>
<script>
   $(document).ready(function() {

      var formObj = $("form[role='form']");

      console.log(formObj);
      

      $(".btn-warning").on("click", function() {
         formObj.attr("action", "/adminAssign");
         formObj.attr("method", "get");
         formObj.submit();
      });

      $(".btn-danger").on("click", function() {
         formObj.attr("action", "/sboard/removePage");
         formObj.submit();
      });

      $(".btn-primary").on("click", function() {
         formObj.attr("method", "get");
         formObj.attr("action", "/adminAssign");
         formObj.submit();
      });

   });
</script>




         </div>
         <!-- /.box -->
      </div>
      <!--/.col (left) -->

   </div>
   <!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>