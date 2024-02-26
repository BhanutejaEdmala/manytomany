<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <style>
        .button-container {
            text-align: center; /* Align buttons to the center */
            margin-bottom: 20px; /* Add some space at the bottom */
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .button-container form {
            display: inline-block; /* Make forms display inline */
            margin: 0 5px; /* Add some spacing between buttons */
        }
    </style>
</head>
<body>
<div class="button-container">
    <div class="button-container">
    </div>
</div>
<table>
    <thead>
        <tr>
            <th>Course Id</th>
            <th>Course Name</th>
            <th>Update Course</th>
            <th>Students</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${sl}" var="course">
                       <tr>
                           <td>${course.id}</td>
                           <td>${course.name}</td>
                            <td><a href="/cuform?cid=${course.id}">update</a></td>
                            <td><a href="/vss?cid=${course.id}">view</a></td>
                            <td><a href="/cdel?cid=${course.id}">delete</a></td>
                           <!-- Add more columns if needed -->
                       </tr>
                   </c:forEach>
    </tbody>
</table>
<br><br>
<center><a href="/slist">Total Students</a>
<br><br>
<center><a href="/csadd">Add Courses</a>
<br></br>
<center><a href="/join">Mappings</a></center>
</body>
</html>

