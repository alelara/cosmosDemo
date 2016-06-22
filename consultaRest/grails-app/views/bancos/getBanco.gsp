 <table class="table table-hover table-striped">
             <g:each name="trans" in="${datosGet}" var="variable">
                 <tr>
                     <td> <b> ${variable?.categoryName} </b> categoryId: <span style="color: green; font-weight: bold; ">${variable?.categoryId}</span>  -  ${variable?.transactionCategoryTypeId} </td>                    
                 </tr>           
       </g:each>  
 
  </table>
 
 <br><br>