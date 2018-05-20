import org.jibble.pircbot.PircBot;

public class PsjfBot extends PircBot {

    public PsjfBot() {
        this.setName("TheGashee");
        this.isConnected();
    }

    @Override
    public void onJoin(String channel, String sender, String login,
            String hostname) {
        this.sendMessage(channel, "Welcome " + sender + "!");
    }

    @Override
    public void onMessage(String channel, String sender, String login,
            String hostname, String message) {

        if (message.equalsIgnoreCase("!game")) {
            this.sendMessage(channel,
                    "The current game is " + PsjfBotMain.game + ".");
        } else if (message.equalsIgnoreCase("!battle")) {
            this.sendMessage(channel, "Executing Battle!");
        } else if (message.equalsIgnoreCase("Bye!")) {
            this.sendMessage(channel, "Okay. See you next time!");
        }

    }
}
