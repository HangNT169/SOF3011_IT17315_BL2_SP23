<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="/sinh-vien/view-add">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
<%--    for(SinhVien sv:lists)--%>
    <c:forEach items="${listSinhVien}" var="sv1" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${sv1.mssv}</td>
            <td>${sv1.ten}</td>
            <td>${sv1.tuoi}</td>
            <td>${sv1.diaChi}</td>
            <td>${sv1.gioiTinh}</td>
            <td>
                <a href="/sinh-vien/detail?id1=${i.index}">Detail</a>
                <a href="/sinh-vien/remove?id=${i.index}">Remove</a>
                <a href="/sinh-vien/view-update?id=${i.index}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
