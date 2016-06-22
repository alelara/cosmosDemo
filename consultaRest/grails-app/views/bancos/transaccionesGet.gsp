<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>  
    <asset:stylesheet src="bootstrap.css"/> 
    <asset:javascript src="jquery-3.0.0.min.js"/>
</head>
<body>        
    <div class="row" style="width: 80%; margin-left: 10%;">
        <h1>Ultimas Transacciones</h1><a class="btn btn-danger" href="${createLink(uri: '/')}"> regresar </a><br><br>
        <div class="panel panel-default">
  <!-- Default panel contents -->
      <div class="panel-heading">Usuario: ${user}</div>
      <br>
      <select name="bancoId" class="form-control" >
          <option value="16627">Bancomer</option>
          <option value="20763">Banorte</option>
      </select>
      
      <br><br>
      
      <g:formRemote name="myForm" on404="alert('not found!')" update="updateMe" url="[controller: 'bancos', action:'getBanco']">
          <div class="form-group">
              <input type="text" class="form-control" placeholder="nombre del banco" required="true" name="bancoName" required="true">
          </div>
          <button type="submit" class="btn btn-success">Buscar Banco</button>
      </g:formRemote>    
      
      <div id="updateMe">
        
      </div>
      
      <br>
      
      <br>
  <!-- Table -->

                <g:each name="trans" in="${datosTran}">
                    
                    
                    <div class="well well-lg" style="width: 90%; margin-left: 5%;">
                                <table class="table table-bordered table-hover table-striped">
                                    <tr>
                                        <th style="width: 20%;">Identificador</th>
                                        <td style="width: 80%;">${it?.id}</td>  
                                    </tr>
                                       <tr>
                                        <th>Monto</th>
                                        <td>${it?.monto}</td>  
                                    </tr>
                                       <tr>
                                        <th>FEcha</th>
                                        <td>${it?.fecha}</td>  
                                    </tr>
                                       <tr>
                                        <th>Movimiento</th>
                                        <td>${it?.tipo}</td>  
                                    </tr>
                                       
                                </table>
                            </div>
                    
                    
                </g:each>
    
        </div>
    </div>

</body>