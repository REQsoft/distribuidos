/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materias;

import Modelos.Materia;
import Modelos.Materias;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;

/**
 *
 * @author MARIO-PC
 */
@WebService(serviceName = "Service1")
public class Service1 {

    @WebMethod(operationName = "Consultar_codigo")
    public String consulta_codigo(@WebParam(name = "codigo_materia") String codigo) throws JAXBException {
        List<Materia> lista_materias = new ArrayList<>();
        Materias materias = new Materias();
        Conexion conexion = new Conexion("root", "", "materias");
        Connection cnx = conexion.tryConection();
        String query;

        query = "select * from materias where codigo=" + codigo;

        if (cnx != null) {
            try {
                Statement s = cnx.createStatement();
                ResultSet resultado = s.executeQuery(query);
                while (resultado.next()) {
                    String cod = resultado.getString("codigo");
                    String nom = resultado.getString("nombre");
                    Materia materia = new Materia(cod, nom);
                    lista_materias.add(materia);
                }

            } catch (SQLException e) {
                return "";
            }
        }
        materias.setMaterias(lista_materias);
        CadenaXML xml = new CadenaXML(materias);
        return xml.estructurarXML();
    }

    @WebMethod(operationName = "consultar_nombre")
    public String consulta_nombre(@WebParam(name = "nombre_materia") String nombre) throws JAXBException {
        List<Materia> lista_materias = new ArrayList<>();
        Materias materias = new Materias();
        Conexion conexion = new Conexion("root", "", "materias");
        Connection cnx = conexion.tryConection();
        String query;
        if (nombre != null) {
            query = "select * from materias where nombre like '" + nombre + "%'";
        } else {
            query = "select * from materias";
        }

        if (cnx != null) {
            try {
                Statement s = cnx.createStatement();
                ResultSet resultado = s.executeQuery(query);
                while (resultado.next()) {
                    String cod = resultado.getString("codigo");
                    String nom = resultado.getString("nombre");
                    Materia materia = new Materia(cod, nom);
                    lista_materias.add(materia);
                }

            } catch (SQLException e) {
                return "";
            }
        }
        materias.setMaterias(lista_materias);
        CadenaXML xml = new CadenaXML(materias);
        return xml.estructurarXML();
    }
}
