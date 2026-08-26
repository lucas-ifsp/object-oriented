package practical;

public class UserAccount {
    private String email;
    private String username;

    private final UserAccount[] followers;
    private final Post[] timeline;
    private final Post[] posts;

    private int qtdFollowers;
    private int qtdTimeline;
    private int qtdPosts;


    public UserAccount(String username, String email) {
        this.username = username;
        this.email = email;
        followers = new UserAccount[100];
        timeline = new Post[10];
        posts = new Post[100];
    }

    public void publish(String quote) {
        if (quote == null || quote.isBlank()) return;

        final Post post = new Post(this, quote);
        posts[qtdPosts++] = post;

        for (int i = 0; i < qtdFollowers; i++) {
            followers[i].updateTimeline(post);
        }
    }

    private void updateTimeline(Post post) {
        timeline[qtdTimeline % 10] = post;
        qtdTimeline++;
    }

    public boolean deletePost(int index) {
        final int last = qtdPosts - 1;

        if (index < 0 || index > last)
            return false;

        for (int i = index; i < last; i++) {
            posts[i] = posts[i + 1];
        }
        posts[last] = null;
        qtdPosts--;
        return true;
    }

    public void clapPost(int index) {
        if (index < 0 || index >= Math.min(qtdTimeline, 10))
            return;

        timeline[index].clap();
    }

    public void booPost(int index) {
        if (index < 0 || index >= Math.min(qtdTimeline, 10))
            return;

        timeline[index].boo();
    }

    public void acceptFollower(UserAccount user) {
        final int userIndex = getUserIndex(user);
        if(userIndex >= 0) return;
        followers[qtdFollowers++] = user;
    }

    public void blockFollower(UserAccount user) {
        final int userIndex = getUserIndex(user);
        if(userIndex < 0) return;

        for (int j = userIndex; j < qtdFollowers - 1; j++) {
            followers[j] = followers[j + 1];
        }
        followers[qtdFollowers - 1] = null;
        qtdFollowers--;
    }

    private int getUserIndex(UserAccount user) {
        for (int i = 0; i < qtdFollowers; i++) {
            UserAccount follower = followers[i];
            if (isSameUser(user, follower))
                return i;
        }
        return -1;
    }

    private boolean isSameUser(UserAccount user, UserAccount follower) {
        return follower.username.equals(user.username) && follower.email.equals(user.email);
    }

    public String getFollowersAsString(){
        StringBuilder builder = new StringBuilder("Followers: \n");
        for (int i = 0; i < qtdFollowers; i++) {
            UserAccount follower = followers[i];
            String state = String.format("Username: %s | E-mail %s", follower.username, follower.email);
            builder.append(state).append("\n");
        }
        return builder.toString();
    }

    public String getPostsAsString(){
        StringBuilder builder = new StringBuilder("My Posts: \n");
        for (int i = 0; i < qtdPosts; i++) {
            builder.append(posts[i].getStateAsString()).append("\n");
        }
        return builder.toString();
    }

    public String getTimelineAsString(){
        StringBuilder builder = new StringBuilder("Timeline: \n");
        for (int i = 0; i < Math.min(qtdTimeline, 10); i++) {
            builder.append(timeline[i].getStateAsString()).append("\n");
        }
        return builder.toString();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
