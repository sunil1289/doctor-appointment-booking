<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor List</title>
<style>
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 90%;
    border: 1px solid #ddd;
}
th {
    width: 140px;
    height: 25px;
    font-size: 20px;
    background-color: #2874A6;
    color: white;
}
td {
    width: 140px;
    height: 25px;
    font-size: 20px;
    text-align: center;
}
tr:nth-child(even) {
    background-color: yellow;
}
mark {
    background: orange;
    color: black;
}
.text-block {
    display: inline-block;
    margin-left: 20px;
    background-color: lightgreen;
    color: black;
    padding: 10px;
    border-radius: 30px;
    font-size: 20px;
}
#backButton {
    position: absolute;
    top: 20px;
    left: 20px;
    padding: 10px 20px;
    font-size: 18px;
    background-color: #2874A6;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
#backButton:hover {
    background-color: #1f5b7f;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/mark.js/7.0.0/jquery.mark.min.js"></script>

</head>
<body bgcolor="#ADD8E6">
    <%@ page import="beans.DocBean, daofiles.DoctorDao, java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!-- Back Button -->
    <button id="backButton" onclick="window.location.href='PatientHome.jsp';">Back to Appointment</button>

    <center>
        <h1 style="display: inline;">Doctor List</h1>
        <div class="text-block">
            <table style="width: 20px; height: 30px; border: 0;">
                <tr>
                    <td style="font-size: 20px; color: black;">Search </td>
                    <td><input type="text" id="searchInput" placeholder="search for specialty"></td>
                </tr>
            </table>
        </div>
    </center>
    <hr>
    <h2><p>Patient can choose DOCTOR ID for their Appointment</p></h2>
    
    <script>
    $(function() {
        // Search functionality with mark.js
        $("#searchInput").on("input", function() {
            var searchTerm = $(this).val();
            // Highlight the search term in the specialties column
            $("table").unmark().mark(searchTerm);
        });
    });
    </script>

    <%  
    List<DocBean> list = DoctorDao.getAllDoctors();  
    request.setAttribute("list", list);  

    %>  
    <div id="context">
    <center>
        <table>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Specialization</th>
                <th>Fees (RS)</th>
                <th>Timing</th>
                <th>Am/Pm</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${list}" var="d">  
                <tr>
                    <td>${d.getId()}</td>
                    <td>${d.getDocname()}</td>
                    <td>${d.getSpecialty()}</td>
                    <td>${d.getFees()}</td>
                    <td>${d.getDoctorTime()}</td>
                    <td>${d.getAmPm()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${d.status == 'booked'}">
                                <span style="color: red;">Booked</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color: green;">Available</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>  
            </c:forEach>  
        </table>
    </center>
    </div>
</body>
</html>
