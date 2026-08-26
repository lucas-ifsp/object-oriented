package practical;

public class Principal {
    static void main() {
        final UserAccount capitao = new UserAccount("Capitão", "cap@vara.com");
        final UserAccount mary = new UserAccount("Mary", "mary@pet.org.br");
        final UserAccount caua = new UserAccount("Cauã", "caucau@pet.org.br");

        mary.acceptFollower(capitao);
        mary.publish("Palmeiras não tem mundial");

        System.out.println("--- Mary fez um post ---");
        System.out.println(mary.getPostsAsString());

        System.out.println("--- E Capitão está seguindo ---");
        System.out.println(capitao.getTimelineAsString());

        mary.acceptFollower(caua);
        mary.publish("Corinthia campeão da serie B");

        System.out.println(" --- Mary fez outro post --- ");
        System.out.println(mary.getPostsAsString());

        System.out.println("--- E Capitão está seguindo ---");
        System.out.println(capitao.getTimelineAsString());

        System.out.println("--- E Cauã também está  ---");
        caua.booPost(0);
        System.out.println(caua.getTimelineAsString());

        System.out.println("-- Mary tem muitos fans");
        System.out.println(mary.getFollowersAsString());

        mary.blockFollower(caua);

        System.out.println("--- Mary está empolgada ...");
        for (int i = 0; i < 10; i++) {
            mary.publish("Aposenta menino Ney " + (i+1));
            capitao.clapPost(i);
        }

        System.out.println("--- Capitão é um baita stalker");
        System.out.println(capitao.getTimelineAsString());

        System.out.println("--- Cauã forever alone ---");
        System.out.println(caua.getTimelineAsString());
    }
}
