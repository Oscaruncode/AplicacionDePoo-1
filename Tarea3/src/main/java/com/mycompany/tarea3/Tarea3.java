/*
 * 
Objeto: id - nombre - telefono
treeSet
HashSet
LinkedHashSet

Menu:
Crear 
Listar
Borrar
 */
package com.mycompany.tarea3;

import java.util.*;

public class Tarea3 {

    // Métodos:
    public static void listarContactos(Collection<Contacto> contactos) {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public static void borrarContacto(Collection<Contacto> contactos, int id) {
        Iterator<Contacto> iterator = contactos.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto.getId() == id) {
                iterator.remove();
                return;
            }
        }
        System.out.println("No se encontró el contacto con ID " + id);
    }

    public static void mostrarCantidadContactos(Set<Contacto> treeSet, Set<Contacto> hashSet, Set<Contacto> linkedHashSet, List<Contacto> arrayList) {
        System.out.println("Cantidad de contactos en TreeSet: " + treeSet.size());
        System.out.println("Cantidad de contactos en HashSet: " + hashSet.size());
        System.out.println("Cantidad de contactos en LinkedHashSet: " + linkedHashSet.size());
        System.out.println("Cantidad de contactos en ArrayList: " + arrayList.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Contacto> treeSet = new TreeSet<>(Comparator.comparingInt(Contacto::getId));
        Set<Contacto> hashSet = new HashSet<>();
        Set<Contacto> linkedHashSet = new LinkedHashSet<>();
        List<Contacto> arrayList = new ArrayList<>();

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Crear contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Borrar contacto");
            System.out.println("4. Cantidad de contactos en el directorio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del contacto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese teléfono del contacto: ");
                    String telefono = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(id, nombre, telefono);

                    treeSet.add(nuevoContacto);
                    hashSet.add(nuevoContacto);
                    linkedHashSet.add(nuevoContacto);
                    arrayList.add(nuevoContacto);

                    System.out.println("Contacto creado con éxito.");
                    break;
                case 2:
                    System.out.println("Contactos en TreeSet:");
                    listarContactos(treeSet);
                    System.out.println("\nContactos en HashSet:");
                    listarContactos(hashSet);
                    System.out.println("\nContactos en LinkedHashSet:");
                    listarContactos(linkedHashSet);
                    System.out.println("\nContactos en ArrayList:");
                    listarContactos(arrayList);
                    break;
                case 3:
                    System.out.print("Ingrese ID del contacto a borrar: ");
                    int idBorrar = scanner.nextInt();

                    borrarContacto(treeSet, idBorrar);
                    borrarContacto(hashSet, idBorrar);
                    borrarContacto(linkedHashSet, idBorrar);
                    borrarContacto(arrayList, idBorrar);

                    System.out.println("Contacto borrado.");
                    break;
                case 4:
                    mostrarCantidadContactos(treeSet, hashSet, linkedHashSet, arrayList);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
