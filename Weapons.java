/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamshue.RepoHue3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anels
 */
public class Weapons{
    private String name;
    private CombatTyp combattyp;
    private DamageTyp damagetyp;
    private final int damage;
    private final int speed;
    private final int strength;
    private final int value;
    ArrayList<Weapons> weapon = new ArrayList<Weapons>();

    public Weapons(String name, CombatTyp combattyp, DamageTyp damagetyp, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combattyp = combattyp;
        this.damagetyp = damagetyp;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    Weapons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Weapons> getWeapon() {
        return weapon;
    }
    
    

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public CombatTyp getCombattyp() {
        return combattyp;
    }

    public DamageTyp getDamagetyp() {
        return damagetyp;
    }
    
    
    
    
    public void Reader(String files) throws FileNotFoundException, IOException{
        FileReader file = new FileReader(files);
        BufferedReader br = new BufferedReader(file);
        
        
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
              int strength = Integer.parseInt(line[5]);
              int value = Integer.parseInt(line[6]);
              weapon.add(new Weapons(name, combattyp, damagetyp, damage, speed, strength, value));
              
            }
        } catch (IOException ex) {
            Logger.getLogger(Weapons.class.getName()).log(Level.SEVERE, null, ex);
        }
        br.close();
    }
    
    public ArrayList<Weapons> damagesort(){
       weapon.sort((d1, d2) -> d1.getDamage() - d2.getDamage());
       return weapon;
    }
    
    public ArrayList<Weapons> sorted(){
        weapon.sort((c1, c2) -> c1.getCombattyp().compareTo(c2.getCombattyp()));
        for (int i = 0; i < weapon.size(); i++) {
            if(weapon.get(i).getCombattyp().equals(weapon.get(i+1).getCombattyp())){
                weapon.sort((d1, d2) -> d1.getDamagetyp().compareTo(d2.damagetyp));
                if(weapon.get(i).getDamagetyp().equals(weapon.get(i).getDamagetyp())){
                    weapon.sort((n1, n2) -> n1.getName().compareTo(n2.name));
                }
            }
        }
        return weapon;
    }

    @Override
    public String toString() {
        return "Weapons{" + "name=" + name + ", combattyp=" + combattyp + ", damagetyp=" + damagetyp + ", damage=" + damage + ", speed=" + speed + ", strength=" + strength + ", value=" + value + ", weapon=" + weapon + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.combattyp);
        hash = 37 * hash + Objects.hashCode(this.damagetyp);
        hash = 37 * hash + this.damage;
        hash = 37 * hash + this.speed;
        hash = 37 * hash + this.strength;
        hash = 37 * hash + this.value;
        hash = 37 * hash + Objects.hashCode(this.weapon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Weapons other = (Weapons) obj;
        if (this.damage != other.damage) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (this.strength != other.strength) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.combattyp != other.combattyp) {
            return false;
        }
        if (this.damagetyp != other.damagetyp) {
            return false;
        }
        if (!Objects.equals(this.weapon, other.weapon)) {
            return false;
        }
        return true;
    }
    
    
    
    public interface Printable{
        void print(List<Weapons> weapons);
    }
}
