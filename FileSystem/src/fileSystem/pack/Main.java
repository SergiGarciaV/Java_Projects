package fileSystem.pack;

import java.io.File;

class Main {
 
  private static final String FOLDER_BASE = "C:\\Pruebas\\Work2"; //Estoy en IDE online, en mi PC podría ser C:/..... 
  
  public static void main(String[] args) {
 
    
   //permisos(FOLDER_BASE);
   // crearDirectoris(FOLDER_BASE);
    //renombrarDirectorio(FOLDER_BASE);
    //eliminarDirectoris(FOLDER_BASE);
    //llistaContingutDirectoriComString("./Work2");
    llistaContingutDirectoriComFiles(FOLDER_BASE);
  }
  
  private static void permisos(String carpeta){
 
   File file = new File(carpeta);
   boolean exists = file.exists();
   boolean canRead = file.canRead();
   boolean canExecute = file.canExecute();
   boolean canWrite = file.canWrite();
 
   System.out.println(exists);
   System.out.println(canRead);
   System.out.println(canExecute);
   System.out.println(canWrite);
  }
 
  //Creará un directorio con el nombre que contenga la variable carpeta y dos subdirectorios dentro de esta con los nombres "unaCarpeta" y "OtraCarpeta"
  private static void crearDirectoris(String carpeta){
    carpeta = carpeta + "./unaCarpeta/otraCarpeta";//En mi PC sería "C:/....."
    File file = new File(carpeta);
 
    //Devuelve true si ha creado un solo directorio
    boolean creada = file.mkdir(); 
    System.out.println(creada);
 
    //Devuelve true si ha creado + de 1 directorio
    boolean creada2 = file.mkdirs();
    System.out.println(creada2);
 
    //Si la ruta que pasamos ya existe no la crea de nuevo, peeero si hay alguna carpeta dentro con un nombre distinto SI que la creará de nuevo añadiendo con el mismo nombre pero añadiendo un punto final.
  }
 
  private static void renombrarDirectorio(String carpeta){
   
 
    String carpetaOriginal = carpeta + "/unaCarpeta";
    String carpetaAmodificar = "_nomModificat";
    
    File fileOriginal = new File(carpetaOriginal);
    File fileDestino = new File(carpetaAmodificar);
 
    boolean directoriRenombrat = fileOriginal.renameTo(fileDestino);
 
    System.out.print(directoriRenombrat);
}
 
  private static void moverDirectorio(String carpetaOrigen, String carpetaDestino) {
      File directorioOrigen = new File(carpetaOrigen);
      File directorioDestino = new File(carpetaDestino);
 
      // Asegurarse de que el directorio de destino exista
      if (!directorioDestino.exists()) {
          directorioDestino.mkdir();
      }
 
      // Mover el directorio
      if (directorioOrigen.exists()) {
          boolean directorioMovido = directorioOrigen.renameTo(new File(directorioDestino, directorioOrigen.getName()));
          System.out.println("Directorio movido: " + directorioMovido);
      } else {
          System.out.println("El directorio de origen no existe.");
      }
  }
//En principio si queremos eliminar una carpeta que contiene otra, no 
// nos dejará. Eso se podría ir haciendo usando recursividad, eliminando desde la carpeta más interna a la + cercana a la raíz. 
  private static void eliminarDirectoris(String carpeta){
    
    String carpetaRutaIntermedia = carpeta + "/unaCarpeta/otraCarpeta";
    File fileRutaIntermedia = new File(carpetaRutaIntermedia);
    //Devuelve true si consigue eliminar la carpeta en la ruta intermedia
    boolean borradaRutaIntermedia = fileRutaIntermedia.delete();
 
    String carpetaRutaFinal = carpeta + "/Carpetita";
    File fileRutaFinal = new File(carpetaRutaFinal);
    boolean borradaRutaFinal = fileRutaFinal.delete();
 
    System.out.println(borradaRutaIntermedia);
    System.out.println(borradaRutaFinal);
  }
 
  //Listamos contenido como String's
  private static void llistaContingutDirectoriComString(String carpeta){
    File file = new File(carpeta);
 
    //.list() nos devolvera un array con todos los archivos y carpetas     que hay en la carpeta
    String[] files = file.list();
 
    //Recorre cada elemento de tipo String del array: files. Recorremos el array de archivos y carpetas imprimiendo cada carpeta y fichero que se encuentra. No incluye las subcarpetas
    if(files!=null){
      for (String element : files) {
            System.out.println(element);
      }
      
    }
    
  }
 
  //Listamos contenido como Files
  private static void llistaContingutDirectoriComFiles(String carpeta){
 
    File file = new File(carpeta);
    File[] files = file.listFiles();
    
    if(files!=null){
      //Recorre cada elemento de tipo file del array: files. 
      for (File element : files) {
    	System.out.println("------------------------------------------------------------");
        System.out.println("file = "+element);
        System.out.println("Es un directori= "+ element.isDirectory());
        System.out.println("Es un ficher= "+element.isFile());
        System.out.println("Ruta completa= "+element.getAbsolutePath());
        System.out.println("Name= "+element.getName());
        System.out.println("Tamany= "+element.length());
        System.out.println("Can read= "+element.canRead());
        System.out.println("Can write= "+element.canWrite());
        System.out.println("Is Hidden= "+element.isHidden());
       
      }
 
    }
  }
  
 
}

