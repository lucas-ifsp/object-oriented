package practical;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import static practical.Course.Room.C102;
import static practical.Course.Room.C106;

public class Main {
    public static void main(String[] args) {
        final Student student = new Student("SC444444X", "Sabrina", LocalDate.now().minusDays(1));
        System.out.println(student.getStateAsString());

        final Course poo = new Course("POO", THURSDAY, "Programação Orientada a Objeto", "Pablitto", LocalTime.of(19, 0), LocalTime.of(22, 40), C106);
        final Course bd = new Course("BD1", MONDAY, "Banco de Dados I", "Fabitos", LocalTime.of(19, 0), LocalTime.of(22, 40), C102);
        final Course vvt = new Course("VVT", MONDAY, "Verificação, Validação e Testes", "Lucas", LocalTime.of(19, 0), LocalTime.of(22, 40), C106);

        final Enrollment enrollment = new Enrollment(student);

        System.out.println("Matrícula não concluída");
        System.out.println(enrollment.getStateAsString());

        enrollment.enroll(poo);
        enrollment.enroll(bd);
        enrollment.conclude();

        System.out.println("Matriculada em duas matérias sem conflito");
        System.out.println(enrollment.getStateAsString());

        final Student student2 = new Student("SC444441X", "Bocutão", LocalDate.now().minusMonths(12));
        System.out.println("Semester = " + student2.getSemester());

        System.out.println("Matriculada em três matérias com conflito");
        final Enrollment enrollment2 = new Enrollment(student2);
        System.out.println(enrollment2.enroll(poo)? "Matriculado" : "Erro");
        System.out.println(enrollment2.enroll(vvt)? "Matriculado" : "Erro");
        System.out.println(enrollment2.enroll(bd)? "Matriculado" : "Erro");

        System.out.println("Matriculada após remoção de conflito");
        enrollment2.remove(vvt);
        System.out.println(enrollment2.enroll(bd)? "Matriculado" : "Erro");
        enrollment2.conclude();

        System.out.println("Matrículas após conclusão sem conflito");
        System.out.println(enrollment2);


    }
}
