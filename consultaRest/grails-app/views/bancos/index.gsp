
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <asset:stylesheet src="bootstrap.css"/>
        <asset:stylesheet src="fondo.css"/> 
        <asset:javascript src="jquery-3.0.0.min.js"/>
    </head>
    <body>

        <div class="row" >
            

            
            
            <div class="col-md-10 col-md-offset-1">
                
                <div   class="jumbotron">
                    <h1>Demo yodlee -<br> Nuuptech</h1>
                    
                    <p> &nbsp;<a class="btn btn-primary btn-lg" href="#" role="button">20 de Junio de 2016</a></p>
                </div>
                
                
            <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        Demo Nuuptech SA DE CV © 2016
      </a>
    </div>
  </div>
</nav>



<g:formRemote name="banco" class="navbar-form navbar-left" role="search" update="updateMe" url="[action:'consultaUserInfo',controller:'bancos']">
  <div class="form-group">
      <select name="bancoId" class="form-control" >
          <option value="16627">Bancomer</option>
          <option value="20763">Banorte</option>
      </select>
      <input type="text" class="form-control" placeholder="Usuario" required="true" name="user">
      <input type="password" class="form-control" placeholder="Contraseña"  required="true" name="passwd">
  </div>
  <button type="submit" class="btn btn-default">Enviar</button>
</g:formRemote>
        <br><br>
        
        
              <div id="updateMe">
        
      </div>
          </div> 


        
        </div>
    </body>
</html>
