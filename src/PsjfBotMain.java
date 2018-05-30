import java.io.File;
import me.philippheuer.twitch4j.*;

public class PsjfBotMain {

    public static String game = "League of Legends";

    public static void main(String[] args) throws Exception {

    	TwitchClient twitchClient = TwitchClientBuilder.init()
    			.withClientId("eebzjumiflb9g1ygt68mj44l3oosaw")
    			.withClientSecret("s4igwragwskxtns5n00n2b9z0eac9o")
    			.withAutoSaveConfiguration(true)
    			.withConfigurationDirectory(new File("config"))
    			.withCredential("oauth:6ofq7eruad2c8nxkic3cyfj8licka5") // Get your token at: https://twitchapps.com/tmi/
    			.connect();
    }
    
    
}
