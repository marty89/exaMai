/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.dto;

import be.esi.alg2.dto.Dto;

/**
 *
 * Dto d'un arbre binaire se contentant de porter le nom de l'arbre
 */
public class ArbreDto extends Dto<String>{
    public ArbreDto(String s){
        id=s;
    }

    @Override
    public String toString() {
        return "ArbreDto{" + id+'}';
    }

    
    
}
