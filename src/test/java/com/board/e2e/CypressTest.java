package com.board.e2e;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.OutputFrame;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class CypressTest {
    @LocalServerPort
    private int port;

    private static final int MAX_TOTAL_TEST_TIME_IN_MINUTES = 5;

    @Test
    void runCypressTest() throws InterruptedException {
        Testcontainers.exposeHostPorts(port);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        try (GenericContainer container = createCypressContainer()){
            container.start();
            container.followOutput(new Consumer<OutputFrame>() {

                @Override
                public void accept(OutputFrame outputFrame) {
                    log.debug(outputFrame.getUtf8String());

                    if(outputFrame.getUtf8String().contains("Run Finished")) {
                        countDownLatch.countDown();
                    }

                }
            });

            countDownLatch.await(MAX_TOTAL_TEST_TIME_IN_MINUTES, TimeUnit.MINUTES);
            Thread.sleep(2000);

        }


    }


    private GenericContainer createCypressContainer() {
        GenericContainer result = new GenericContainer("cypress/included:3.3.1");
        result.withClasspathResourceMapping("e2e", "/e2e", BindMode.READ_WRITE);
        result.setWorkingDirectory("/e2e");
        result.addEnv("CYPRESS_baseUrl", "http://localhost" + port);

        return result;
    }


}
