public class Archivo {

    // este es cuando quiero dejar entrara  todos los lectores y un redactor 
    private int nRedactores = 0;
    private int nLectores = 0;



    public synchronized  void entroEscribir(){
        while ((nLectores > 0)){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        nRedactores++;
        //aca se pueden quedar esperando mucho tiempo 

        
    }

    public synchronized  void entroLeer() {
        
        //no hay probek a 
        nLectores++;
       // COMO NO ME IMPORTA, y no hya restricciones para entrar a leer, no debo dejarlos esperando 
    }

    public synchronized  void salirEscribir() {
        
        nRedactores--;
        // podemos despertar a cualquiera entonces hacenos la siguiente instruccion
        notify();
        //aca se les avisa a los redactores
        
    }

    
    public synchronized  void salirLeer() {
        
        nLectores--;
        //no se le avisa a nadie porque los lectores siemre entraron y jamas se quedaron dormidos 
        
    }

    public void escribir(String texto){
    /*
    Cuando entra aca, es porque uno está escribiendo y los demas están obligatoriamente dormidos, entonces nadie va apoder entrar
    por el wait (linea 25 )
    */
     //TODO DE LO QUE SE HACE PARA CAMBIAR EL ARCHIVO ... 

    }

    public void leer(){
        
    }
}
