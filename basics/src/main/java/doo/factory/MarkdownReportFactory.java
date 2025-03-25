package doo.factory;

public class MarkdownReportFactory extends ReportFactory{
    @Override
    protected ReportFormatter createFormatter() {
        return new MarkdownReportFormatter();
    }
}
