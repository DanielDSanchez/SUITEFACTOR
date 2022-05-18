/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Conexion;
import Util.Crud;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



;

/**
 *
 * @author Juan Pablo
 */
public class UsuarioDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    // Declarar variables del modulo(VO)
    private String id_Usuarios = "", Nombre = "", Documento = "", Telefono = "",
            Email = "", Direccion = "", Estado = "", Contrasena = "";

    //Llave Encriptacion de Contraseña
    private String llave = "SuiteFactor";

    public UsuarioDAO() {
    }

    //2. Crear metodo principal para recibir los datos del VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        //3. Conectarse a la base de datos
        try {

            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            id_Usuarios = usuVO.getIdUsuarios();
            Nombre = usuVO.getNombre();
            Documento = usuVO.getDocumento();
            Telefono = usuVO.getTelefono();
            Email = usuVO.getEmail();
            Direccion = usuVO.getDireccion();
            Estado = usuVO.getEstado();
            Contrasena = usuVO.getContrasena();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            //Armar sentencia
            sql = "insert into usuarios( Nombre, Documento, Telefono, Email, Direccion, Contrasena)"
                    + "values (?,?,?,?,?,?)";
            // crear el camino por donde va la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Nombre);
            puente.setString(2, Documento);
            puente.setString(3, Telefono);
            puente.setString(4, Email);
            puente.setString(5, Direccion);
            puente.setString(6, Encriptar(Contrasena));
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {

        try {
            sql = " update usuarios set Nombre = ?, Documento = ?, Telefono = ?, Email = ?"
                    + ", Direccion = ?, Estado = ?, Contrasena = ? where id_Usuarios = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Nombre);
            puente.setString(2, Documento);
            puente.setString(3, Telefono);
            puente.setString(4, Email);
            puente.setString(5, Direccion);
            puente.setString(6, Estado);
            puente.setString(7, Contrasena);
            puente.setString(8, id_Usuarios);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {

        try {
            sql = "UPDATE `usuarios` SET `Estado`= 0 WHERE Id_usuarios = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_Usuarios);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public UsuarioVO iniciarSesion(String Documento, String Contrasena) {

        UsuarioVO usuVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios where Documento = ? and Contrasena = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Documento);
            puente.setString(2, Contrasena);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return usuVO;

    }

    public UsuarioVO consultaruSUARIO(String Id) {

        UsuarioVO usuVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios where id_usuarios = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return usuVO;

    }

    public ArrayList<UsuarioVO> Listar() {

        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuariosview";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));

                listaUsuarios.add(usuVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioVO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaUsuarios;

    }

    public SecretKeySpec crearClave(String llave) {

        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        } catch (Exception e) {
            return null;
        }

    }

    public String Encriptar(String encriptar) {

        try {
            SecretKeySpec secretKeySpec = crearClave(llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.encode(encriptada);
            return cadena_encriptada;

        } catch (Exception e) {
            return "";
        }
    }

    public String Desencriptar(String desencriptar) {

        try {
            SecretKeySpec secretKeySpec = crearClave(llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] cadena = Base64.decode(desencriptar);
            byte[] desencriptacioon = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacioon);
            return cadena_desencriptada;
        } catch (Exception e) {
            return "";
        }
    }

    public boolean validarContrasena(String Contrasena) {
        final int MAX = 8;
        // Especificando el número de letras mayúsculas en la contraseña
        final int min_Mayus = 1;
        // Especificando el mínimo de minúsculas en la contraseña
        final int min_Minus = 1;
        // Especificando el número de dígitos en una contraseña
        final int num_Numeros = 1;
        // Especificar el número mínimo de letras en mayúsculas y minúsculas
        final int min_CaracterEspecial = 1;
        // Contar el número de letras mayúsculas en una contraseña
        int mayusculas = 0;
        // Contador de letras minúsculas en una contraseña
        int minusculas = 0;
        // Contar numeros en una contraseña
        int numeros = 0;
        // Contar caracteres especiales en una constraseña
        int caracterEspecial = 0;

        for (int i = 0; i < Contrasena.length(); i++) {
            char c = Contrasena.charAt(i);
            if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
            if (c >= 33 && c <= 46 || c == 64) {
                caracterEspecial++;

            }
        }
        if (Contrasena.length() >= MAX && mayusculas >= min_Mayus
                && minusculas >= min_Minus && numeros >= num_Numeros && caracterEspecial >= min_CaracterEspecial) {
            return true; //request.setAttribute("Valida", "Contraseña es Valida");
        } else {

            return false;
        }

    }

    public boolean ValidarNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean enviarCorreoRegistro(String correoDestino) {

        String correo = "suitefactorgestion@gmail.com";
        String contrasena = "qjoy zefu tctf tbyd";

        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", correo);
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);
        MimeMessage mensaje = new MimeMessage(s);
        try {
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
            mensaje.setSubject("Registro");
            mensaje.setText("Usted Se ha registrado en el proyecto de Suitefactor, Gracias!");

            Transport t = s.getTransport("smtp");
            t.connect(correo, contrasena);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();

            return true;
        } catch (Exception e) {

            return false;

        }

    }

    public UsuarioVO RecuperacionContraseña(String Email) {

        UsuarioVO usuVO = null;

        try {
            sql = "select * from usuarios where Email = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Email);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }

        return usuVO;

    }

    public boolean enviarCorreoRecuperacionContraseña(String correoDestino, String codigo) {

        String correo = "suitefactorgestion@gmail.com";
        String contrasena = "qjoy zefu tctf tbyd";

        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", correo);
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);
        MimeMessage mensaje = new MimeMessage(s);
        try {
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
            mensaje.setSubject("Recuperacion Contraseña");
            mensaje.setText("Este es su codigo de Recuperacion de contrseña " + codigo + " No lo comparta con nadie");

            Transport t = s.getTransport("smtp");
            t.connect(correo, contrasena);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();

            return true;
        } catch (Exception e) {

            return false;

        }

    }

    public boolean actualizarContraseña(String id, String contrasena) {

        try {

            sql = " update usuarios set contrasena = ? where id_Usuarios = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, contrasena);
            puente.setString(2, id);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            operacion = false;
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public boolean verificarUsuario(String Documento) {

        UsuarioVO usuVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios where documento = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Documento);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
            }
            if(usuVO==null){
                operacion = false;
            }else{
                operacion = true;
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }
    public String guardarArchivo(Part csvPart, File rutaCarpetaArchivos) {
        String rutaAbsoluta = "";
        try {
            Path ruta = Paths.get(csvPart.getSubmittedFileName());
            String nombreArchivo = ruta.getFileName().toString();
            InputStream input = csvPart.getInputStream();

            if (input != null) {
                File file = new File(rutaCarpetaArchivos, nombreArchivo);
                rutaAbsoluta = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }
            
            return rutaAbsoluta ;

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        
    }
    public void cargar(String rutaAbsoluta) throws SQLException, IOException  {

        try {
            sql = "insert into usuarios( Nombre, Documento, Telefono, Email, Direccion, Contrasena)"
                    + "values (?,?,?,?,?,?)";
            conexion = obtenerConexion();
            FileInputStream file = new FileInputStream(new File(rutaAbsoluta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();
            
            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                
                puente = conexion.prepareStatement(sql);
                puente.setString(1, fila.getCell(0).getStringCellValue());
                puente.setString(2, String.valueOf(fila.getCell(1).getNumericCellValue()));
                puente.setString(3, String.valueOf(fila.getCell(2).getNumericCellValue()));
                puente.setString(4, fila.getCell(3).getStringCellValue());
                puente.setString(5, fila.getCell(4).getStringCellValue());
                puente.setString(6, String.valueOf(fila.getCell(5).getNumericCellValue()));
                puente.execute();
            }
            File buscarArchivo = new File(rutaAbsoluta);
            buscarArchivo.delete();
            conexion = cerrarConexion();

        } catch (FileNotFoundException ex ) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public File validarRuta(){
        String ruta = "web/archivosCargaMasiva";
        File archivoCargas = new File(ruta);
        if(archivoCargas.exists()==true){
            return archivoCargas;
        }else{
            archivoCargas.mkdirs();
            return archivoCargas;
        }
    }

}
