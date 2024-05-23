package com.mycompany.tarea3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Tarea3 extends JFrame {
    private Set<Contacto> treeSet = new TreeSet<>(Comparator.comparingInt(Contacto::getId));
    private Set<Contacto> hashSet = new HashSet<>();
    private Set<Contacto> linkedHashSet = new LinkedHashSet<>();
    private java.util.List<Contacto> arrayList = new ArrayList<>();

    private JTextArea textArea;
    private JTextField idField;
    private JTextField nombreField;
    private JTextField telefonoField;
    private JTextField idBorrarField;

    public Tarea3() {
        setTitle("Gestión de Contactos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(10, 2));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        panel.add(telefonoField);

        JButton crearButton = new JButton("Crear Contacto");
        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearContacto();
            }
        });
        panel.add(crearButton);

        JButton listarButton = new JButton("Listar Contactos");
        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarContactos();
            }
        });
        panel.add(listarButton);

        panel.add(new JLabel("ID para Borrar:"));
        idBorrarField = new JTextField();
        panel.add(idBorrarField);

        JButton borrarButton = new JButton("Borrar Contacto");
        borrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarContacto();
            }
        });
        panel.add(borrarButton);

        JButton cantidadButton = new JButton("Cantidad de Contactos");
        cantidadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCantidadContactos();
            }
        });
        panel.add(cantidadButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void crearContacto() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String telefono = telefonoField.getText();

            Contacto nuevoContacto = new Contacto(id, nombre, telefono);

            treeSet.add(nuevoContacto);
            hashSet.add(nuevoContacto);
            linkedHashSet.add(nuevoContacto);
            arrayList.add(nuevoContacto);

            textArea.setText("Contacto creado con éxito.");
        } catch (NumberFormatException e) {
            textArea.setText("Error: ID debe ser un número entero.");
        }
    }

    private void listarContactos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contactos en TreeSet:\n");
        treeSet.forEach(contacto -> sb.append(contacto).append("\n"));

        sb.append("\nContactos en HashSet:\n");
        hashSet.forEach(contacto -> sb.append(contacto).append("\n"));

        sb.append("\nContactos en LinkedHashSet:\n");
        linkedHashSet.forEach(contacto -> sb.append(contacto).append("\n"));

        sb.append("\nContactos en ArrayList:\n");
        arrayList.forEach(contacto -> sb.append(contacto).append("\n"));

        textArea.setText(sb.toString());
    }

  
      private void borrarContacto() {
        try {
            int id = Integer.parseInt(idBorrarField.getText());

            boolean borrado = borrarContacto(treeSet, id);
            borrado = borrarContacto(hashSet, id) || borrado;
            borrado = borrarContacto(linkedHashSet, id) || borrado;
            borrado = borrarContacto(arrayList, id) || borrado;

            if (borrado) {
                textArea.setText("Contacto borrado.");
            } else {
                textArea.setText("No se encontró el contacto con ID " + id);
            }
        } catch (NumberFormatException e) {
            textArea.setText("Error: ID debe ser un número entero.");
        }
    }

    private boolean borrarContacto(Collection<Contacto> contactos, int id) {
        Iterator<Contacto> iterator = contactos.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    

    private void mostrarCantidadContactos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de contactos en TreeSet: ").append(treeSet.size()).append("\n");
        sb.append("Cantidad de contactos en HashSet: ").append(hashSet.size()).append("\n");
        sb.append("Cantidad de contactos en LinkedHashSet: ").append(linkedHashSet.size()).append("\n");
        sb.append("Cantidad de contactos en ArrayList: ").append(arrayList.size()).append("\n");

        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Tarea3().setVisible(true);
            }
        });
    }
}
