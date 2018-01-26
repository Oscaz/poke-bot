package ninja.oscaz.pokebot;

final class LookupCompletions {

    static void success(UserChannel userChannel, LookupResult result) { // Successful lookup
        userChannel.channel.sendMessage(
                result.getPageName() + ":\n" +
                "```" + result.getDescription() + "```\n" +
                result.getPageURL()
        ).queue();
    }

    static void failedNoDescription(UserChannel userChannel, LookupResult result) { // Found page on Wiki, but no description available
        userChannel.channel.sendMessage(
                "```css\n" +
                        "Failure```\n" +
                        result.getPageName() + ":\n" +
                        "```No description found!" + "```\n"
        ).queue();
    }

    static void failedNoResult(UserChannel userChannel, LookupResult result) { // No results found whatsoever
        userChannel.channel.sendMessage(
                "```css\n" +
                        "Failure```\n" +
                        "No page found!"
        ).queue();
    }

    private LookupCompletions() { // Utility classes are statically bound, cannot be instantiated.
        throw new IllegalStateException("Cannot be instantiated.");
    }

}
