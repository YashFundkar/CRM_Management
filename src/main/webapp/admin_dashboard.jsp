<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!doctype html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>CRM Dashboard</title>

   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet">
      
   <link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">   

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="style.css">

</head>

<body>

<nav class="navbar px-4 py-3 shadow"
     style="background:linear-gradient(90deg,#0f172a,#1e293b);">

    <div class="d-flex align-items-center">

        <div class="bg-info rounded p-2 me-3">
            <i class="bi bi-graph-up-arrow text-white fs-4"></i>
        </div>

        <div>
            <h4 class="text-white m-0 fw-bold">
                CRM SYSTEM
            </h4>
            <small class="text-light">
                Manage Customers Efficiently
            </small>
        </div>

    </div>

	    <div class="mx-auto" style="width:400px;">
	
	    <div class="input-group shadow-sm">
	
	        <span class="input-group-text bg-light border-0">
	            <i class="bi bi-search"></i>
	        </span>
	
	        <input type="text"
	               class="form-control bg-light border-0"
	               placeholder="Search anything...">
	
	    </div>
	
	   </div>
    <div class="ms-auto d-flex align-items-center">

        <i class="bi bi-house-door-fill text-white fs-5 mx-3"></i>
        <i class="bi bi-bell-fill text-white fs-5 mx-3"></i>
        <i class="bi bi-gear-fill text-white fs-5 mx-3"></i>

        <img src="https://img.icons8.com/color/96/user-male-circle--v1.png"
             width="45"
             class="ms-3">
    </div>

</nav>


    <div class="container-fluid">

        <div class="row">

            <!-- Sidebar -->

            <div class="col-md-2 bg-white vh-100 p-3 shadow">

                <div class="list-group">

                    <a href="DASHBOARD" class="list-group-item active">📊 Dashboard</a>
                    <a href="customer.html" class="list-group-item">👥 Customers</a>
                    <a href="appointment.html" class="list-group-item">📅 Appointments</a>
                    <a href="notes.html" class="list-group-item">📝 Notes</a>
                    <a href="BRANCH" class="list-group-item">🏢 Branch</a>
                    <a href="report.jsp" class="list-group-item">📈 Report</a>
                    <a href="LOGOUT" class="list-group-item">🚪 Logout</a>

                </div>

            </div>

            <!-- Main Content -->
<!-- Main Content -->
<div class="col-md-10 p-4 bg-light">

    <!-- Welcome Banner -->
   <div class="card welcome-banner shadow-lg mb-4">
         

        <div class="card-body p-3">

            <div class="d-flex justify-content-between align-items-center">

                <div>
                    <h2 class="fw-bold">Welcome Admin 👋</h2>
                    <p class="mb-0">
                        Here's what's happening with your CRM today.
                    </p>
                </div>
            </div>

        </div>

    </div>

    <!-- Statistics Cards -->

    <div class="row g-4 mb-4">

        <div class="col-md-3">

            <div class="card stat-card border-0 shadow-sm h-100">

                <div class="card-body text-center">

                    <h4 class="text-dark"> Customers</h4>

                    <h1 class="fw-bold">
                        <%= request.getAttribute("customerCount") %>
                    </h1>

                </div>

            </div>

        </div>

        <div class="col-md-3">

            <div class="card stat-card border-0 shadow-sm h-100">

                <div class="card-body text-center">

                    <h4 class="text-dark"> Appointments</h4>

                    <h1 class="fw-bold">
                        <%= request.getAttribute("appointmentCount") %>
                    </h1>

                </div>

            </div>

        </div>

        <div class="col-md-3">

            <div class="card stat-card border-0 shadow-sm h-100">

                <div class="card-body text-center">

                    <h4 class="text-dark"> Notes</h4>

                    <h1 class="fw-bold">
                        <%= request.getAttribute("notesCount") %>
                    </h1>

                </div>

            </div>

        </div>

        <div class="col-md-3">
           <div class="card stat-card border-0 shadow-sm h-100">
              <div class="card-body text-center">

                    <h4 class="text-dark"> Branches</h4>
                     <h1 class="fw-bold">3</h1>

                </div>
             </div>
         </div>
     </div>

    <!-- Quick Actions + Recent Activities -->

    <div class="row">
   
    <div class="col-md-6">

        <div class="card border-0 shadow-sm">

            <div class="card-header bg-white">
                <h5 class="mb-0">⚡ Quick Actions</h5>
            </div>

            <div class="card-body">

                <div class="row g-3">

                    <div class="col-6">
                        <a href="customer.html"
                           class="btn btn-light border w-100 p-3">
                            👥 <br>
                            Add Customer
                        </a>
                    </div>

                    <div class="col-6">
                        <a href="appointment.html"
                           class="btn btn-light border w-100 p-3">
                            📅 <br>
                            Appointment
                        </a>
                    </div>

                    <div class="col-6">
                        <a href="notes.html"
                           class="btn btn-light border w-100 p-3">
                            📝 <br>
                            Notes
                        </a>
                    </div>

                    <div class="col-6">
                        <a href="report.jsp"
                           class="btn btn-light border w-100 p-3">
                            📊 <br>
                            Reports
                        </a>
                    </div>

                </div>

            </div>

        </div>

    </div>

    <!-- Upcoming Appointments -->
    <div class="col-md-6">

        <div class="card border-0 shadow-sm">

            <div class="card-header bg-white">
                <h5 class="mb-0">📅 Upcoming Appointments</h5>
            </div>

            <div class="card-body">

                <%
                List<String> upcoming =
                        (List<String>) request.getAttribute("upcoming");

                if (upcoming != null && !upcoming.isEmpty()) {

                    for (String app : upcoming) {
                %>

                    <div class="border-bottom py-2">
                        <%= app %>
                    </div>

                <%
                    }

                } else {
                %>

                    <p class="text-muted mb-0">
                        No upcoming appointments
                    </p>

                <%
                }
                %>

            </div>

        </div>

    </div>

</div>

</div>
    <!-- Footer -->

    <footer class="bg-dark text-light text-center p-3 mt-4">

        <h5>CRM Management System</h5>

        <p class="mb-0">

            Developed By <b>Yash Fundkar</b>

        </p>

    </footer>

</body>

</html>