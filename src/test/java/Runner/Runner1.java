package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        tags = {"@test8"},
        glue = {"Steps"},
        plugin = { "pretty", "json:target/cucumber-report/cucumber-report.json" },
        monochrome = true
)

public class Runner1 {

    @AfterClass
    public static void teardown() throws IOException {
        String path = "target/cucumber-report/cucumber-report.json";
        File manipulateFile = new File(path);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String RunnerDate = dtf.format(now);
        String path1 = "target/cucumber-report/cucumber-report-" + RunnerDate + ".json";
        File manipulateFile1 = new File(path1);
        if (manipulateFile1.exists())
            throw new java.io.IOException("file exists");

        boolean success = manipulateFile.renameTo(manipulateFile1);

        if (!success) {
            System.out.println("Failed renamed");
        }

    }


}
