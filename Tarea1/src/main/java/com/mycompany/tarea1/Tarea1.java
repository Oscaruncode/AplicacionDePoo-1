/*
 * 
Arraylist
Add
Listar
buscar
borrar 
tamaño Arr
 */

package com.mycompany.tarea1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Tarea1 {

    public static void main(String[] args) {
       
       Scanner scanner = new Scanner(System.in);
        
       ArrayList<String> nuevoArr = new ArrayList<>();
       //Agregar elementos
        System.out.println("Agregar elementos a la lista");
        nuevoArr.add("Elemento 1");
        nuevoArr.add("Elemento 2");
        nuevoArr.add("Elemento 3");
        nuevoArr.add("Elemento 4");
        
        //Listar
        System.out.println("Listar todos los elementos"); 
        Iterator<String> arrIterator = nuevoArr.iterator();
        while(arrIterator.hasNext()){
         String elemento = arrIterator.next();
          System.out.println(elemento + " / ");
        }

        //Mostrar un elemento (buscar)
        System.out.println("Ingrese el elemento a buscar: ");
        String elemento_buscar = scanner.next();
        for(String element:nuevoArr){
            if(element.equals(elemento_buscar)){System.out.println("Elemento encontrado: "+element);}
        }

        //Devolver tamaño del Array
        int numElementos = nuevoArr.size();
        System.out.println("\n El Array list tiene "+ numElementos + " Elementos");

       //Eliminar un elemento del Array
        System.out.println("Eliminando el elemento 2...");
       nuevoArr.remove(2);

    }
}
