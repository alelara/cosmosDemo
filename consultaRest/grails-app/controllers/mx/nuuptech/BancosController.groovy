package mx.nuuptech

import yodlee.ysl.api.apps.aggregation.AddProviderAccount
import yodlee.ysl.api.apps.aggregation.ProviderApp
import yodlee.ysl.api.beans.Providers
import yodlee.ysl.api.beans.Transactions
import org.json.JSONObject
import org.json.JSONArray
import yodlee.ysl.api.parsers.GSONParser;
import yodlee.ysl.api.beans.Transactions
class BancosController {
    
    private static final String fqcn = ProviderApp.class.getName();
    public static Map<String, String> loginTokens = new HashMap<String, String>();
    public static Map<String, String> cobTokens = new HashMap<String, String>();
    
    public static final String localURLVer1 = "https://developer.api.yodlee.com/ysl/restserver/v1/";//resourceBundle.getString("yodlee.localURLVer1");
    static String coBrandUserName = "sbCobtomas.moreno"; //resourceBundle.getString("yodlee.coBrandUserName");
    static String coBrandPassword = "bb8cbff9-9545-465f-b367-4fe4cff6c030";//resourceBundle.getString("yodlee.coBrandPassword");
    static String userName = "sbMemtomas.moreno1";//resourceBundle.getString("yodlee.userName");
    static String userPassword = "sbMemtomas.moreno1#123";//resourceBundle.getString("yodlee.userPassword");
    static String registerParam = "{\"user\": {\"loginName\": \"yslResr976\", \"password\": \"TEST@123\", \"email\": \"yslRest69@yodlee.com\", \"name\": {\"first\": \"FNAME\",\"last\": \"LNAME\" },\"address\": {\"address1\": \"200 Lincoln Ave\",\"state\": \"CA\",\"city\": \"Salinas\",\"zip\": \"93901\",\"country\": \"USA\"},\"preferences\": {\"currency\": \"USD\",\"timeZone\": \"PST\",\"dateFormat\": \"MM/dd/yyyy\"}}}";//resourceBundle.getString("yodlee.registerParam");
    

     
    def getBanco={
    def datosGet=[]
    def datosTran=[]
    String banco=params.bancoName    
    def datos= ProviderApp.buscarBancos(banco)    
    println "datos_"+datos    
    
    		Providers providers = (Providers) GSONParser.handleJson(
				datos, yodlee.ysl.api.beans.Providers.class);
		if(providers != null){
			System.out.println(providers.toString());
		}else{
			System.out.println("Empty Response..");
		}    
      providers.each{
          println "_"+it
      }  
      
     JSONObject jsonObject = new JSONObject(datos);   
     JSONArray array = jsonObject.get("provider");
     
    for (int i = 0; i < array.length(); i++) {
                def mapa=[:]
                JSONObject row = array.getJSONObject(i);
                mapa.categoryId = row.getInt("id");
                mapa.categoryName = row.getString("name");
                mapa.transactionCategoryTypeId = row.getString("loginUrl");
                datosGet.add(mapa)
            }
       [datosGet:datosGet]  
    }
    
    
    
    
    
    
    def index() {}
    
    def consultaUserInfo={ 
        def datosTran=[]
        boolean errorLogin=false
        println " ---------------------------------------- params_"+params
        def datos= ProviderApp.getUsuario(params.user, params.passwd) 
        println "datos_"+datos
        
        if(datos){
                            errorLogin=false
                            def transactions=ProviderApp.getTransactions() 
                            println "transactions_"+transactions
                            
                            if(transactions){
                                def transacciones=transactions?.toString().split("@")
                                transacciones.each{
                                    def cadena=it?.toString()?.split("%")
                                    def mapa=[:]
                                    mapa.id=cadena[0]
                                    mapa.monto=cadena[1]
                                    mapa.fecha=cadena[2]
                                    mapa.tipo=cadena[3]
                                    datosTran.add(mapa)
                                    println "  mapa:"+mapa
                                }
                            }
        }else{
            println "Errror_de_logi_"+errorLogin
            errorLogin=true
        }
                            
        [datosTran:datosTran,errorLogin:errorLogin]
        //render "params__"
    }
    
                        
    def transaccionesGet={                    
    def datosGet=[]
    def datosTran=[]
    String banco="bancomer"    
    def datos= ProviderApp.buscarBancos(banco)    
    println "datos_"+datos    
    
    		Providers providers = (Providers) GSONParser.handleJson(
				datos, yodlee.ysl.api.beans.Providers.class);
		if(providers != null){
			System.out.println(providers.toString());
		}else{
			System.out.println("Empty Response..");
		}    
      providers.each{
          println "_"+it
      }  
      
     JSONObject jsonObject = new JSONObject(datos);   
     JSONArray array = jsonObject.get("provider");
     
    for (int i = 0; i < array.length(); i++) {
                def mapa=[:]
                JSONObject row = array.getJSONObject(i);
                mapa.categoryId = row.getInt("id");
                mapa.categoryName = row.getString("name");
                mapa.transactionCategoryTypeId = row.getString("loginUrl");
                datosGet.add(mapa)
            }

     def transactions=ProviderApp.getTransactions() 
     println "transactions_"+transactions
     
     if(transactions){
         def transacciones=transactions?.toString().split("@")
     transacciones.each{
         def cadena=it?.toString()?.split("%")
             def mapa=[:]
             mapa.id=cadena[0]
             mapa.monto=cadena[1]
             mapa.fecha=cadena[2]
             mapa.tipo=cadena[3]
             datosTran.add(mapa)
             println "  mapa:"+mapa
     }
    }
     [datosGet:datosGet, datosTran:datosTran]
    }
    

    
    
}
