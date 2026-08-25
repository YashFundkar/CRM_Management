<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.ResultSet" %>

<%
ResultSet rs =
(ResultSet) request.getAttribute("notes");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Notes</title>
   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-dark px-3">
    <span class="navbar-brand">
        CRM SYSTEM
    </span>

    <a href="notes.html" class="btn btn-light">
        Add Note
    </a>
</nav>

<div class="container mt-4">
        <a href='notes.html' class='btn btn-secondary'>Back</a>

    <div class="card">

        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">All Notes</h4>
        </div>

        <div class="card-body p-0">

            <table class="table table-striped table-hover mb-0">

                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Customer Name</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date</th>
                        <th>Action</th>
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
                            <%= rs.getInt("note_id") %>
                        </td>

                        <td>
                            <%= rs.getString("customer_name") %>
                        </td>

                        <td>
                            <%= rs.getString("note_title") %>
                        </td>

                        <td>
                            <%= rs.getString("note_description") %>
                        </td>

                        <td>
                            <%= rs.getString("note_date") %>
                        </td>
                        <td>

							<form action="NOTES" method="post">
							
							    <input type="hidden"
							           name="action"
							           value="deleteNote">
							
							    <input type="hidden"
							           name="noteId"
							           value="<%= rs.getInt("note_id") %>">
							
							    <button type="submit"
							            class="btn btn-outline-danger btn-sm">
							        Delete
							    </button>
							
							</form>

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

</body>
</html>