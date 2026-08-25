<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Profile</title>
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

        <li class="nav-item active">
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

                <!-- Header Card -->

                <div class="card border mb-4">

                    <div class="card-body">

                        <h4 class="fw-bold mb-1">
                            My Profile
                        </h4>

                        <p class="text-muted mb-0">
                            View your profile information.
                        </p>

                    </div>

                </div>

                <!-- Profile Card -->

               <div class="card shadow border-0 mx-auto" style="max-width:500px;border-radius:20px;overflow:hidden;">

    <!-- Card Header -->
    <div class="text-center text-white py-4"
         style="background:linear-gradient(135deg,#06b6d4,#3b82f6);">

        <img src="https://img.icons8.com/color/96/user-male-circle--v1.png"
             width="90"
             class="rounded-circle border border-3 border-white">

        <h4 class="mt-3 mb-0">
            <%= request.getAttribute("name") %>
        </h4>

        <small>CRM Customer</small>

    </div>

    <!-- Card Body -->
    <div class="card-body p-4">

        <table class="table table-borderless mb-0">

            <tr>
                <th>Name</th>
                <td><%= request.getAttribute("name") %></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= request.getAttribute("email") %></td>
            </tr>

            <tr>
                <th>Phone</th>
                <td><%= request.getAttribute("phone") %></td>
            </tr>

            <tr>
                <th>Branch</th>
                <td><%= request.getAttribute("branch") %></td>
            </tr>

        </table>

    </div>

    <!-- Footer -->
    <div class="text-center py-2 bg-light">
        <small class="text-muted">
            CRM Customer Identification Card
        </small>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>