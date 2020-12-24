<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="POST" action='EtudiantController' name="formAddEtudiant">
        ID : <input type="text" readonly="readonly" name="id"
            value="<c:out value="${etudiant.id}" />" /> <br /> 
        nom : <input
            type="text" name="nom"
            value="<c:out value="${etudiant.nom}" />" /> <br /> 
        prenom : <input
            type="text" name="prenom"
            value="<c:out value="${etudiant.prenom}" />" /> <br /> 
        sexe : <input
            type="text" name="dob"
            value="<c:out value="${etudiant.filiere" />" /> <br /> 
        Email : <input type="text" name="email"
            value="<c:out value="${etudiant.email}" />" /> <br /> 
         nom : <input
            type="text" name="filiere"
            value="<c:out value="${etudiant.filiere}" />" /> <br /> 
            <input type="submit" value="Submit" />
    </form>
</body>
</html>