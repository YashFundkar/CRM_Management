<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
     <link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">   
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="style.css" />
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
        <div class="col-md-2 bg-white vh-100 p-3 shadow ">

            <a href="DASHBOARD" class="list-group-item">📊 Dashboard</a>
			<a href="customer.html" class="list-group-item">👥 Customers</a>
			<a href="appointment.html" class="list-group-item">📅 Appointments</a>
			<a href="notes.html" class="list-group-item">📝 Notes</a>
			<a href="BRANCH" class="list-group-item active">🏢 Branch</a>
			<a href="report.jsp" class="list-group-item">📈 Report</a>
			<a href="LOGOUT" class="list-group-item">🚪 Logout</a>

        </div>

      <div class="col-md-10 p-4">

        <div class="row g-5">

          <div class="col-md-4">
            <div class="card shadow p-4 card-s">
              <div class="card-body">
                <h2>Shegaon</h2>
                <h5>Appointment : <%= request.getAttribute("shegaonAppointment") %></h5>
                <h5>Customers :<%= request.getAttribute("shegaonCustomers") %></h5>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card shadow p-4 card-s">
              <div class="card-body">
                <h2>PUNE</h2>
                <h5>Appointment : <%= request.getAttribute("PUNEAppointment") %></h5>
                <h5>Customers : <%= request.getAttribute("PUNECustomer") %></h5>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card shadow p-4 card-s">
              <div class="card-body">
                <h2>Akola</h2>
                <h5>Appointment : <%= request.getAttribute("akolaAppointment") %></h5>
                <h5>Customers :<%= request.getAttribute("akolaCustomer") %></h5>
              </div>
            </div>
          </div>

          

        </div ">
        <div class="card mt-5 p-3 bg-dark text-light">
         <h2>Branch Management</h2>
        </div>

        <div class="row g-5">
          <div class="col-md-12">
           <table class="table table-striped">
             <thead>
                <tr>
                  <th>Branch</th>
                  <th>City</th>
                  <th>Manager</th>
                  <th>Status</th>
                </tr>
             </thead>
             <tbody>
              <tr>
                <td>Shegaon</td>
                <td>Shegaon</td>
                <td>Jay</td>
                <td>Active</td>
              </tr>

              <tr>
                <td>PUNE</td>
                <td>PUNE</td>
                <td>viru</td>
                <td>Active</td>
              </tr>

              <tr>
                <td>Akola</td>
                <td>Akola</td>
                <td>Amit</td>
                <td>inactive</td>
              </tr>

             </tbody>
           </table>
        </div>
       
          <div class=" text-center">
            <a href="addbranch.html"><button class="btn btn-success ">Add New Branch</button></a>

          </div>

       
        </div>
      </div>
      <div class="text-center">
        <footer ><p>CRM Management System
           Developed by <b>Yash Fundkar</b>
           2026</p></footer>
    </div>
    </div>
  </body>
</html>
