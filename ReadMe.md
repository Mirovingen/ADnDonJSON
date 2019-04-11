# Basis for TelegramRPG with whole logic stored in JSon file.
For now all inputs reads from console ising Scanner, in furure this will be changed to TelegramBotsAPI input
Examples of code

-- JsonToken opens parseme.json and provides JSONObject for anothe classes
public static final JSONObject GetjObj() { return jobj; }

--static fabrical methods NewHero, NewMonster using for constructing

Hero hero = Hero.NewHero(getInput(), "Ork", "Wizard");  -- Creating hero with console input name

String Race  = level.getJSONArray("Monsters").getJSONObject(0).getString("Race");
String Class = level.getJSONArray("Monsters").getJSONObject(0).getString("Class");
Monster monster = Monster.NewMonster("Braa", Race, Class); -- Creating monster using RACE and CLASS from Json

--Both methods use composition with Creature.class calling 
private final Creature creature;
this.creature = new Creature.builder().Race(Race).Class(Class).build();  -- Using [builder] pattern to constract creature object

--Init Dungeon using kind of [singletone] pattern to garanty that only one Dungeon can exist 
Dungeon dungeon = Dungeon.GetInstance();

-- Entering Dungeon
Hero.Enter(dungeon)

-- Level.Next() and Dungeoon.getEnter() return new Level object
Hero.getCurrent_level().Next()

-- Moving Hero to new level
Hero.moveTo(Hero.getCurrent_level().Next());
-- in next level is EXIT Next() return null

-- Explore checks current level for existing monsters and call Fight if found
Hero.getCurrent_level().Explore();

-- Fight is early realization for fighting engine, gonna be changed
-- For now it alternatively stores Damage and Heal into status.class and apply to hero/monster HP


parseme.json sheme

{
  "Unique_id"      : 18233983182312,          -- integer unique id
  "Game_name"      : "GAMENAME",              -- string game name
  "Max_players"    : 4,                       -- integer count

  "Dungeon" :
  {
    "Dungeon_name" : "DUNGEONNAME",           -- string Dungeon_name
    "Dungeon_id"   : 48269817098,             -- integer dungeon_id
    "BIOM"         : ["grass, stone, fire"],  -- not using
    "Start_lvl"    : "0x000000",              -- string id of enter lvl from [Levels]
    "End_lvl"      : "0x00000F"               -- string id of last lvl from [Levels]
  },
  
  "Levels"  : {
    "0x000000" : {                            -- string Level_id
      "Level_name" : "Start level",           -- string Level_name
      "Exits"      : ["0x000001", "0x000002"],-- Level_id[] list of possible exits 
      "Monsters"   : []                       -- monsters[] list of monsters {"Race"  : from Creatures.Template, 
    },                                                                        "Class" : from Classes.Template } 
    "0x000001" : {
      "Level_name" : "level 1",
      "Exits"      : ["0x00000F"],
      "Monsters"   : [{"Race" :  "Ork", "Class" : "Warrior"}]
    },
    "0x000002" : {
      "Level_name" : "level 2",
      "Exits"      : ["0x00000F"],
      "Monsters"   : [{"Race" :  "Ork", "Class" : "Warrior"}]
    },
    "0x00000F" : {
      "Level_name" : "Last Level",
      "Exits"      : ["Exit"],                -- Mark of last level of Dungeon
      "Monsters"   : []
    }
    },
    
   "Creatures" : {
      "Template" : [                          -- templates using to construct creaturs 
        { "Race"  : "Human",
          "INT"   : 3,
          "STR"   : 3,
          "AGL"   : 3
        },
        { "Race"  : "Elf",
          "INT"   : 4,
          "STR"   : 1,
          "AGL"   : 4
        },
        { "Race"  : "Ork",
          "INT"   : 1,
          "STR"   : 3,
          "AGL"   : 2
        }
      ]
    },

  "Classes" : {                                 -- templates using to construct creaturs 
    "Template" : ["Wizard", "Warrior", "Rogue"]
  },
  
  "Skills" : {                                  -- not using
    "Wizard"  : ["Skill_1","Skill_2"],
    "Warrior" : ["", ""],
    "Rogue"   : ["", ""],
    "All"     : [""]
  },

  "Skills_desc" : {                             -- not using
    "Skill_1" : {
      "Target" : "Enemy",
      "Count"  : "1",
      "Damage" : 10,
      "Heal"   : 0,
      "Buff"   : [0,0,0]
    },
    "Skill_2" : {
      "Target" : "Ally",
      "Count"  : "1",
      "Damage" : 0,
      "Heal"   : 10,
      "Buff"   : [0,0,0]
    }
  
  
}
