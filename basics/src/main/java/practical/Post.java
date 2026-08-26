package practical;

import java.time.LocalDateTime;

public class Post {
    private final String quote;
    private final UserAccount user;
    private final LocalDateTime timestamp;
    private int claps;
    private int boos;

    public Post(UserAccount user, String quote) {
        this.user = user;
        this.quote = quote;
        this.timestamp = LocalDateTime.now();
    }

    public String getStateAsString() {
        return String.format("[%s] %s says \"%s\" | Claps: %d | Boos: %d",
                timestamp, user.getUsername(), quote, claps, boos);
    }

    public void clap() {
        claps++;
    }

    public void boo() {
        boos++;
    }
}
