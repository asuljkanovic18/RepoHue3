/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamshue.RepoHue3;

import java.io.IOException;

/**
 *
 * @author anels
 */
public class StreamsHue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Weapons w = new Weapons("",CombatTyp.MELEE,DamageTyp.BLUNT,1,2,3,4);
        
        w.Reader("weapons.csv");
    }
    
    
    
}
