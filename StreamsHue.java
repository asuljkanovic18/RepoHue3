/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamshue.RepoHue3;

import java.io.IOException;
import java.util.List;
import streamshue.RepoHue3.Weapons.Printable;

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
        
        printsorted();
        printtable();
        
    }
    
    public static void printsorted(){
        Printable print = (List<Weapons> weapon) -> {
            for (Weapons weapons : weapon) {
                System.out.println(weapons.sorted().toString()); 
            }
        };
    }
    
    public static void printtable(){
        Printable print = (List<Weapons> weapon) -> {
            for (Weapons weapons : weapon) {
                System.out.println(weapons.getName() +"  |   "+ weapons.getCombattyp()+"  |   "+ weapons.getDamagetyp()+"  |   "+ weapons.getDamage()+"  |   "
                        + weapons.getStrength()+"  |   "+ weapons.getSpeed()+"  |   "+ weapons.getValue()); 
            }
        };
    }
    
    public static void s(){
        
    }
    
}
