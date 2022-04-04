import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import freemarker.log.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener extends Report implements ITestListener {
    private static Logger log = Logger.getLogger("TestNGListener");
    ExtentReports extent=ReportGenerator();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        log.info("Start of Test "+result.getName());
        test=extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        log.info("Success of test "+result.getName());
        test.log(Status.PASS,"Successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        log.error("Fail of Test"+result.getName());
        test.log(Status.FAIL,result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        log.info("Finish of test"+context.getName());
        extent.flush();
    }
}
