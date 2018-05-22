/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARIO-PC
 */
@XmlRootElement
public class Materias {
    List<Materia> materias;

    public List<Materia> getMaterias() {
        return materias;
    }
    
    @XmlElement
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    
    
}
