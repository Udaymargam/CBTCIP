<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body bgcolor="navyblue">
<center>
<h1>Account Holder Details....</h1>
<table border="1">
<tr>
<th>ACCOUNT NO</th>
<th>USERNAME</th>
<th>AMOUNT</th>
<th>ADDRESS</th>
<th>MOBILE NO</th>
</tr>
<tr>
<td>${account.acc_no}</td>
<td>${account.name}</td>
<td>${account.amount}</td>
<td>${account.address}</td>
<td>${account.mobileNo}</td>
</tr>
</table>
<a href="/">Home page</a>
</center>
</body>