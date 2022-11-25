package poke;

public enum AttackMove {
    // sorry for whoever is looking at this code
    PSYCHIC("Psychic", Type.PSYCHIC, (int) 90, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    FLAMETHROWER("Flamethrower", Type.FIRE, (int) 90, (int) 15, (int) 15, Status.BURN, (int) 10),
    SHOCKWAVE("Shock Wave", Type.ELECTRIC, (int) 60, (int) 20, (int) 20, Status.NORMAL, (int) 100),
    THUNDERBOLT("Thunderbolt", Type.ELECTRIC, (int) 90, (int) 15, (int) 15, Status.PARALYZE, (int) 10),
    SHADOWBALL("Shadow Ball", Type.GHOST, (int) 80, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    FEATHERSTORM("Featherstorm", Type.FLYING, (int) 120, (int) 10, (int) 10, Status.IMMUNE, (int) 100),
    MOONBLAST("Moonblast", Type.FAIRY, (int) 95, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    AURASPHERE("Aura Sphere", Type.FIGHTING, (int) 80, (int) 20, (int) 20, Status.NORMAL, (int) 100),
    DRAGONPULSE("Dragon Pulse", Type.DRAGON, (int) 85, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    BONERUSH("Bone Rush", Type.GROUND, (int) 25, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    POISONJAB("Poison Jab", Type.POISON, (int) 80, (int) 20, (int) 20, Status.POISON, (int) 30),
    HYDROPUMP("Hydro Pump", Type.WATER, (int) 110, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    SCALD("Scald", Type.WATER, (int) 80, (int) 15, (int) 15, Status.BURN, (int) 30),
    DARKPULSE("Dark Pulse", Type.DARK, (int) 80, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    ICEBEAM("Ice Beam", Type.ICE, (int) 90, (int) 10, (int) 10, Status.FREEZE, (int) 10),
    DRILLPECK("Drill Peck", Type.FLYING, (int) 80, (int) 20, (int) 20, Status.NORMAL, (int) 100),
    DISCHARGE("Discharge", Type.ELECTRIC, (int) 80, (int) 15, (int) 15, Status.PARALYZE, (int) 30),
    ZAPCANNON("Zap Cannon", Type.ELECTRIC, (int) 120, (int) 5, (int) 5, Status.PARALYZE, (int) 100),
    HEATWAVE("Heat Wave", Type.FIRE, (int) 95, (int) 10, (int) 10, Status.BURN, (int) 10),
    LEAFSTORM("Leaf Storm", Type.GRASS, (int) 130, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    LEAFBLADE("Leaf Blade", Type.GRASS, (int) 90, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    AERIALACE("Aerial Ace", Type.FLYING, (int) 60, (int) 20, (int) 20, Status.NORMAL, (int) 100),
    AQUATAIL("Aqua Tail", Type.WATER, (int) 90, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    FLASHCANNON("Flash Cannon", Type.STEEL, (int) 80, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    THUNDERWAVE("Thunder Wave", Type.ELECTRIC, (int) 0, (int) 20, (int) 20, Status.PARALYZE, (int) 100),
    BRAVEBIRD("Brave Bird", Type.FLYING, (int) 120, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    HIGHJUMPKICK("High Jump Kick", Type.FIGHTING, (int) 130, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    FIREPUNCH("Fire Punch", Type.FIRE, (int) 75, (int) 15, (int) 15, Status.BURN, (int) 10),
    HEADSMASH("Head Smash", Type.ROCK, (int) 150, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    EARTHQUAKE("Earthquake", Type.GROUND, (int) 100, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    DRAGONCLAW("Dragon Claw", Type.DRAGON, (int) 80, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    STONEEDGE("Stone Edge", Type.ROCK, (int) 100, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    BLIZZARD("Blizzard", Type.ICE, (int) 110, (int) 5, (int) 5, Status.FREEZE, (int) 10),
    ROCKSLIDE("Rock Slide", Type.ROCK, (int) 75, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    MUDSHOT("Mud Shot", Type.GROUND, (int) 55, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    SEEDBOMB("Seed Bomb", Type.GRASS, (int) 80, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    POWERWHIP("Power Whip", Type.GRASS, (int) 120, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    DRAGONBREATH("Dragon Breath", Type.DRAGON, (int) 60, (int) 20, (int) 20, Status.PARALYZE, (int) 30),
    FLAREBLITZ("Flare Blitz", Type.FIRE, (int) 120, (int) 15, (int) 15, Status.BURN, (int) 10),
    MUDDYWATER("Muddy Water", Type.WATER, (int) 90, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    ENERGYBALL("Energy Ball", Type.GRASS, (int) 90, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    SHADOWCLAW("Shadow Claw", Type.GHOST, (int) 70, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    NIGHTSLASH("Night Slash", Type.DARK, (int) 70, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    PERISHSONG("Perish Song", Type.NORMAL, (int) 300, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    AIRSLASH("Air Slash", Type.FLYING, (int) 75, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    EXTRASENSORY("Extrasensory", Type.PSYCHIC, (int) 80, (int) 20, (int) 20, Status.NORMAL, (int) 100),
    GIGAIMPACT("Giga Impact", Type.NORMAL, (int) 150, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    MEGAHORN("Megahorn", Type.BUG, (int) 120, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    OUTRAGE("Outrage", Type.DRAGON, (int) 120, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    SPARKLINGARIA("Sparkling Aria", Type.WATER, (int) 90, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    DAZZLINGGLEAM("Dazzling Gleam", Type.FAIRY, (int) 80, (int) 10, (int) 10, Status.NORMAL, (int) 100),
    INFERNO("Inferno", Type.FIRE, (int) 100, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    CLOSECOMBAT("Close Combat", Type.FIGHTING, (int) 120, (int) 5, (int) 5, Status.NORMAL, (int) 100),
    IRONHEAD("Iron Head", Type.STEEL, (int) 80, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    CRUNCH("Crunch", Type.DARK, (int) 80, (int) 15, (int) 15, Status.NORMAL, (int) 100),
    EVILCONQUERING("Bane of All Evil", Type.FIGHTING, (int) 10000, (int) 1, (int) 1, Status.NORMAL, (int) 100);

    private final String NAME;
    private final Type TYPE;
    private final int POWER, STATUS_CHANCE;
    private int PP, battlePP, ENEMY_PP; // IT STANDS FOR POWER POINTS, THATS IT
    // private final SpecialMove SPEC;
    private final Status SIDE_EFFECT;

    AttackMove(String name, Type type, int power, int pp, int enemyPP, Status sideEffect, int statChance) {
        NAME = name;
        TYPE = type;
        POWER = power;
        PP = pp;
        battlePP = pp;
        ENEMY_PP = enemyPP;
        // SPEC = spec;
        SIDE_EFFECT = sideEffect;
        STATUS_CHANCE = statChance;
    }

    // getters and setters heaven
    public int getPower() {
        return POWER;
    }

    public Status getStatusEffect() {
        return SIDE_EFFECT;
    }

    public int getTotalPP() {
        return PP;
    }

    public int getStatChance() {
        return STATUS_CHANCE;
    }

    public int getBattlePP() {
        return battlePP;
    }

    public int getEnemyPP() {
        return ENEMY_PP;
    }

    public Type getType() {
        return TYPE;
    }

    public String getName() {
        return NAME;
    }

    public void setPP(int pp) {
        battlePP = pp;
    }

    public void resetPP() {
        battlePP = PP;
    }

    public void lowerPP() {
        battlePP--;
    }

    public void lowerEnemyPP() {
        ENEMY_PP--;
    }

    public void addPP(int pp) {
        battlePP += pp;

        // this is to make sure pp doesn't go over the limit
        if (pp - battlePP < 0) {
            battlePP = pp;
        }
    }

    public void addEnemyPP(int pp) {
        ENEMY_PP += pp;

        if (pp - ENEMY_PP < 0) {
            ENEMY_PP = pp;
        }
    }

    public void resetEnemyPP() {
        ENEMY_PP = PP;
    }

}