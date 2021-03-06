package osv.model.content.achievement;

import java.util.EnumSet;
import java.util.Set;

import osv.model.players.Player;
import osv.model.players.PlayerHandler;
import osv.util.Misc;
/**
 * 
 * @author Jason http://www.rune-server.org/members/jason
 * @date Mar 26, 2014
 */
public class Achievements {
	
	public enum Achievement {
		/**
		 * Tier 1 Achievement Start
		 */
		MR_ROCK(0, AchievementTier.TIER_1, AchievementType.SLAY_ROCK_CRABS, null, "Kill 100 Rock Crabs", 100, 1),
		CHICKEN(1, AchievementTier.TIER_1, AchievementType.SLAY_CHICKENS, null, "Kill 200 Chickens", 200, 1),
		NOVICE_BABY_DRAGON_SLAYER(2, AchievementTier.TIER_1, AchievementType.SLAY_BABY_DRAGONS, null, "Kill 50 Baby Dragons", 50, 1),
		NOVICE_DRAGON_SLAYER(3, AchievementTier.TIER_1, AchievementType.SLAY_DRAGONS, null, "Kill 25 Dragons", 25, 1),
		NPC_KILLER(4, AchievementTier.TIER_1, AchievementType.SLAY_ANY_NPCS, null, "Kill 1000 Npcs", 1000, 1),
		NOVICE_BOSS_KILLER(5, AchievementTier.TIER_1, AchievementType.SLAY_BOSSES, null, "Kill 100 Bosses", 100, 1),
		NOVICE_FISHER(6, AchievementTier.TIER_1, AchievementType.FISH, null, "Catch 1000 Fish", 1000, 1),
		NOVICE_CHEF(7, AchievementTier.TIER_1, AchievementType.COOK, null, "Cook 1000 Fish", 1000, 1),
		NOVICE_MINER(8, AchievementTier.TIER_1, AchievementType.MINE, null, "Mine 1000 Rocks", 1000, 1),
		NOVICE_SMITH(9, AchievementTier.TIER_1, AchievementType.SMITH, null, "Smith 1000 Bars", 1000, 1),
		NOVICE_FARMER(10, AchievementTier.TIER_1, AchievementType.FARM, null, "Pick Herbs 100 Times", 100, 1),
		NOVICE_MIXER(11, AchievementTier.TIER_1, AchievementType.HERB, null, "Mix 500 Potions", 500, 1),
		NOVICE_CHOPPER(12, AchievementTier.TIER_1, AchievementType.WOODCUT, null, "Cut 1000 Trees", 1000, 1),
		NOVICE_FLETCHER(13, AchievementTier.TIER_1, AchievementType.FLETCH, null, "Fletch 1000 Logs", 1000, 1),
		NOVICE_PYRO(14, AchievementTier.TIER_1, AchievementType.FIRE, null, "Light 500 Logs", 500, 1),
		NOVICE_THIEF(15, AchievementTier.TIER_1, AchievementType.THIEV, null, "Steal 500 Times", 500, 1),
		NOVICE_RUNNER(16, AchievementTier.TIER_1, AchievementType.AGIL, null, "Complete 100 Course Laps", 100, 1),
		SLAYER(17, AchievementTier.TIER_1, AchievementType.SLAY, null, "Complete 50 Slayer Tasks", 50, 1),
		LOOT_CHEST(18, AchievementTier.TIER_1, AchievementType.LOOT_CRYSTAL_CHEST, null, "Loot Crystal Chest 50 Times", 50, 1),
		SAVER(19, AchievementTier.TIER_1, AchievementType.PEST_CONTROL_ROUNDS, null, "Complete Pest Control 50 Times", 50, 1),
		TOUGH_GUY(20, AchievementTier.TIER_1, AchievementType.FIGHT_CAVES_ROUNDS, null, "Complete Fightcaves 3 Times", 3, 1),
		HIGH_HITS(21, AchievementTier.TIER_1, AchievementType.BARROWS_RUNS, null, "Loot 100 Barrows Chests", 100, 1),
		CLUE(22, AchievementTier.TIER_1, AchievementType.CLUES, null, "Loot 50 Clue Caskets", 50, 1),
		/**
		 * Tier 2 Achievement Start
		 */
		INTERMEDIATE_BABY_DRAGON_SLAYER(0, AchievementTier.TIER_2, AchievementType.SLAY_BABY_DRAGONS, null, "Kill 400 Baby Dragons", 400, 2),
		INTERMEDIATE_DRAGON_SLAYER(1, AchievementTier.TIER_2, AchievementType.SLAY_DRAGONS, null, "Kill 350 Dragons", 350, 2),
		MURDERER(2, AchievementTier.TIER_2, AchievementType.SLAY_ANY_NPCS, null, "Kill 3000 Npcs", 3000, 2),
		BOSS_MURDERER(3, AchievementTier.TIER_2, AchievementType.SLAY_BOSSES, null, "Kill 700 Bosses", 700, 2),
		INTERMEDIATE_FISHER(4, AchievementTier.TIER_2, AchievementType.FISH, null, "Catch 2500 Fish", 2500, 2),
		INTERMEDIATE_CHEF(5, AchievementTier.TIER_2, AchievementType.COOK, null, "Cook 2500 Fish", 2500, 2),
		INTERMEDIATE_MINER(6, AchievementTier.TIER_2, AchievementType.MINE, null, "Mine 2500 Rocks", 2500, 2),
		INTERMEDIATE_SMITH(7, AchievementTier.TIER_2, AchievementType.SMITH, null, "Smelt/Smith 2500 Bars", 2500, 2),
		INTERMEDIATE_FARMER(8, AchievementTier.TIER_2, AchievementType.FARM, null, "Pick Herbs 300 Times", 300, 2),
		INTERMEDIATE_MIXER(9, AchievementTier.TIER_2, AchievementType.HERB, null, "Mix 1000 Potions", 1000, 2),
		INTERMEDIATE_CHOPPER(10, AchievementTier.TIER_2, AchievementType.WOODCUT, null, "Cut 2500 Trees", 2500, 2),
		INTERMEDIATE_FLETCHER(11, AchievementTier.TIER_2, AchievementType.FLETCH, null, "Fletch 2500 Logs", 2500, 2),
		INTERMEDIATE_PYRO(12, AchievementTier.TIER_2, AchievementType.FIRE, null, "Light 1000 Logs", 1000, 2),
		INTERMEDIATE_THIEF(13, AchievementTier.TIER_2, AchievementType.THIEV, null, "Steal 1000 Times", 1000, 2),
		INTERMEDIATE_RUNNER(14, AchievementTier.TIER_2, AchievementType.AGIL, null, "Complete 250 Course Laps", 250, 2),
		SLAYER_DESTROYER(15, AchievementTier.TIER_2, AchievementType.SLAY, null, "Complete 80 Slayer Tasks", 80, 2),
		CHEST_LOOTER(16, AchievementTier.TIER_2, AchievementType.LOOT_CRYSTAL_CHEST, null, "Loot Crystal Chest 100 Times", 100, 2),
		MR_PORTAL(17, AchievementTier.TIER_2, AchievementType.PEST_CONTROL_ROUNDS, null, "Complete Pest Control 120 Times", 120, 2),
		RED_OF_FURY(18, AchievementTier.TIER_2, AchievementType.FIGHT_CAVES_ROUNDS, null, "Complete Fightcaves 5 Times", 5, 2),
		DHAROKER(19, AchievementTier.TIER_2, AchievementType.BARROWS_RUNS, null, "Loot 300 Barrows Chests", 300, 2),
		CLUE_SCROLLER(20, AchievementTier.TIER_2, AchievementType.CLUES, null, "Loot 120 Clue Caskets", 120, 2),
                
		/**
		 * Tier 3 Achievement Start
		 */
		EXPERT_BABY_DRAGON_SLAYER(0, AchievementTier.TIER_3, AchievementType.SLAY_BABY_DRAGONS, null, "Kill 1000 Baby Dragons", 1000, 3),
		EXPERT_DRAGON_SLAYER(1, AchievementTier.TIER_3, AchievementType.SLAY_DRAGONS, null, "Kill 950 Dragons", 950, 3),
		SLAUGHTERER(2, AchievementTier.TIER_3, AchievementType.SLAY_ANY_NPCS, null, "Kill 10000 Npcs", 10000, 3),
		BOSS_SLAUGHTERER(3, AchievementTier.TIER_3, AchievementType.SLAY_BOSSES, null, "Kill 1500 Bosses", 1500, 3),
		EXPERT_FISHER(4, AchievementTier.TIER_3, AchievementType.FISH, null, "Catch 5000 Fish", 5000, 3),
		EXPERT_CHEF(5, AchievementTier.TIER_3, AchievementType.COOK, null, "Cook 5000 Fish", 5000, 3),
		EXPERT_MINER(6, AchievementTier.TIER_3, AchievementType.MINE, null, "Mine 5000 Rocks", 5000, 3),
		EXPERT_SMITH(7, AchievementTier.TIER_3, AchievementType.SMITH, null, "Smelt/Smith 5000 Bars", 5000, 3),
		EXPERT_FARMER(8, AchievementTier.TIER_3, AchievementType.FARM, null, "Pick Herbs 600 Times", 600, 3),
		EXPERT_MIXER(9, AchievementTier.TIER_3, AchievementType.HERB, null, "Mix 2500 Potions", 2500, 3),
		EXPERT_CHOPPER(10, AchievementTier.TIER_3, AchievementType.WOODCUT, null, "Cut 5000 Trees", 5000, 3),
		EXPERT_FLETCHER(11, AchievementTier.TIER_3, AchievementType.FLETCH, null, "Fletch 5000 Logs", 5000, 3),
		EXPERT_PYRO(12, AchievementTier.TIER_3, AchievementType.FIRE, null, "Light 2500 Logs", 2500, 3),
		EXPERT_THIEF(13, AchievementTier.TIER_3, AchievementType.THIEV, null, "Steal 3000 Times", 3000, 3),
		EXPERT_RUNNER(14, AchievementTier.TIER_3, AchievementType.ROOFTOP, null, "Complete 300 Rooftop Course Laps", 300, 3),
		SLAYER_EXPERT(15, AchievementTier.TIER_3, AchievementType.SLAY, null, "Complete 150 Slayer Tasks", 150, 3),
		DIG_FOR_GOLD(16, AchievementTier.TIER_3, AchievementType.LOOT_CRYSTAL_CHEST, null, "Loot Crystal Chest 200 Times", 200, 3),
		KNIGHT(17, AchievementTier.TIER_3, AchievementType.PEST_CONTROL_ROUNDS, null, "Complete Pest Control 200 Times", 200, 3),
		TZHAAR(18, AchievementTier.TIER_3, AchievementType.FIGHT_CAVES_ROUNDS, null, "Complete Fightcaves 10 Times", 10, 3),
		LOOTER(19, AchievementTier.TIER_3, AchievementType.BARROWS_RUNS, null, "Loot 500 Barrows Chests", 500, 3),
		CLUE_CHAMP(20, AchievementTier.TIER_3, AchievementType.CLUES, null, "Loot 180 Clue Caskets", 180, 3);

		private AchievementTier tier;
		private AchievementRequirement requirement;
		private AchievementType type;
		private String description;
		private int amount, identification, points;
		
		Achievement(int identification, AchievementTier tier, AchievementType type, AchievementRequirement requirement, String description, int amount, int points) {
			this.identification = identification;
			this.tier = tier;
			this.type = type;
			this.requirement = requirement;
			this.description = description;
			this.amount = amount;
			this.points = points;
		}
		
		public int getId() {
			return identification;
		}
		
		public AchievementTier getTier() {
			return tier;
		}
		
		public AchievementType getType() {
			return type;
		}
		
		public AchievementRequirement getRequirement() {
			return requirement;
		}
		
		public String getDescription() {
			return description;
		}
		
		public int getAmount() {
			return amount;
		}
		
		public int getPoints() {
			return points;
		}
		
		public static final Set<Achievement> ACHIEVEMENTS = EnumSet.allOf(Achievement.class);
		
		public static Achievement getAchievement(AchievementTier tier, int ordinal) {
			for(Achievement achievement : ACHIEVEMENTS)
				if(achievement.getTier() == tier && achievement.ordinal() == ordinal)
					return achievement;
			return null;
		}
		
		public static boolean hasRequirement(Player player, AchievementTier tier, int ordinal) {
			for(Achievement achievement : ACHIEVEMENTS) {
				if(achievement.getTier() == tier && achievement.ordinal() == ordinal) {
					if(achievement.getRequirement() == null)
						return true;
					if(achievement.getRequirement().isAble(player))
						return true;
				}
			}
			return false;
		}
	}
	
	public static void increase(Player player, AchievementType type, int amount) {
		for(Achievement achievement : Achievement.ACHIEVEMENTS) {
			if(achievement.getType() == type) {
				if(achievement.getRequirement() == null || achievement.getRequirement().isAble(player)) {
					int currentAmount = player.getAchievements().getAmountRemaining(achievement.getTier().ordinal(), achievement.getId());
					int tier = achievement.getTier().ordinal();
					if(currentAmount < achievement.getAmount() && !player.getAchievements().isComplete(achievement.getTier().ordinal(), achievement.getId())) {
						player.getAchievements().setAmountRemaining(tier, achievement.getId(), currentAmount + amount);
						if((currentAmount + amount) >= achievement.getAmount()) {
							String name = achievement.name().replaceAll("_", " ");
							player.getAchievements().setComplete(tier, achievement.getId(), true);
							player.getAchievements().setPoints(achievement.getPoints() + player.getAchievements().getPoints());
							player.sendMessage("Achievement completed on tier "+(tier + 1)+": '"+achievement.name().toLowerCase().replaceAll("_", " ")+"' and receive "+achievement.getPoints()+" point(s).", 255);
							if(achievement.getTier().ordinal() > 0) {
								for(Player p : PlayerHandler.players) {
									if(p == null)
										continue;
									Player c = p;
									c.sendMessage("@red@[ACHIEVEMENT]@blu@ "+Misc.capitalizeJustFirst(player.playerName)+" @bla@completed the achievement @blu@"+name+" @bla@on tier @blu@"+(tier + 1)+".");
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void reset(Player player, AchievementType type) {
		for(Achievement achievement : Achievement.ACHIEVEMENTS) {
			if(achievement.getType() == type) {
				if(achievement.getRequirement() == null || achievement.getRequirement().isAble(player)) {
					if(!player.getAchievements().isComplete(achievement.getTier().ordinal(), achievement.getId())) {
						player.getAchievements().setAmountRemaining(achievement.getTier().ordinal(), achievement.getId(),
								0);
					}
				}
			}
		}
	}
	
	public static void complete(Player player, AchievementType type) {
		for(Achievement achievement : Achievement.ACHIEVEMENTS) {
			if(achievement.getType() == type) {
				if(achievement.getRequirement() != null && achievement.getRequirement().isAble(player)
						&& !player.getAchievements().isComplete(achievement.getTier().ordinal(), achievement.getId())) {
					int tier = achievement.getTier().ordinal();
					//String name = achievement.name().replaceAll("_", " ");
					player.getAchievements().setAmountRemaining(tier, achievement.getId(), achievement.getAmount());
					player.getAchievements().setComplete(tier, achievement.getId(), true);
					player.getAchievements().setPoints(achievement.getPoints() + player.getAchievements().getPoints());
					player.sendMessage("Achievement completed on tier "+(tier + 1)+": '"+achievement.name().toLowerCase().replaceAll("_", " ")+"' and receive "+achievement.getPoints()+" point(s).", 255);
				}
			}
		}
	}
	
	public static void checkIfFinished(Player player) {
		//complete(player, AchievementType.LEARNING_THE_ROPES);
	}
	
	public static int getMaximumAchievements() {
		return Achievement.ACHIEVEMENTS.size();
	}
}
