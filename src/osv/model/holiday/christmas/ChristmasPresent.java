package osv.model.holiday.christmas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import osv.event.CycleEvent;
import osv.event.CycleEventContainer;
import osv.event.CycleEventHandler;
import osv.model.items.GameItem;
import osv.model.items.ItemAssistant;
import osv.model.players.Player;
import osv.model.players.PlayerHandler;
import osv.util.Misc;

public class ChristmasPresent extends CycleEvent {

	/**
	 * The item id of the christmas present required to trigger the event
	 */
	public static final int PRESENT = 6542;

	/**
	 * A map containing a List of {@link GameItem}'s that contain items relevant to their rarity.
	 */
	private static Map<Rarity, List<GameItem>> items = new HashMap<>();

	/**
	 * Stores an array of items into each map with the corresponding rarity to the list
	 */
	static {
		items.put(Rarity.COMMON, 
			Arrays.asList(
				new GameItem(21009, 1),
				new GameItem(21028, 1),
					new GameItem(21012, 1),
					new GameItem(20849, 10),
					new GameItem(995, 50000000))
		);
		
	items.put(Rarity.UNCOMMON,
			Arrays.asList(
					new GameItem(21012, 1),
					new GameItem(21015, 1),
					new GameItem(21000, 1),
					new GameItem(21018, 1),
					new GameItem(21021, 1),
					new GameItem(21024, 1),
					new GameItem(20849, 25),
					new GameItem(21003, 1))
			);
	
	items.put(Rarity.RARE,
			Arrays.asList(
					new GameItem(20997, 1),
					new GameItem(20849, 75),
					new GameItem(21003, 1),
					new GameItem(14484, 1),
					new GameItem(21006, 1))
			);
}

	/**
	 * The player object that will be triggering this event
	 */
	private Player player;

	/**
	 * Constructs a new christmas present to handle item receiving for this player and this player alone
	 * 
	 * @param player the player
	 */
	public ChristmasPresent(Player player) {
		this.player = player;
	}

	/**
	 * Random action of obtaining a santa jr pet
	 */
	private void randomPet() {
		if (Misc.random(4) == 1 && player.getItems().getItemCount(20890, true) == 0 && player.summonId != 20890) {
			PlayerHandler.executeGlobalMessage("[<col=CC0000>@cr17@Raids Box</col>] @cr20@ <col=255>" + player.playerName + "</col> hit the jackpot and got an <col=CC0000>Tekton</col> pet from a Raids Box!");
			player.getItems().addItemUnderAnyCircumstance(20851, 1);
		}
	}	
	
	/**
	 * Opens a christmas present if possible, and ultimately triggers and event, if possible.
	 * 
	 * @param player the player triggering the event
	 */
	public void open() {
		if (System.currentTimeMillis() - player.lastMysteryBox < 600 * 2) {
			return;
		}
		if (player.getItems().freeSlots() < 2) {
			player.sendMessage("You need atleast two free slots to open a Raids Box.");
			return;
		}
		if (!player.getItems().playerHasItem(PRESENT)) {
			player.sendMessage("You need a Raids Box to do this.");
			return;
		}
		randomPet();
		player.getItems().deleteItem(PRESENT, 1);
		player.lastMysteryBox = System.currentTimeMillis();
		CycleEventHandler.getSingleton().stopEvents(this);
		CycleEventHandler.getSingleton().addEvent(this, this, 2);
	}

	/**
	 * Executes the event for receiving the christmas present
	 */
	@Override
	public void execute(CycleEventContainer container) {
		if (player.disconnected || Objects.isNull(player)) {
			container.stop();
			return;
		}
		int random = Misc.random(100);
		List<GameItem> itemList = random < 51 ? items.get(Rarity.COMMON) : random > 50 && random < 97 ? items.get(Rarity.UNCOMMON) : items.get(Rarity.RARE);
		GameItem item = Misc.getRandomItem(itemList);
			player.getItems().addItem(item.getId(), item.getAmount());
			player.sendMessage("You receive <col=255>" + item.getAmount() + "x " + ItemAssistant.getItemName(item.getId()) + "</col>.");
			PlayerHandler.executeGlobalMessage("@cr10@" + player.playerName + " has received <col=255>" + item.getAmount() + "x " + ItemAssistant.getItemName(item.getId()) + "</col> from a Raids Box.");
			container.stop();
	}

	/**
	 * Represents the rarity of a certain list of items
	 */
	enum Rarity {
		UNCOMMON, COMMON, RARE
	}

}