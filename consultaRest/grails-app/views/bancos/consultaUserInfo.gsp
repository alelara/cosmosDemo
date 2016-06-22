 
<br><br>
 <g:if test="${errorLogin}">
      <div class="alert alert-danger col-lg-10 col-md-offset-1" role="alert"> Errror UNAUTHORIZED()... </div>
            
 </g:if>
 <g:else>
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
  </g:else>  