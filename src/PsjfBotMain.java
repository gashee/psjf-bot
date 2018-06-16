import me.philippheuer.twitch4j.*;
import me.philippheuer.twitch4j.endpoints.ChannelEndpoint;
import me.philippheuer.twitch4j.endpoints.TMIEndpoint;
import me.philippheuer.twitch4j.model.tmi.Chatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PsjfBotMain {

	
	
    private static void load_creds() {
    	
    	
    	return;
    }
    
    public static void main(String[] args) throws Exception {
    	String client_id = "";
    	String client_secret = "";
    	String oauth = "";
    	String channel = "thegashee";
    	
    	String cred_path = "src/creds.json";
    	JSONParser parser = new JSONParser();
    	try
        {
            Object object = parser
                    .parse(new FileReader(cred_path));
            
            JSONObject jsonObject = (JSONObject)object;
            
            client_id = (String) jsonObject.get("client_id");
            client_secret = (String) jsonObject.get("client_secret");
            oauth = (String) jsonObject.get("oauth");
            
            TwitchClient twitchClient = TwitchClientBuilder.init()
        			.withClientId(client_id)
        			.withClientSecret(client_secret)
        			.withAutoSaveConfiguration(true)
        			.withConfigurationDirectory(new File("config"))
        			.withCredential(oauth)
        			.connect();
            Long channelId = twitchClient.getUserEndpoint().getUserIdByUserName(channel).get();
            ChannelEndpoint channelEndpoint = twitchClient.getChannelEndpoint(channelId);
            channelEndpoint.registerEventListener();
            
            TMIEndpoint tmiEndpoint = twitchClient.getTMIEndpoint();
            Chatter chatter = tmiEndpoint.getChatters(channel);
            for(String user : chatter.getViewers()) {
            	System.out.println("Viewer " + user + " is currently present!");
            }
        }catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    	
    	
    }
    
    
}
