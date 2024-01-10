import java.time.LocalDate;

void main() {
    LocalDate date = LocalDate.now();

    switch (date.getDayOfWeek()) {
        case MONDAY -> System.out.println("Segunda-feira. =´(");
        case TUESDAY -> System.out.println("Terça-feira. =(");
        case WEDNESDAY -> System.out.println("Quarta-feira. =|");
        case THURSDAY -> System.out.println("Quinta-feira. =)");
        case FRIDAY -> System.out.println("Sexta-feira! =D");
        case SATURDAY -> System.out.println("Sábado! \\o/");
        case SUNDAY -> System.out.println("Domingo. <o/");
    }

    final String dayAsString = switch (date.getDayOfWeek()) {
        case MONDAY -> "Segunda-feira. =´(";
        case TUESDAY -> "Terça-feira. =(";
        case WEDNESDAY -> "Quarta-feira. =|";
        case THURSDAY -> "Quinta-feira. =";
        case FRIDAY -> "Sexta-feira! =D";
        case SATURDAY -> "Sábado! \\o/";
        case SUNDAY -> "Domingo. <o/";
    };
    System.out.println(dayAsString);

    int numLetters = 0;
    switch (date.getDayOfWeek()) {
        case MONDAY: case FRIDAY: case SUNDAY:
            numLetters = 6;
            break;
        case TUESDAY:
            numLetters = 7;
            break;
        case THURSDAY:
            numLetters = 8;
            break;
        case WEDNESDAY:
            numLetters = 9;
            break;
    }
    System.out.println(numLetters);

    System.out.println(switch (date.getDayOfWeek()) {
        case MONDAY, FRIDAY, SUNDAY -> 6;
        case TUESDAY -> 7;
        case THURSDAY -> 8;
        case WEDNESDAY -> 9;
        default -> 0;
    });
}