package doo.factory;

public class CSVReportFactory extends ReportFactory{
    @Override
    protected ReportFormatter createFormatter() {
        return new CSVReportFormatter();
    }
}
