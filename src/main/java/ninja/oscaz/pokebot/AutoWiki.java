package ninja.oscaz.pokebot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

public class AutoWiki {

    public static void main(String[] args) {
        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken("Mzc0NjcyMDIwNzc4MTIzMjY0.DUzBXA.1ETwneiK-SVE8Vw2FirfYLP7XH0");
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);

        builder.addEventListener(new MessageListener());

        try {
            JDA jda = builder.buildBlocking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
