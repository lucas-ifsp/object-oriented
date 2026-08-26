import class06.sample.Circle;
import class06.sample.Figure;
import class06.sample.Rectangle;

void main() {
    Figure[] figures = new Figure[100];

    for (int i = 0; i < 50; i++) {
        figures[i] = new Circle(i + 1, i+1, i+1);
        figures[i+50] = new Rectangle(i + 1, i + 1, i + 1, i + 1);
    }


    double total = 0.0;
    for (Figure figure : figures) {
        total += figure.area();
    }
    System.out.println(total);
}
