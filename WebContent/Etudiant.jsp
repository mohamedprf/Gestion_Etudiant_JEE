<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<link href="static/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
<title>Add new user</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form method="POST" action='EtudiantController' name="frmAddUser">
  <div class="form-group">
    <label for="exampleInputID">ID</label>
   <input class="form-control" type="text" readonly="readonly" name="id"
            value="<c:out value="${etudiant.id}" />" /> 
  </div>
  <div class="form-group">
    <label for="exampleInputNom">Nom</label>
   <input
         class="form-control"   type="text" name="nom"
            value="<c:out value="${etudiant.nom}" />" />
  </div>
   <div class="form-group">
    <label for="exampleInputPrenom">Prenom</label>
   <input
         class="form-control"   type="text" name="prenom"
            value="<c:out value="${etudiant.prenom}" />" />
  </div>
    <div class="form-group">
    <label for="exampleInputsexe">sexe</label><br>
  <label>
        <input type="radio" name="sexe" value="masculin" checked="checked" />
        masculin &nbsp;&nbsp;&nbsp;
    </label>
    <label>
        <input type="radio" name="sexe" value="feminin" />
        feminin<br />
    </label>
    </div>        
   <div class="form-group">
    <label for="exampleInputemail">email</label>
   <input class="form-control" type="text" name="email"
            value="<c:out value="${etudiant.email}" />" />          
  </div>
  
  <div class="form-group">
 <SELECT name="filiere" class="form-control">
                <OPTION SELECTED>------------------------</OPTION>
                <OPTION >Informatique</OPTION>
                <OPTION>Math</OPTION>
                <OPTION >Lettre</OPTION>
                <OPTION>Physique</OPTION>
            </SELECT>
  </div>
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>