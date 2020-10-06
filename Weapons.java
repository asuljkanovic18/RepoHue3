/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamshue.RepoHue3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anels
 */
public class Weapons {
    private String name;
    private CombatTyp combattyp;
    private DamageTyp damagetyp;
    private final int damage;
    private final int speed;
    private final int strength;
    private final int value;

    public Weapons(String name, CombatTyp combattyp, DamageTyp damagetyp, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combattyp = combattyp;
        this.damagetyp = damagetyp;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }
    

    
    
    public void Reader(String files) throws FileNotFoundException, IOException{
        FileReader file = new FileReader(files);
        BufferedReader br = new BufferedReader(file);
        ArrayList<Weapons> weapon = new ArrayList<Weapons>();
        
        String s="";
        try {
            br.readLine();
            while((s = br.readLine()) !=null){
              String[] line = s.split(";");
              String name =  line[0];
              CombatTyp combattyp = CombatTyp.valueOf(line[1].toUpperCase());
              DamageTyp damagetyp = DamageTyp.valueOf(line[2].toUpperCase());
              int damage = Integer.parseInt(line[3]);
              int speed = Integer.parseInt(line[4]);
              int stregth = Integer.parseInt(line[5]);
              int value = Integer.parseInt(line[6]);
              weapon.add(new Weapons(name, combattyp, damagetyp, damage, speed, strength, value));
              
            }
        } catch (IOException ex) {
            Logger.getLogger(Weapons.class.getName()).log(Level.SEVERE, null, ex);
        }
        br.close();
        
        
        
        
        
    }
}
