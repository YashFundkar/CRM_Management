<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.ResultSet" %>

<%
ResultSet rs =
(ResultSet) request.getAttribute("appointments");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRM System - My Appointments</title>
    <link rel="stylesheet" href="customer-style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
               <link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">        
          
</head>

<body class="bg-light">

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

        <li class="nav-item">
            <a href="CUSTOMER_DASHBOARD"
               class="nav-link text-dark">
               🏠 Dashboard
            </a>
        </li>

        <li class="nav-item active">
            <a href="CUSTOMER_APPOINTMENT"
               class="nav-link text-dark ">
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

            <div class="col-md-10 p-4">

                <!-- Page Header -->

                <div class="card border mb-4">

                    <div class="card-body d-flex justify-content-between align-items-center">

                        <div>

                            <h4 class="fw-bold mb-1">
                                My Appointments
                            </h4>

                            <p class="text-muted mb-0">
                                View and manage your appointments.
                            </p>

                        </div>

                        <button class="btn btn-primary"
                                data-bs-toggle="modal"
                                data-bs-target="#bookModal">

                            + Book Appointment

                        </button>

                    </div>

                </div>

                <!-- Filter Section -->

                <div class="card border mb-4">

                    <div class="card-body">

                        <div class="row g-3">

                            <div class="col-md-4">

                                <select class="form-select"
                                        name="statusFilter">

                                    <option value="">
                                        All Status
                                    </option>

                                    <option value="scheduled">
                                        Scheduled
                                    </option>

                                    <option value="completed">
                                        Completed
                                    </option>

                                    <option value="cancelled">
                                        Cancelled
                                    </option>

                                </select>

                            </div>

                            <div class="col-md-4">

                                <input type="date"
                                       class="form-control"
                                       name="dateFilter">

                            </div>

                        </div>

                    </div>

                </div>

                <!-- Appointment Table -->

                <div class="bg-primary text-white px-3 py-2">

                    Appointments

                </div>

                <div class="card border-top-0 rounded-0">

                    <table class="table table-hover mb-0">

                        <thead>

                            <tr>

                                <th>#</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Branch</th>
                                <th>Status</th>
                                <th>Action</th>

                            </tr>

                        </thead>

                        <tbody>

                            <%
                            int i = 1;

                            if(rs != null)
                            {
                                while(rs.next())
                                {
                            %>

                            <tr>

                                <td>
                                    <%= i++ %>
                                </td>

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

                                <td>

                                    <button class="btn btn-primary btn-sm">

                                        View

                                    </button>

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

    <!-- Book Appointment Modal -->

    <div class="modal fade"
         id="bookModal"
         tabindex="-1">

        <div class="modal-dialog">

            <div class="modal-content">

                <div class="modal-header bg-primary text-white">

                    <h5 class="modal-title">
                        Book Appointment
                    </h5>

                    <button type="button"
                            class="btn-close btn-close-white"
                            data-bs-dismiss="modal">
                    </button>

                </div>

                <div class="modal-body">

                    <form action="BOOK_APPOINTMENT"
                          method="post">

                        <div class="mb-3">

                            <label class="form-label">
                                Date
                            </label>

                            <input type="date"
                                   class="form-control"
                                   name="date"
                                   required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Time
                            </label>

                            <input type="time"
                                   class="form-control"
                                   name="time"
                                   required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Branch
                            </label>

                            <select class="form-select"
                                    name="branch"
                                    required>

                                <option value="" selected disabled>
                                    Select Branch
                                </option>

                                <option value="SHEGAON">
                                    SHEGAON
                                </option>

                                <option value="PUNE">
                                    PUNE
                                </option>

                                <option value="AKOLA">
                                    AKOLA
                                </option>

                            </select>

                        </div>

                        <div class="d-grid">

                            <button type="submit"
                                    class="btn btn-primary">

                                Book Appointment

                            </button>

                        </div>

                    </form>

                </div>

            </div>

        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>