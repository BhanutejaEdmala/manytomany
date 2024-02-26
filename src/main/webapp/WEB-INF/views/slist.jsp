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
            <th>Student Id</th>
            <th>Student Name</th>
            <th>Courses Joined</th>
            <th>Add Courses</th>
            <th>Update Student</th>
            <th>Delete Student</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${sl}" var="student">
                       <tr>
                           <td>${student.id}</td>
                           <td>${student.name}</td>
                           <td><a href="/ssc?sid=${student.id}">view</a></td>
                           <td><a href="/caform?sid=${student.id}">add</a></td>
                           <td><a href="/csn?sid=${student.id}">change student name</a></td>
                           <td><a href="/dstu?sid=${student.id}">delete</a></td>
                           <!-- Add more columns if needed -->
                       </tr>
                   </c:forEach>
    </tbody>
</table>
<br><br>
<center><a href="/clist">Total Courses</a>
<br><br>
<center><a href="/sform">Add Students</a>
</body>
</html>

