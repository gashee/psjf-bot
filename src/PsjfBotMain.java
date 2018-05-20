public class PsjfBotMain {

    public static String game = "League of Legends";

    public static void main(String[] args) throws Exception {

        PsjfBot bot = new PsjfBot();

        bot.setVerbose(true);
        bot.connect("irc.chat.twitch.tv", 6667,
                "oauth:fvpfsxglt1fahv64dk8f8uyis5fw4g");
        bot.joinChannel("#thegashee");
    }

}
