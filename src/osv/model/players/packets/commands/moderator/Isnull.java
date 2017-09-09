package osv.model.players.packets.commands.moderator;

import osv.model.players.Player;
import osv.model.players.PlayerHandler;
import osv.model.players.packets.commands.Command;

public class Isnull extends Command {

	@Override
	public void execute(Player player, String input) {
		Player other = PlayerHandler.getPlayer(input);

		if (other == null) {
			player.sendMessage("The player '" + input + "' is null.");
			return;
		}

		player.sendMessage("Information about... " + input);
		player.sendMessage("Disconnected: " + other.disconnected);
		player.sendMessage("Session null: " + (other.getSession() == null));
		player.sendMessage("Session connected: " + other.getSession().isConnected());
	}

}
