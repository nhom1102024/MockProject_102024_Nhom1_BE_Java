<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="utf-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
          <meta name="description" content="Management Apartment" />
          <meta name="author" content="group1" />
          <title>Bill Page</title>
          <link href="/css/styles.css" rel="stylesheet" />
          <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
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
                    <li class="breadcrumb-item active">Bills</li>
                  </ol>
                  <div>
                    <div class="mt-5">
                      <div class="row">
                        <div class="col-12 mx-auto">
                          <div class="d-flex justify-content-between">
                            <h3>Table Bill</h3>
                            <a href="/admin/bill/create" class="btn btn-primary">Create a bill</a>
                          </div>

                          <hr />
                          <table class="table table-hover table-bordered">
                            <thead>
                              <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Customer Name</th>
                                <th scope="col">Service Name</th>
                                <th scope="col">Amount</th>
                                <th scope="col">DueDateTime</th>
                                <th scope="col">CreatedDateTime</th>
                                <th scope="col">LateFee</th>
                                <th scope="col">Status</th>
                                <th scope="col">Action</th>
                              </tr>
                            </thead>
                            <tbody>
                              <!-- Use forEach from jstl to list all bills from model is transferred by controller -->
                              <c:forEach var="bill" items="${bills}">
                                <tr>
                                  <th scope="row">${bill.bill_id}</th>
                                  <td>${bill.customer.fullName}</td>
                                  <td>${bill.service.nameService}</td>
                                  <td>
                                    <fmt:formatNumber type="number" value="${bill.amount}" />
                                    $
                                  </td>
                                  <td>${bill.dueDateTime}</td>
                                  <td>${bill.createdDateTime}</td>
                                  <td>
                                    <fmt:formatNumber type="number" value="${bill.lateFee}" />
                                    $
                                  </td>
                                  <td>${bill.status}</td>
                                  <td>
                                    <a href="/admin/bill/update/${bill.bill_id}" class="btn btn-warning mx-2">Update</a>
                                    <a href="/admin/bill/delete/${bill.bill_id}" class="btn btn-danger">Delete</a>
                                  </td>
                                </tr>
                              </c:forEach>
                            </tbody>
                          </table>
                        </div>
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