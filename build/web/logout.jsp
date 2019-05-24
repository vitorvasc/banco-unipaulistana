<%
    
    HttpSession sessao = request.getSession();
    sessao.removeAttribute("Usuario");
    response.sendRedirect("index.html");

%>