package com.far.apps;

import com.far.apps.service.TondeuseService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.main.QuarkusMainTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Paths;

@QuarkusTest
public class TondeuseServiceTest {

    @Inject
    TondeuseService tondeuseService;

    @Test
    public void testLancerTondeuses() throws IOException {
        String rep = tondeuseService.lancerTondeuses(Paths.get("src", "test", "resources", "instructions.txt"));
        Assertions.assertEquals("1 3 N 5 1 E", rep);
    }
}
