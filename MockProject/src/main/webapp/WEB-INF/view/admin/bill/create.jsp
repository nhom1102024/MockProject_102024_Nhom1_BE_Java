<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="Tuấn Kiệt - Dự án laptopshop" />
        <meta name="author" content="Tuấn Kiệt" />
        <title>User Page</title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      </head>

      <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp" />
        <div id="layoutSidenav">
          <jsp:include page="../layout/sidebar.jsp" />
          <div id="layoutSidenav_content">
            <main>
              <div class="container-fluid px-4">
                <h1 class="mt-4">Manage Bills</h1>
                <ol class="breadcrumb mb-4">
                  <li class="breadcrumb-item active">
                    <a href="/admin">Dashboard</a>
                  </li>
                  <li class="breadcrumb-item active">
                    <a href="/admin/bill">Bills</a>
                  </li>
                  <li class="breadcrumb-item active">Create</li>
                </ol>
                <div class="mt-5">
                  <div class="row">
                    <div class="col-md-6 col-12 mx-auto">
                      <h3>Create a bill</h3>
                      <hr />
                      <!-- Use information from form jstl add to model and then transfer it to controller -->
                      <form:form method="post" action="/admin/bill/create" modelAttribute="newBill" class="row">
                        <!-- Show list of customer -->
                        <div class="mb-3 col-12">
                          <label class="form-label">Customer:</label>
                          <form:select class="form-select" path="customer.fullName">
                            <c:forEach var="customer" items="${customers}">
                              <form:option value="${customer.fullName}">${customer.fullName}</form:option>
                            </c:forEach>
                          </form:select>
                        </div>
                        <!-- Show list of service -->
                        <div class="mb-3 col-12">
                          <label class="form-label">Service:</label>
                          <form:select class="form-select" path="service.nameService">
                            <c:forEach var="service" items="${services}">
                              <form:option value="${service.nameService}">${service.nameService}</form:option>
                            </c:forEach>
                          </form:select>
                        </div>
                        <div class="mb-3 col-12 col-md-6">
                          <label class="form-label">Amount:</label>
                          <form:input type="text" class="form-control" path="amount" />
                        </div>
                        <div class="mb-3 col-12 col-md-6">
                          <label class="form-label">DueDateTime:</label>
                          <form:input type="datetime-local" class="form-control" path="dueDateTime" />
                        </div>
                        <div class="mb-3 col-12 col-md-6">
                          <label class="form-label">CreatedDateTime:</label>
                          <form:input type="datetime-local" class="form-control" path="createdDateTime" />
                        </div>

                        <div class="mb-3 col-12 col-md-6">
                          <label class="form-label">LateFee:</label>
                          <form:input type="text" class="form-control" path="lateFee" />
                        </div>
                        <div class="mb-3 col-12 col-md-6">
                          <label class="form-label">Status:</label>
                          <form:select class="form-select" path="status">
                            <form:option value="Paid">Paid</form:option>
                            <form:option value="Unpaid">Unpaid</form:option>
                          </form:select>
                        </div>

                        <div class="col-12 mb-5">
                          <button type="submit" class="btn btn-primary">
                            Create
                          </button>
                        </div>
                      </form:form>
                    </div>
                  </div>
                </div>
              </div>
            </main>
            <jsp:include page="../layout/footer.jsp" />
          </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
          crossorigin="anonymous"></script>
        <script src="/js/scripts.js"></script>
      </body>

      </html>