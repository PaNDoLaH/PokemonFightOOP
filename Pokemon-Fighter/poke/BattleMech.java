
package poke;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class BattleMech {
    public static ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
    public static ArrayList<Pokemon> enemyTeam = new ArrayList<Pokemon>();

    private static int healPotion = 5, enemyHealPotion = 5,
            ppRestore = 5, enemyPPRestore = 5,
            fullHeal = 5, enemyFullHeal = 5,
            switchCooldown = 2;
    private static boolean pokeSwitch = false, skipTurn = false;
    private static AttackMove attackSelected, enemyAttack;

    Random r = new Random();

    public static void main(String[] args) {
        new Thread(new PokeGui()).start();
    }

    public String getHealPotionCount() {
        return String.valueOf(healPotion);
    }

    public void lowerHealPotion() {
        healPotion--;
    }

    public String getPPRestoreCount() {
        return String.valueOf(ppRestore);
    }

    public void lowerPPRestore() {
        ppRestore--;
    }

    // method used for move priority
    public String battleOrder(Pokemon first, AttackMove firstMove, Pokemon second, AttackMove secondMove) {
        String str = first.getName() + " used " + firstMove.getName();
        double firstDamage = calculateAttack(first, second, firstMove),
                secondDamage = calculateAttack(second, first, secondMove);

        str += "\n" + battleStatusPrint(first);

        if (!skipTurn) {
            str += "\n" + first.getName() + " deals " + firstDamage + " damage to " + second.getName();
            second.takeDamage(firstDamage);

            // check type effectiveness to print messages
            double d = typeEffectiveness(second, firstMove);

            if (d == 0) {
                str += "\nIt has no effect on " + second.getName();
            } else if (d < 1) {
                str += "\n It's not very effective";
            } else if (d > 1) {
                str += "\nIt's super effective";
            }

            if (second.fainted()) {
                str += "\n" + second.getName() + " fainted";
                str += damageStatusPrint(first);
                first.lowerPP(firstMove);
                return str + "\n";
            }

            // only apply status if the attack has effect on the defending pokemon
            if (d != 0) {
                if (rollStatusEffect(firstMove)) {
                    applyStatus(firstMove, second, first);
                    if (firstMove.getStatusEffect() != Status.NORMAL && firstMove.getStatusEffect() != Status.IMMUNE) {
                        str += "\n" + firstMove.getStatusEffect() + " is applied on " + second.getName();
                    }
                }
            }

        } else {
            skipTurn = false;
        }

        str += "\n" + battleStatusPrint(second);

        if (!skipTurn) {

            str += "\n" + second.getName() + " used " + secondMove.getName();

            str += "\n" + second.getName() + " deals " + secondDamage + " damage to " + first.getName();
            first.takeDamage(secondDamage);

            double f = typeEffectiveness(first, secondMove);

            if (f == 0) {
                str += "\nIt has no effect on " + first.getName();
            } else if (f < 1) {
                str += "\n It's not very effective";
            } else if (f > 1) {
                str += "\nIt's super effective";
            }

            if (first.fainted()) {
                str += "\n" + first.getName() + " fainted \n";
                str += damageStatusPrint(second); // second pokemon takes damage regardless if it kills another pokemon

                first.lowerPP(firstMove);
                second.lowerPP(secondMove);
                return str + "\n";
            }

            if (f != 0) {
                if (rollStatusEffect(secondMove)) {
                    applyStatus(secondMove, first, second);
                    if (secondMove.getStatusEffect() != Status.NORMAL
                            && secondMove.getStatusEffect() != Status.IMMUNE) {
                        str += "\n" + secondMove.getStatusEffect() + " is applied on " + first.getName();
                    }
                    // TODO
                }
            }
        } else {
            skipTurn = false;
        }

        first.lowerPP(firstMove);
        second.lowerPP(secondMove);

        // enemyAttack.lowerEnemyPP();

        System.out.println(damageStatusPrint(first));
        System.out.println(damageStatusPrint(second));

        return str + "\n";
    }

    // used for when one pokemon is not fighting (healing/swapping)
    public final String oneSidedFight(Pokemon attacker, Pokemon defender, AttackMove used) {
        String str = "\n" + attacker.getName() + " used " + used.getName();
        double damage = calculateAttack(attacker, defender, used);
        battleStatusPrint(attacker);

        // if(!skipTurn){
        str += "\n" + attacker.getName() + " deals " + damage + " to " + defender.getName();
        defender.takeDamage(damage);

        double e = typeEffectiveness(defender, used);

        if (e == 0) {
            str += "\nIt has no effect on " + defender.getName();
        } else if (e < 1) {
            str += "\nIt's not very effective";
        } else if (e > 1) {
            str += "\nIt's super effective";
        }

        if (e != 0) {
            if (rollStatusEffect(used)) {
                applyStatus(used, defender, attacker);
                if (used.getStatusEffect() != Status.NORMAL) {
                    str += "\n" + used.getStatusEffect() + " is applied on " + defender.getName();
                }
            }
        }

        attacker.lowerPP(used);

        str += "\n" + damageStatusPrint(attacker);

        if (defender.fainted()) {
            str += "\n" + defender.getName() + " fainted";
            return str;
        }

        str += "\n" + (damageStatusPrint(defender));

        return str;
    }

    // print status effects that affect how pokemon fights
    private final String battleStatusPrint(Pokemon user) {
        String str = "";
        // paralyze
        if (user.getStatus()[1]) {
            if (r.nextInt(4) + 1 == 3) { // 25% chance of paralysis
                str += "\n" + user.getName() + " is paralyzed!";
                skipTurn = true;
            }
            // frozen
        } else if (user.getStatus()[3]) {
            if (r.nextInt(100) + 1 <= 20) { // 10% chance to break out of frozen
                str += "\n" + user.getName() + " is no longer frozen!";
                skipTurn = false;
                user.getStatus()[3] = false;
            } else {
                str += "\n" + user.getName() + " is frozen!";
                skipTurn = true;
            }
            // sleep
        } else if (user.getStatus()[4]) {
            if (user.getSleepCounter() > 0) { // if sleep timer hasnt gone down yet
                str += "\n" + user.getName() + " is asleep!";
                user.lowerSleepCounter();
                skipTurn = true;
            } else {
                str += "\n" + user.getName() + " awakened from its slumber!";
                user.getStatus()[4] = false;
                skipTurn = false;
            }
            // immune
        }
        // work on other status effects

        return str;
    }

    // print status effects that do damage to pokemon
    private final String damageStatusPrint(Pokemon user) {
        String str = "";
        // multiple if statements because the effects can stack
        if (user.getStatus()[0]) {
            double poisonDamage = Math.floor(user.getTotalHP() / 16);
            str += user.getName() + " is poisoned!";
            user.takeDamage(poisonDamage);
        }

        if (user.getStatus()[2]) {
            double burnDamage = Math.floor(user.getTotalHP() / 8);
            str += user.getName() + " is burnt!";
            user.takeDamage(burnDamage);
        }

        return str;

    }

    public double calculateAttack(Pokemon attacker, Pokemon defender, AttackMove used) {
        double power = used.getPower();
        double battleATK = attacker.getBattleATK();
        double battleDEF = attacker.getBattleDEF();
        // double def = defender.getDEF();
        double armorpen = battleATK / battleDEF;
        double damageTaken = 0.5 * power * armorpen * typeEffectiveness(defender, used); // https://gamepress.gg/pokemongo/damage-mechanics\

        double finalDMG = Math.floor(damageTaken) + 1;

        return finalDMG;

    }

    // calculate the type effectiveness multiplier
    public double typeEffectiveness(Pokemon defender, AttackMove used) {
        double typeEff = 1;

        // for (Type t : defender.getTypeA()){
        if (used.getType().isSuperEffectiveAgainst(defender.getTypeA())) {
            // System.out.println("It was super effective!");
            typeEff *= 2;
        } else if (used.getType().isNotVeryEffectiveAgainst(defender.getTypeA())) {
            // System.out.println("It was not very effective...");
            typeEff *= 0.5;
        } else if (used.getType().hasNoEffectOn(defender.getTypeA())) {
            // System.out.println("It had no effect!");
            typeEff *= 0;
        }
        // }

        // for pokemon that only have a single type
        if (defender.getTypeB() == Type.NULLTYPE) {
            return typeEff;
        }

        // secondary types
        // for (Type t : defender.getTypeB()){
        if (used.getType().isSuperEffectiveAgainst(defender.getTypeB())) {
            typeEff *= 2;
        } else if (used.getType().isNotVeryEffectiveAgainst(defender.getTypeB())) {
            typeEff *= 0.5;
        } else if (used.getType().hasNoEffectOn(defender.getTypeB())) {
            typeEff *= 0;
        }
        // }
        return typeEff;
    }

    private void applyStatus(AttackMove used, Pokemon defender, Pokemon attacker) {
        final Status s = used.getStatusEffect();

        switch (s) {
            case POISON:
                defender.getStatus()[0] = true;
                break;
            case PARALYZE:
                defender.getStatus()[1] = true;
                break;
            case BURN:
                defender.getStatus()[2] = true;
                break;
            case FREEZE:
                defender.getStatus()[3] = true;
                break;
            case SLEEP:
                defender.getStatus()[4] = true;
                break;
            case IMMUNE:
                attacker.getStatus()[5] = true;
                break;
            case SEED:
                defender.getStatus()[6] = true;
                break;
            default: // NORMAL status effect
                break;
        }
    }

    // used to check if status effect is applied
    private boolean rollStatusEffect(AttackMove used) {

        int randInt = r.nextInt(100) + 1; // generate number from 1-100

        if (randInt <= used.getStatChance()) { // ex: There is a 30% chance of getting a number within 1-30 inside 100
                                               // numbers
            return true;
        }

        return false;
    }

    private void healPokemon(Pokemon pokemonHealed) {
        pokemonHealed.gainHP();
    }

    // https://hackaday.com/wp-content/uploads/2014/05/pokemon-decisiontree.png
    public String trainerAI(Pokemon myPoke, Pokemon enemyPoke, ArrayList<Pokemon> enemyTeam) {
        double threshold = enemyPoke.getTotalHP() * 0.4; // find 40% of maximum hp
        boolean moveAvailable = false, healthSwitch = false;
        String action = "";

        if (enemyPoke.getBattleHP() <= threshold) { // if fielded pokemon is below 40% health
            System.out.println("Below Threshold!");
            if (enemyHealPotion > 0 && !enemyPoke.healedOnce()) { // if enemy still have potions
                // healPokemon(enemyTeam.get(0));
                action = "heal";
                // System.out.println("\nEnemy healed " + enemyTeam.get(0).getName());
                enemyHealPotion--;
                enemyPoke.setHealedOnce();
                enemyPoke.gainHP();

                if (switchCooldown > 0) {
                    switchCooldown--;
                }

            } else if (switchCooldown == 0) {
                // switch to pokemon that will take the least damage

                // search for pokemon that will take least damage based on pokemon's type
                for (Pokemon p : enemyTeam) {
                    if (!p.fainted() && !p.getName().equals(enemyPoke.getName()) && p.getBattleHP() > threshold) {
                        if (p.getTypeA().isSuperEffectiveAgainst(myPoke.getTypeA())
                                || p.getTypeB().isSuperEffectiveAgainst(myPoke.getTypeA())
                                || p.getTypeA().isSuperEffectiveAgainst(myPoke.getTypeB())
                                || p.getTypeB().isSuperEffectiveAgainst(myPoke.getTypeB())) {
                            action = "swap" + p.getName();
                            healthSwitch = true;

                            switchCooldown++;
                            break;
                        }
                    }
                }

                // desperate times, desperate measures
                if (!healthSwitch) {
                    double max = enemyPoke.getBattleHP();

                    System.out.println("healthswitch");

                    if (enemyTeam.get(1).getBattleHP() > max) {
                        max = enemyTeam.get(1).getBattleHP();
                    }
                    if (enemyTeam.get(2).getBattleHP() > max) {
                        max = enemyTeam.get(2).getBattleHP();
                    }
                    if (enemyTeam.get(3).getBattleHP() > max) {
                        max = enemyTeam.get(3).getBattleHP();
                    }
                    if (enemyTeam.get(4).getBattleHP() > max) {
                        max = enemyTeam.get(4).getBattleHP();
                    }
                    if (enemyTeam.get(5).getBattleHP() > max) {
                        max = enemyTeam.get(5).getBattleHP();
                    }

                    for (Pokemon p : enemyTeam) {
                        if (max == p.getBattleHP() && !p.getName().equals(enemyPoke.getName())) {
                            // System.out.println(enemyTeam.get(0).getName() + " switch with " +
                            // p.getName());
                            // Collections.swap(enemyTeam, 0, enemyTeam.indexOf(p));
                            action = "swap" + p.getName();
                            switchCooldown++;
                        } else {
                            action = maxDamageAttack(myPoke, enemyPoke);
                        }
                    }

                    healthSwitch = false;
                }

                // switchCooldown--;
                // if can't switch due to cooldown, find most damage move and full send
            } else {

                switchCooldown--;
                action = maxDamageAttack(myPoke, enemyPoke);
            }
        } else {
            // loop through current pokemon's available moveset
            for (AttackMove mov : enemyPoke.getMoveSet()) {
                if (typeEffectiveness(myPoke, mov) >= 1) { // if move is able to do neutral or supereffective damage
                    if (enemyTeam.get(0).checkPP(mov) > 0) {
                        // enemyAttack = mov;
                        // mov.lowerPP();
                        action = mov.getName();

                        enemyTeam.get(0).lowerPP(mov);
                        moveAvailable = true;

                        if (switchCooldown > 0) {
                            switchCooldown--;
                        }
                        break;
                    }
                }
            }

            // if all moves are not effective against opponent, switch to healthy pokemon
            // that has effective moves
            if (!moveAvailable && switchCooldown == 0) {
                for (Pokemon p : enemyTeam) {
                    if (p.getTypeA().isSuperEffectiveAgainst(myPoke.getTypeA())
                            || p.getTypeB().isSuperEffectiveAgainst(myPoke.getTypeA())
                            || p.getTypeA().isSuperEffectiveAgainst(myPoke.getTypeB())
                            || p.getTypeB().isSuperEffectiveAgainst(myPoke.getTypeB())) {
                        if (p.getBattleHP() > (p.getTotalHP() * 0.4)) {
                            // System.out.println(enemyTeam.get(0).getName() + " switch with " + p.getName()
                            // + " moveSwitch");
                            // Collections.swap(enemyTeam, 0, enemyTeam.indexOf(p));
                            action = "swap" + p.getName();

                            if (switchCooldown < 2) {
                                switchCooldown++;
                            }
                        } else {
                            action = maxDamageAttack(myPoke, enemyPoke);

                            if (switchCooldown > 0) {
                                switchCooldown--;
                            }
                        }
                    }
                }
                // find move that does most damage and full send
            } else if (!moveAvailable && switchCooldown > 0) {
                action = maxDamageAttack(myPoke, enemyPoke);

                if (switchCooldown > 0) {
                    switchCooldown--;
                }
            }
        }

        // reset conditions
        healthSwitch = false;
        moveAvailable = false;

        return action;
    }

    private String maxDamageAttack(Pokemon myPoke, Pokemon enemyPoke) {
        System.out.println("Calculating Max Attack");
        double maxDamage = calculateAttack(enemyPoke, myPoke, enemyPoke.getATK1());
        AttackMove maxMove = null;

        if (enemyPoke.checkPP(enemyPoke.getATK1()) > 0) {
            maxMove = enemyPoke.getATK1();
        } else {
            maxDamage = 0;
        }

        if (calculateAttack(enemyPoke, myPoke, enemyPoke.getATK2()) >= maxDamage
                && enemyPoke.checkPP(enemyPoke.getATK2()) > 0) {
            maxDamage = calculateAttack(enemyPoke, myPoke, enemyPoke.getATK2());
            maxMove = enemyPoke.getATK2();
        }
        if (calculateAttack(enemyPoke, myPoke, enemyPoke.getATK3()) >= maxDamage
                && enemyPoke.checkPP(enemyPoke.getATK3()) > 0) {
            maxDamage = calculateAttack(enemyPoke, myPoke, enemyPoke.getATK3());
            maxMove = enemyPoke.getATK3();
        }
        if (calculateAttack(enemyPoke, myPoke, enemyPoke.getATK4()) >= maxDamage
                && enemyPoke.checkPP(enemyPoke.getATK4()) > 0) {
            maxDamage = calculateAttack(enemyPoke, myPoke, enemyPoke.getATK4());
            maxMove = enemyPoke.getATK4();
        }

        return maxMove.getName();
    }

    public void setAttackSelected(AttackMove atk) {
        attackSelected = atk;

    }

}