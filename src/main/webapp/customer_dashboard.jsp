<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.ResultSet" %>

<%
ResultSet rs = (ResultSet) request.getAttribute("recentAppointments");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="customer-style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
          
          <link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">        
</head>

<body>

<!-- Navbar -->

<nav class="navbar customer-navbar px-4 py-3 shadow">

    <div class="container-fluid">

        <!-- Logo -->
        <div class="d-flex align-items-center">

            <div class="bg-white rounded p-2 me-3">
                <i class="bi bi-person-workspace text-primary fs-4"></i>
            </div>

            <div>
                <h4 class="text-white fw-bold m-0">
                    CUSTOMER PORTAL
                </h4>
                <small class="text-light">
                    Manage Your Activities
                </small>
            </div>

        </div>

        <!-- Center Search -->
        <div style="width:300px;">

            <div class="input-group">

                <span class="input-group-text border-0 bg-white">
                    <i class="bi bi-search"></i>
                </span>

                <input type="text"
                       class="form-control border-0"
                       placeholder="Search...">

            </div>

        </div>

        <!-- Right Side -->
        <div class="d-flex align-items-center">

            <i class="bi bi-bell-fill text-white fs-5 mx-3"></i>

            <span class="text-white fw-semibold me-3">
                Welcome,
                <%= session.getAttribute("customerName") %>
            </span>

            <img src="https://img.icons8.com/color/96/user-male-circle--v1.png"
                 width="45"
                 class="rounded-circle border border-2 border-light">

        </div>

    </div>

</nav>

<div class="container-fluid">

    <div class="row">

        <!-- Sidebar -->

       <div class="col-2 bg-white border-end min-vh-100 pt-4 px-0">

    <ul class="nav flex-column">

        <li class="nav-item active">
            <a href="CUSTOMER_DASHBOARD"
               class="nav-link text-dark">
               🏠 Dashboard
            </a>
        </li>

        <li class="nav-item">
            <a href="CUSTOMER_APPOINTMENT"
               class="nav-link text-dark">
               📅 Appointments
            </a>
        </li>

        <li class="nav-item">
            <a href="CUSTOMER_NOTES"
               class="nav-link text-dark">
               📝 Notes
            </a>
        </li>

        <li class="nav-item">
            <a href="CUSTOMER_PROFILE"
               class="nav-link text-dark">
               👤 Profile
            </a>
        </li>

        <li class="nav-item mt-4">
            <a href="LOGOUT"
               class="nav-link text-dark">
               🚪 Logout
            </a>
        </li>

    </ul>

</div>

        <!-- Main Content -->

        <div class="col-lg-10 p-4">

            <!-- Welcome Card -->

            <div class="card hero-card mb-4">

                <div class="card-body p-4">

                    <h2>
                        Welcome Back 👋
                    </h2>

                    <p class="mb-0">
                        Manage your appointments, notes and profile from one place.
                    </p>

                </div>

            </div>

            <!-- Statistics -->

            <div class="row g-4 mb-4">

                <div class="col-md-6 col-xl-3">

                    <div class="card stats-card p-3">

                        <h3>
                            <%= request.getAttribute("appointmentCount") %>
                        </h3>

                        <p class="text-muted mb-0">
                            My Appointments
                        </p>

                    </div>

                </div>

                <div class="col-md-6 col-xl-3">
				    <div class="card stats-card p-3">
				        <h3>3</h3>
				        <p class="text-muted mb-0">
				            Branches
				        </p>
				    </div>
				</div>
				
				<div class="col-md-6 col-xl-3">
				    <div class="card stats-card p-3">
				        <h3>✓</h3>
				        <p class="text-muted mb-0">
				            Profile Active
				        </p>
				    </div>
				</div>

                <div class="col-md-6 col-xl-3">

                    <div class="card stats-card p-3">

                        <h3> <%= request.getAttribute("noteCount") %></h3>

                        <p class="text-muted mb-0">
                            My Notes
                        </p>

                    </div>

                </div>

            </div>

            <!-- Quick Actions -->

            <div class="row g-4 mb-4">

                <div class="col-md-4">

                    <div class="card section-card">

                        <div class="card-body text-center">

                            <i class="fa-solid fa-calendar-plus fa-2x text-primary mb-3"></i>

                            <h5>
                                New Appointment
                            </h5>

                            <p class="text-muted">
                                Schedule a new appointment.
                            </p>

                            <a href="CUSTOMER_APPOINTMENT"
                               class="btn btn-primary">

                                Book Now

                            </a>

                        </div>

                    </div>

                </div>

                <div class="col-md-4">

                    <div class="card section-card">

                        <div class="card-body text-center">

                            <i class="fa-solid fa-note-sticky fa-2x text-warning mb-3"></i>

                            <h5>
                                Notes
                            </h5>

                            <p class="text-muted">
                                Manage your personal notes.
                            </p>

                            <a href="CUSTOMER_NOTES"
                               class="btn btn-warning">

                                View Notes

                            </a>

                        </div>

                    </div>

                </div>

                <div class="col-md-4">

                    <div class="card section-card">

                        <div class="card-body text-center">

                            <i class="fa-solid fa-user fa-2x text-success mb-3"></i>

                            <h5>
                                Profile
                            </h5>

                            <p class="text-muted">
                                Update your information.
                            </p>

                            <a href="CUSTOMER_PROFILE"
                               class="btn btn-success">

                                View Profile

                            </a>

                        </div>

                    </div>

                </div>

            </div>

            <!-- Recent Appointments -->

            <div class="card section-card">

                <div class="card-header bg-white">

                    <h5 class="section-title mb-0">
                        Recent Appointments
                    </h5>

                </div>

                <div class="card-body">

                    <table class="table table-hover align-middle">

                        <thead>

                        <tr>

                            <th>Date</th>

                            <th>Time</th>

                            <th>Branch</th>

                            <th>Status</th>

                        </tr>

                        </thead>

                        <tbody>

                        <%
                        if(rs != null)
                        {
                            while(rs.next())
                            {
                        %>

                        <tr>

                            <td>
                                <%= rs.getString("ap_date") %>
                            </td>

                            <td>
                                <%= rs.getString("ap_time") %>
                            </td>

                            <td>
                                <%= rs.getString("ap_branch") %>
                            </td>

                            <td>

                                <span class="badge bg-primary">
                                    Scheduled
                                </span>

                            </td>

                        </tr>

                        <%
                            }
                        }
                        %>

                        </tbody>

                    </table>

                </div>

            </div>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>