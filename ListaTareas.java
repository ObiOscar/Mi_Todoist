import java.util.ArrayList;

/**
 * Crear una clase que "imite" a la aplicación Todoist https://blog.todoist.com/es/2015/05/11/guia-todoist/
1
-------------
	1)Añadir una tarea
	2)Eliminar una tarea
	3)Ver todas las tareas
	4)Contar el número de tareas

2
-------------
	1)Comprobar si un índice es valido para eliminar una tarea
	2)Devuele true en caso de que haya tareas pendientes
	3)Muestra cada tarea pendiente en una línea por pantalla
	4)Muestra las tareas coincidentes con un texto que introduce el usuario, sino hay ninguna sale un error

3
-------------
	1)Muestra todas las tareas existentes (usando un buble while)
	2)Muestra por pantalla las primeras n tareas indicadas como parámetro en caso de haya menos de n tareas se muestra todas
	3)Devuelve true o false si hay almenos una tarea que contiene el texto indicado como parámetro ( no devuelve nada por pantalla)
4
-------------
	1)Devuelve la posición de la primera tarea que contiene el texto indicado como parametro. Y -1 en caso contrario (no devuelve nada por pantalla) 
	2)
	3)

 */
public class ListaTareas
{
    // Coleccion que almacena todas las tareas
    private ArrayList<String> listaDeTareas;

    /**
     * Constructor for objects of class ListaTareas
     */
    public ListaTareas()
    {
      listaDeTareas = new  ArrayList<String>(); // Inicializo la lista de tarea como un nuevo objeto de la clase ArrayList 
    }
    
     /**
     * Imprime por pantalla todas las tareas guardadas
     */
    public void imprimirTareas()
    {
     System.out.println(listaDeTareas);     
    }
    
     /**
     * Añade una nueva tarea
     * Existe un método para meter un parámetro dentro de un listado Array, es add, su sintaxis es:
     * objeto de la clase ArrayList.add(parámetro);
     */
    public void annadirTarea(String nuevaTarea)
    {
      listaDeTareas.add(nuevaTarea);
    }
    
         /**
     * Nos muestra el número de tareas pendientes
     * Uso una función nueza, size(), nos cuenta cuantos hay.
     */
    public int getNumeroTareas()
    {
        return listaDeTareas.size();
    }
    
    /**
     * Elimina la tarea que ocupa la posicion indicada.
     * Si la posicion indicada no es valida, no hace nada ( COMPRUEBO QUE SEA UN NÚMERO válido)
     */
    public void eliminaTarea(int posicion) 
    {
        posicion = posicion - 1;                 //Le resto uno, porque el usuario piensa que la lista empieza en 1
        if(esValidoElIndice(posicion))
        {
            listaDeTareas.remove(posicion);
        }
    }
    
    /**
     *Método que comprueba si un índice es válido y devuelve true en caso afirmatico o false en otro caso.El método supone que un valor de 0 cuando 
     *hay una tarea es un valor de incie valido
     */
    public boolean esValidoElIndice(int indice) 
    {
        //no hace falta modificar, este trabaja como para programador
        boolean valor = false; 
        if(indice>=0 && indice < getNumeroTareas())
        {
            valor = true;
        }
         return valor;
    }  
    
            /**
     *Método que devuele true en caso de que haya tareas por hacer, false en otro caso.
     */
    public boolean hayTareasPendientes()
    {
        boolean valor = false;
        if(getNumeroTareas()>0)
        {
            valor = true;
        }
        return valor;
        
        // return !ListaTareas.isEmpty(); //Hace lo mismo que lo de arriba, llamando a una funciíb del método ArrayList que
                                          //devuelve un verdadero si la lista no contiene elementos
    }   
    
    /**
     *Método que imprime todas las tareas existentes, una por línea
     *Uso un FOR su sintaxis es:
     *  for ( TipoARecorrer nombreVariableTemporal : nombreDeLaColección ) {
            Instrucciones
       }
       También imprime el número de posición de la tarea antes del nombre
     */
    public void mostrarTareas()
    {
        int contador = 1;
        for( String tarea : listaDeTareas)
        {
            System.out.println(contador +"- "+ tarea);   
            contador = contador +1;
        }
    }  
    
    /**
     * Muestra todas las tareas ( una por línea) que contegan un determinado texto pasado
     * como parametro con su numeración correcta. Si no hay ninguna tarea contega el texto indicado, sino
     * MUESTRA UN ERROR.
     * Si hay tareas coincidentes, tras la lista, se muestra el numero de tareas coindidentes 
     */
    public void mostrarTareasCoincidentes(String comprobadorDeTexto)
    {        
       int contador = 1;
       int numeroDeTareasEnTexto = 0; //Creo una variable para llevar la cuenta de las tareas que coinciden
       
       for( String tarea : listaDeTareas)
        {
          if(tarea.contains(comprobadorDeTexto)){
            System.out.println(contador +"- "+ tarea);   
            numeroDeTareasEnTexto = numeroDeTareasEnTexto +1;   //Aumento el contador si encuentra una tarea igual
          }
           contador = contador +1;
        }
        
       if(numeroDeTareasEnTexto == 0){
           System.out.println("Error, no hay tarea con esa busqueda");    //Sino hay ninguna tarea con ese nombre, no muestra nada    
        }
        else
        {
           System.out.println( numeroDeTareasEnTexto +" tareas encontradas con el texto " +comprobadorDeTexto);
        }
    } 
    
    // Dia 3
     /**
     *Muestra todas las tareas existentes (usando un buble while) numeradas empezando en 1
     */
    public void mostrarTareas2()
    {
        int contador = 0;
        while(contador < getNumeroTareas())
        {
            System.out.println((contador + 1) + "-" +listaDeTareas.get(contador));   
            contador++;

        }
    } 
    
     /**
     *Muestra por pantalla las primeras n tareas indicadas como parámetro en caso de haya menos de n tareas se muestra todas
     */
    public void mostrarPrimerasTareas(int numeroTareasAMostrar)
    {
        int sumador = 0;
        while(sumador < numeroTareasAMostrar && sumador < getNumeroTareas())    //Con el get guardo NUMERO de tareas
        {
            System.out.println((sumador + 1) + "-" +listaDeTareas.get(sumador));   
            sumador++;

        }
    } 
    
        // Dia 4  Lo modifico pero estaba en el dia 3
     /**
     *Devuelve la posición de la primera tarea que contiene el texto indicado como parametro. Y -1 en caso contrario (no devuelve nada por pantalla) 
     */
    public int hayTareasCoincidentes(String textoABuscar)
    {
       boolean coincidencia = false;
       int valorDevolver = -1;
       int sumador = 0;
       
       while(sumador < getNumeroTareas() && !coincidencia ){
        if(listaDeTareas.get(sumador).contains(textoABuscar)){
           valorDevolver = sumador;
           coincidencia = true;
          //sumador = getNumeroTareas();             //Otra forma...mi condición de ruptura cuando entra en if ya me devuelve true y rompe el ciclo
        }
        sumador++;
       }
        return valorDevolver;
    }    
    
    // Dia 4 
    
}