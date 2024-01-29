/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_usuarios;

import com.toedter.calendar.JDateChooser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author accpm
 */
public class UsuarioGimnasio {
    
    private static int contador = 1;

    // Datos personales
    String primerNombre;
    String segundoNombre;
    String tercerNombre;
    String primerApellido;
    String segundoApellido;
    int telefono;
    String correo;

    // Información de emergencia
    String personaEmergenciaNombre;
    String personaEmergenciaApellido;
    String parentesco;
    int telefonoPE;

    public int getTelefonoPE() {
        return telefonoPE;
    }

    public void setTelefonoPE(int telefonoPE) {
        this.telefonoPE = telefonoPE;
    }

    // Otros datos
    String foto; 
    Date fechaNacimiento;
    Date fechaIngreso;
    Date fechaProximaPago;

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPersonaEmergenciaNombre() {
        return personaEmergenciaNombre;
    }

    public void setPersonaEmergenciaNombre(String personaEmergenciaNombre) {
        this.personaEmergenciaNombre = personaEmergenciaNombre;
    }

    public String getPersonaEmergenciaApellido() {
        return personaEmergenciaApellido;
    }

    public void setPersonaEmergenciaApellido(String personaEmergenciaApellido) {
        this.personaEmergenciaApellido = personaEmergenciaApellido;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaProximaPago() {
        return fechaProximaPago;
    }

    public void setFechaProximaPago(Date fechaProximaPago) {
        this.fechaProximaPago = fechaProximaPago;
    }

    public void InsertarUsuarios(JTextField paprimerNombre, JTextField pasegundoNombre, JTextField patercerNombre, JTextField paprimerApellido, JTextField pasegundoApellido,
            JTextField patelefono, JTextField pacorreo, JTextField papersonaEmergenciaNombre, JTextField papersonaEmergenciaApellido, JTextField paparentesco, JTextField pafoto,
            JDateChooser pafechaNacimiento, JDateChooser pafechaIngreso, JDateChooser pafechaProximaPago, JTextField patelefonoPE) {

        setPrimerNombre(paprimerNombre.getText());
        setSegundoNombre(pasegundoNombre.getText());
        setTercerNombre(patercerNombre.getText());
        setPrimerApellido(paprimerApellido.getText());
        setSegundoApellido(pasegundoApellido.getText());
        setTelefono(Integer.parseInt(patelefono.getText()));
        setCorreo(pacorreo.getText());
        setPersonaEmergenciaNombre(papersonaEmergenciaNombre.getText());
        setPersonaEmergenciaApellido(papersonaEmergenciaApellido.getText());
        setParentesco(paparentesco.getText());
        setFoto(pafoto.getText());
        
        setFechaNacimiento(pafechaNacimiento.getDate());
        setFechaIngreso(pafechaIngreso.getDate());
        setFechaProximaPago(pafechaProximaPago.getDate());  
        
        setTelefonoPE(Integer.parseInt(patelefonoPE.getText()));

        String consulta = "INSERT INTO USUARIOS (\n"
                + "    primerNombre,\n"
                + "    segundoNombre,\n"
                + "    tercerNombre,\n"
                + "    primerApellido,\n"
                + "    segundoApellido,\n"
                + "    telefono,\n"
                + "    correo,\n"
                + "    personaEmergenciaNombre,\n"
                + "    personaEmergenciaApellido,\n"
                + "    parentesco,\n"
                + "    foto,\n"
                + "    fechaNacimiento,\n"
                + "    fechaIngreso,\n"
                + "    fechaProximaPago,\n"
                + "    telefonoPE\n"
                + ") VALUES (\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?\n"
                + ");";

        ConexionG co = new ConexionG();

        try {
            Connection conexion = co.estableceConexion();
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, primerNombre);
            ps.setString(2, segundoNombre);
            ps.setString(3, tercerNombre);
            ps.setString(4, primerApellido);
            ps.setString(5, segundoApellido);
            ps.setInt(6, telefono);
            ps.setString(7, correo);
            ps.setString(8, personaEmergenciaNombre);
            ps.setString(9, personaEmergenciaApellido);
            ps.setString(10, parentesco);
            ps.setString(11, foto);
            ps.setDate(12, new java.sql.Date(fechaNacimiento.getTime()));
            ps.setDate(13, new java.sql.Date(fechaIngreso.getTime()));
            ps.setDate(14, new java.sql.Date(fechaProximaPago.getTime()));
            ps.setInt(15, telefonoPE);


            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas >= 0) {

                JOptionPane.showMessageDialog(null, "SE INSERTÓ EL USUARIO", "INSERTADO", JOptionPane.PLAIN_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "NO SE INSERTÓ EL USUARIO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR USUARIO, ERROR: " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
   
   
    public void MostrarUsuarios(JTable paramTabla1) {
        ConexionG co = new ConexionG();

        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        paramTabla1.setRowSorter(ordenarTabla);

        paramTabla1.setModel(modelo);

        String sql = "SELECT * FROM USUARIOS;";

        try (Connection conexion = co.estableceConexion(); Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Añadir las columnas dinámicamente
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                modelo.addColumn(metaData.getColumnName(columnIndex));
            }

            // Añadir las filas
            while (rs.next()) {
                String[] datos = new String[columnCount];

                for (int i = 1; i <= columnCount; i++) {
                    if (metaData.getColumnTypeName(i).equalsIgnoreCase("DATETIME")) {
                        // Formatear fechas antes de agregarlas al modelo
                        Timestamp timestamp = rs.getTimestamp(i);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        datos[i - 1] = (timestamp != null) ? dateFormat.format(timestamp) : null;
                    } else {
                        datos[i - 1] = rs.getString(i);
                    }
                }

                modelo.addRow(datos);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN MOSTRAR LOS USUARIOS, ERROR: " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
  
    public void ModificarUsuarios(String NuevoId, String NuevoPNombre, String NuevoSNombre, String NuevoTNombre,
            String NuevoPApellido, String NuevoSApellido, String NuevoTelefono, String NuevoCorreo,
            String NuevoNombrePersonaEmergencia, String NuevoApellidoPersonaEmergencia, String NuevoParentesco,
            String NuevoFoto, JDateChooser NuevoFechaNacimiento, JDateChooser NuevoFechaIngreso,
            JDateChooser NuevoFechaProximoPago, String NuevoTelefonoPE) {

        ConexionG co = new ConexionG();

        String consulta = "UPDATE USUARIOS SET primerNombre = ?, segundoNombre = ?, tercerNombre = ?, "
                + "primerApellido = ?, segundoApellido = ?, telefono = ?, correo = ?, "
                + "personaEmergenciaNombre = ?, personaEmergenciaApellido = ?, parentesco = ?, "
                + "foto = ?, fechaNacimiento = ?, fechaIngreso = ?, fechaProximaPago = ?, "
                + "telefonoPE = ? WHERE Id = ?;";

        try (Connection conexion = co.estableceConexion(); PreparedStatement ps = conexion.prepareStatement(consulta)) {

            ps.setString(1, NuevoPNombre);
            ps.setString(2, NuevoSNombre);
            ps.setString(3, NuevoTNombre);
            ps.setString(4, NuevoPApellido);
            ps.setString(5, NuevoSApellido);
            ps.setString(6, NuevoTelefono);
            ps.setString(7, NuevoCorreo);
            ps.setString(8, NuevoNombrePersonaEmergencia);
            ps.setString(9, NuevoApellidoPersonaEmergencia);
            ps.setString(10, NuevoParentesco);
            ps.setString(11, NuevoFoto);

            Date fechaNacimiento = (NuevoFechaNacimiento != null && NuevoFechaNacimiento.getDate() != null)
                    ? new java.sql.Date(NuevoFechaNacimiento.getDate().getTime())
                    : null;
            Date fechaIngreso = (NuevoFechaIngreso != null && NuevoFechaIngreso.getDate() != null)
                    ? new java.sql.Date(NuevoFechaIngreso.getDate().getTime())
                    : null;
            Date fechaProximoPago = (NuevoFechaProximoPago != null && NuevoFechaProximoPago.getDate() != null)
                    ? new java.sql.Date(NuevoFechaProximoPago.getDate().getTime())
                    : null;

            ps.setDate(12, (fechaNacimiento != null) ? new java.sql.Date(fechaNacimiento.getTime()) : null);
            ps.setDate(13, (fechaIngreso != null) ? new java.sql.Date(fechaIngreso.getTime()) : null);
            ps.setDate(14, (fechaProximoPago != null) ? new java.sql.Date(fechaProximoPago.getTime()) : null);

            ps.setString(15, NuevoTelefonoPE);
            ps.setString(16, NuevoId);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó correctamente el usuario con ID: " + NuevoId, "Modificado",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se realizó ninguna modificación. Verifica los datos.", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el usuario. Error: " + e.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarUsuario(String paramId){
        
        if(!paramId.isEmpty()){
            try {
                int id = Integer.parseInt(paramId);
                ConexionG CO = new ConexionG();
                String consulta = "DELETE FROM USUARIOS WHERE USUARIOS.Id = ?;";
                try {
                    CallableStatement cs = CO.estableceConexion().prepareCall(consulta);
                    cs.setInt(1, id);
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "SE ELIMINÓ CORRECTAMENTE EL USUARIO", "ELIMINADO", JOptionPane.PLAIN_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL USUARIO, ERROR: " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "INGRESE UN ID VÁLIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }   
        }
        else{
            JOptionPane.showMessageDialog(null, "INGRESE UN ID VÁLIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SeleccionarUsuario(JTable paramTabla1) {
        try {
            int fila = paramTabla1.getSelectedRow();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE SELECCIÓN, ERROR: " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void GuardarExtensionFoto(BufferedImage imagen, JTextField TextoFoto) {

        int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea guardar fotografía?", "GUARDANDO", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (pregunta == 0) {
            try {
                String fechaActual = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String nombreArchivo = "Foto" + contador + "_" + fechaActual + ".jpg";
                File salidaImagen = new File("C:\\Users\\accpm\\OneDrive\\Escritorio\\ARCHIVOS_EXPORTADOS\\FOTOS_USUARIOS\\" + nombreArchivo);

                ImageIO.write(imagen, "jpg", salidaImagen);
                JOptionPane.showMessageDialog(null, "Imagen guardada en: " + salidaImagen.getAbsolutePath(), "GUARDADO", JOptionPane.PLAIN_MESSAGE);
                TextoFoto.setText(salidaImagen.getAbsolutePath());
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al exportar la imagen, ERROR: " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            contador++;
        }
    }
}
