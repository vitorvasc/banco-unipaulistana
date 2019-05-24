<%
    HttpSession sessao = request.getSession();
    if(sessao.getAttribute("Conta") == null) {
        response.sendRedirect("index.html");
    }
%>