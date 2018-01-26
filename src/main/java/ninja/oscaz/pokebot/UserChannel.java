package ninja.oscaz.pokebot;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public class UserChannel {

    public final User user;
    public final TextChannel channel;

    public UserChannel(User user, TextChannel channel) {
        this.user = user;
        this.channel = channel;
    }

}
