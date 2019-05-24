<%@include file="filtroSessao.jsp"%>
<%@page import="br.com.bancounipaulistana.dao.conta.ContaDao"%>
<%@page import="br.com.bancounipaulistana.classes.conta.Conta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Banco Unipaulistana - Início</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300,600" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css">
        <script src="js/bootstrap.bundle.min.js"></script>
    </head>


    <body>
        <%        
            ContaDao dao = new ContaDao();
        
            int numeroDaConta = Integer.parseInt(sessao.getAttribute("Conta").toString());
        %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Banco UniPaulistana</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="homePage.jsp">Início <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="previdenciaPrivada.jsp">Previdência Privada</a>
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
            <h2 class="mensagem-destaque">Bem vindo, <strong><%out.println(dao.getNomeCompleto(numeroDaConta).trim());%></strong></h2>
            <p class="paragrafo">Por gentileza, utilize o menu acima para navegar em nosso sistema.</p>
            <p class="paragrafo">O Banco Unipaulistana te deseja um ótimo dia.</p>
            <p class="paragrafo">Seu saldo atual é de <b>R$<%out.println(dao.getSaldo(numeroDaConta));%></b>.</p>
        </div>
    </body>

</html>