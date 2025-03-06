<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<html> 
<head> 
    <title>Feedback List</title> 
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>"> 
</head> 
<body> 
<header> 
    <h1>Feedback List</h1> 
    <nav> 
        <ul> 
            <li><a href="<c:url value='/'/>">Home</a></li> 
            <li><a href="<c:url value='/feedback-form'/>">Submit Feedback</a></li> 
        </ul> 
    </nav> 
</header> 
<main> 
    <c:choose> 
        <c:when test="${not empty feedbackList}"> 
            <table> 
                <thead> 
                <tr> 
                    <th>Username</th> 
                    <th>Email</th> 
                    <th>Comments</th> 
                    <th>Star Rating</th> 
                </tr> 
                </thead> 
                <tbody> 
                <c:forEach var="feedback" items="${feedbackList}"> 
                    <tr> 
                        <td>${feedback.username}</td> 
                        <td>${feedback.email}</td> 
                        <td>${feedback.comments}</td> 
                        <td>${feedback.rating}</td> 
                    </tr> 
                </c:forEach> 
                </tbody> 
            </table> 
        </c:when> 
        <c:otherwise> 
            <p>No feedback available.</p> 
        </c:otherwise> 
    </c:choose> 
</main> 
</body> 
</html> 