package poke;

import java.util.*;

public class Pokemon {
    private Monsters pokemonName;
    private Type typeA;
    private Type typeB;
    private boolean[] status;
    private AttackMove[] MOVE_SET;

    private double battleHP, battleATK, battleDEF, HP;

    private int battleSPD, sleepCounter, pp1, pp2, pp3, pp4;

    private boolean healed;

    private String name, attack1, attack2, attack3, attack4, picName;

    private AttackMove atk1, atk2, atk3, atk4;


    public Pokemon (Monsters name){
       this.pokemonName = name;
       this.battleHP = pokemonName.getHP();
       this.HP = pokemonName.getHP();
       this.battleATK = pokemonName.getATK();
       this.battleDEF = pokemonName.getDEF();
       this.typeA = pokemonName.getTypeA();
       this.typeB = pokemonName.getTypeB();
       this.battleSPD = pokemonName.getSPD();
       this.name = pokemonName.getName();

       this.attack1 = pokemonName.getAttack1().toString();
       this.attack2 = pokemonName.getAttack2().toString();
       this.attack3 = pokemonName.getAttack3().toString();
       this.attack4 = pokemonName.getAttack4().toString();

       this.atk1 = pokemonName.getAttack1();
       this.atk2 = pokemonName.getAttack2();
       this.atk3 = pokemonName.getAttack3();
       this.atk4 = pokemonName.getAttack4();

       this.pp1 = pokemonName.getAttack1().getTotalPP();
       this.pp2 = pokemonName.getAttack2().getTotalPP();
       this.pp3 = pokemonName.getAttack3().getTotalPP();
       this.pp4 = pokemonName.getAttack4().getTotalPP();

       this.MOVE_SET = pokemonName.getMonsterMoveSet();

       this.sleepCounter = 3;

       this.healed = false;

       this.picName = pokemonName.getPicName();


       //Poison, Paralyze, Burn, Freeze, Sleep, Immune, Seed
       status = new boolean[]{false, false, false, false, false, false, false};
        
    }

    public void resetHP(){
        battleHP = HP;
    }

    public void takeDamage(double damage){
        battleHP -= damage;
    }

    public void gainHP(){
        battleHP += 200;
    }

    public void lowerSleepCounter(){
        sleepCounter--;
    }

    public void resetSleepCounter(){
        sleepCounter = 3;
    }

    public String getPokePictureName(){
        return picName;
    }

    public void lowerPP(AttackMove atk){
        for(int i = 0; i < MOVE_SET.length; i++){
            if(MOVE_SET[i].getName().equals(atk.getName())){
                switch(i){
                    case 0:
                        lowerATK1pp();
                        break;
                    case 1:
                        lowerATK2pp();
                        break;
                    case 2:
                        lowerATK3pp();
                        break;
                    default:
                        lowerATK4pp();
                        break;
                }
            }
        }
    }

    public void addPP(AttackMove atk, int pp){
        for(int i = 0; i < MOVE_SET.length; i++){
            if(MOVE_SET[i].getName().equals(atk.getName())){
                switch(i){
                    case 0:
                        addPP1(pp);
                        break;
                    case 1:
                        addPP2(pp);
                        break;
                    case 2:
                        addPP3(pp);
                        break;
                    default:
                        addPP4(pp);
                        break;
                }
            }
        }
    }

    public int checkPP(AttackMove atk){
        int pp = 0;
        for(int i = 0; i < MOVE_SET.length; i++){
            if(MOVE_SET[i].getName().equals(atk.getName())){
                switch(i){
                    case 0:
                        pp = getPP1();
                        break;
                    case 1:
                        pp =  getPP2();
                        break;
                    case 2:
                        pp = getPP3();
                        break;
                    default:
                        pp = getPP4();
                        break;
                }
            }
        }
        return pp;    
    }



    public void setHealedOnce(){
        healed = true;
    }

    private void lowerATK1pp(){
        pp1--;
    }

    private void lowerATK2pp(){
        pp2--;
    }

    private void lowerATK3pp(){
        pp3--;
    }

    private void lowerATK4pp(){
        pp4--;
    }

    private void addPP1(int pp){
        pp1 += pp;
    }

    private void addPP2(int pp){
        pp2 += pp;
    }

    private void addPP3(int pp){
        pp3 += pp;
    }

    private void addPP4(int pp){
        pp4 += pp;
    }

    public Type getTypeA(){
        return typeA;
    }

    public Type getTypeB(){
        return typeB;
    }

    public AttackMove[] getMoveSet(){
        return MOVE_SET;
    }

    public AttackMove getATK1(){
        return atk1;
    }

    public AttackMove getATK2(){
        return atk2;
    }

    public AttackMove getATK3(){
        return atk3;
    }

    public AttackMove getATK4(){
        return atk4;
    }

    private int getPP1(){
        return pp1;
    }

    private int getPP2(){
        return pp2;
    }

    private int getPP3(){
        return pp3;
    }

    private int getPP4(){
        return pp4;
    }

    public boolean fainted(){
        return battleHP <= 0;
    }

    public boolean healedOnce(){
        return healed;
    }

    public double getBattleHP(){
        return battleHP;
    }

    public double getTotalHP(){
        return HP;
    }

    public double getBattleDEF(){
        return battleDEF;
    }

    public double getBattleATK(){
        return battleATK;
    }

    public boolean[] getStatus(){
        return status;
    }

    public int getBattleSPD(){
        return battleSPD;
    }

    public int getSleepCounter(){
        return sleepCounter;
    }

    public String getName(){
        return name;
    }

    public String getFirstAttackString(){
        return attack1;
    }

    public String getSecondAttackString(){
        return attack2;
    }

    public String getThirdAttackString(){
        return attack3;
    }

    public String getFourthAttackString(){
        return attack4;
    }
}