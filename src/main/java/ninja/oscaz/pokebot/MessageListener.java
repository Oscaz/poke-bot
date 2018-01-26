package ninja.oscaz.pokebot;

import java.util.Arrays;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        String content = event.getMessage().getContentRaw();
        if (content.startsWith("!pokemon")) {
            if (!(content.split(" ").length < 3)) {
                event.getTextChannel().sendMessage("Usage: !pokemon <pokemon>").queue();
                return;
            }

            this.dispatchQuery(event.getAuthor(), event.getTextChannel(), Arrays.copyOfRange(content.split(" "), 1, content.split(" ").length));
            event.getTextChannel().sendTyping().queue();
        }
    }

    private void dispatchQuery(User sender, TextChannel channel, String[] args) {
        String query = StringUtils.join(args, ' '); // Join args with spaces to allow multi-word queries
        new LookupDispatcher(sender, channel, query).search(); // Searches Wiki for query with new LookupDispatcher instance
    }

}
