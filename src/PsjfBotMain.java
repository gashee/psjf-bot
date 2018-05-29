public class PsjfBotMain {

    public static String game = "League of Legends";

    public static void main(String[] args) throws Exception {

        PsjfBot bot = new PsjfBot();

        bot.setVerbose(true);
        bot.connect("irc.chat.twitch.tv", 6667,
                "oauth:hehexd");
        bot.joinChannel("#thegashee");
    }

}
