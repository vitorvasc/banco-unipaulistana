<%@page import="br.com.bancounipaulistana.dao.planosdeprevidencia.PlanosDao"%>
<%@page import="br.com.bancounipaulistana.dao.conta.ContaDao"%>
<%@include file="filtroSessao.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Banco Unipaulistana - Previdência Privada</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,600" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css">
        <script src="js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%
            PlanosDao planos = new PlanosDao();
        %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Banco UniPaulistana</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="homePage.jsp">Início</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="previdenciaPrivada.jsp">Previdência Privada<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="planosContratados.jsp">Meus Planos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container tela-inicio">
            <h2 class="mensagem-destaque">Confira abaixo os planos de previdência disponíveis para você.</h2>
            
            <jsp:include page="/ExibePlanos" />
        </div>
    </body>
</html>
