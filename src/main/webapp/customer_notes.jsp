<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.ResultSet" %>

<%
ResultSet rs =
(ResultSet) request.getAttribute("notes");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Notes</title>
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

        <li class="nav-item active">
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

                    <div class="card-body">

                        <h4 class="fw-bold mb-1">
                            My Notes
                        </h4>

                        <p class="text-muted mb-0">
                            Create and manage your personal notes.
                        </p>

                    </div>

                </div>

                <!-- Add Note Form -->

                <div class="card border mb-4">

                    <div class="card-header bg-primary text-white">

                        Add Note

                    </div>

                    <div class="card-body">

                        <form action="ADD_CUSTOMER_NOTE"
                              method="post">

                            <div class="mb-3">

                                <label class="form-label">
                                    Note Title
                                </label>

                                <input type="text"
                                       name="noteTitle"
                                       class="form-control"
                                       required>

                            </div>

                            <div class="mb-3">

                                <label class="form-label">
                                    Description
                                </label>

                                <textarea
                                    name="noteDescription"
                                    class="form-control"
                                    rows="4"
                                    required></textarea>

                            </div>

                            <div class="mb-3">

                                <label class="form-label">
                                    Date
                                </label>

                                <input type="date"
                                       name="noteDate"
                                       class="form-control"
                                       required>

                            </div>

                            <button type="submit"
                                    class="btn btn-primary">

                                Add Note

                            </button>

                        </form>

                    </div>

                </div>

                <!-- Notes Table -->

                <div class="bg-primary text-white px-3 py-2">

                    My Notes

                </div>

                <div class="card border-top-0 rounded-0">

                    <table class="table table-hover mb-0">

                        <thead>

                            <tr>

                                <th>Title</th>
                                <th>Description</th>
                                <th>Date</th>

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
                                    <%= rs.getString("note_title") %>
                                </td>

                                <td>
                                    <%= rs.getString("note_description") %>
                                </td>

                                <td>
                                    <%= rs.getString("note_date") %>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>