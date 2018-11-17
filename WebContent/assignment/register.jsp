<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
   <div class="row">
      <!-- left column -->
      <div class="col-md-12">
         <!-- general form elements -->
         <div class="box box-primary">
            <div class="box-header">
               <h3 class="box-title">오늘의과제 글쓰기</h3>
            </div>
            <!-- /.box-header -->

            <form role="form" method="post" action ="AssignmentServlet?command=Assignment_register">
               <div class="box-body">
                  <div class="form-group">
                     <label for="exampleInputEmail1">제목</label> <input type="text"
                        name='title' class="form-control" placeholder="Enter Title">
                  </div>
                  <div class="form-group">
                     <label for="exampleInputPassword1">내용</label>
                     <textarea class="form-control" name="content" rows="3"
                        placeholder="Enter ..."></textarea>
                  </div>
                  
         <%--          <div class="form-group">
                     <label for="exampleInputEmail1">Writer</label> <input type="text"
                        name="writer" class="form-control" value='${login.usid }'
                        readonly>
                  </div> --%>
                                    <div class="form-group">
                     <label for="exampleInputEmail1">작성자</label> <input type="text"
                        name="writer" class="form-control" placeholder="Enter Writer">
                  </div> 
               </div>
               <!-- /.box-body -->

               <div class="box-footer">
                   <!-- submit을 하게 되면 Action에서 지정된 페이지로 값이 전달이 되면서
                   		이동을 하게 됩니다. 그러므로 값을 전달한 폼은 사라짐.
                   		즉, submit시 현재.jsp=== 값 전달 및 페이지 이동 ===>work_act.jsp
                    -->
           <button type="submit" class="btn btn-primary">글쓰기</button> 
               </div>
            </form>


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