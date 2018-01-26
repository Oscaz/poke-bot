package ninja.oscaz.pokebot;

import java.util.function.BiConsumer;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public enum SearchResult {

    SUCCESS(LookupCompletions::success), // Uses LookupCompletions#success
    FAILED_NO_DESCRIPTION(LookupCompletions::failedNoDescription), // Uses LookupCompletions#failedNoDescription
    FAILED_NO_RESULT(LookupCompletions::failedNoResult); // Uses LookupCompletions#failedNoResult

    // Consumer of user and result to send user messages of the result
    private final BiConsumer<UserChannel, LookupResult> completer;

    SearchResult(BiConsumer<UserChannel, LookupResult> completer) {
        this.completer = completer;
    }

    // Pass user and result to enum value's completer
    public void complete(User sender, TextChannel channel, LookupResult result) {
        this.completer.accept(new UserChannel(sender, channel), result);
    }

}
