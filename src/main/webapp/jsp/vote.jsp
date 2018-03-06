<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>投票</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/vote.js"></script>

<link rel="stylesheet" type="text/css" href="css/vote.css">
</head>
<body>
	<form action="evaluate" method="post"
		onsubmit="return checkInput(${size})">
		<div class="tab">
			<ul class="nav nav-pills nav-justified">
				<li role="presentation" class="active"><a href="#depart"
					data-toggle="tab">对部门进行投票</a></li>
				<li role="presentation"><a href="#person" data-toggle="tab">对人员进行投票</a></li>
			</ul>
		</div>

		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="depart">
				<h1 style="margin-bottom: 30px;">请对如下部门进行投票</h1>
				<div>
					<c:forEach var="item" items="${listDepart }">
						<p style="width: 100px;"></p>
						<p>
							<label for="name" style="margin-bottom: 0px;"><c:out
									value="${item.departname}" /></label>
						</p>
						<div id="option${item.id }">
							<c:forEach var="option" items="${listOption }">
								<input type="checkbox" name="option-depart-name${item.id }"
									value=" ${option.id }" onclick="myCheck(this)" /> ${option.name }
					</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="tab-pane fade" id="person">
				<h1 style="margin-bottom: 30px;">请对如下人员进行投票</h1>
				<div>
					<c:forEach var="item" items="${listPerson }">
						<p style="width: 100px;"></p>
						<p>
							<label for="name" style="margin-bottom: 0px;"><c:out
									value="${item.personname}" /></label>
						</p>
						<div id="option${item.id }">
							<c:forEach var="option" items="${listOption }">
								<input type="checkbox" name="option-person-name${item.id }"
									value=" ${option.id }" onclick="myCheck(this)" /> ${option.name }
					</c:forEach>
						</div>

					</c:forEach>
					
				</div>
			</div>
		</div>
		<p class='message' style="margin-top: 10px;">
						<font color="red" id="message"></font>
					</p>
					<p class="lead" style="margin-top: 40px;">
						<input class="btn btn-lg btn-primary" style="width: 240px;"
							type="submit" value="提交投票结果" />
					</p>
	</form>
</body>
</html>