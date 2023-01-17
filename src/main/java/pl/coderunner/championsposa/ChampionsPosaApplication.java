package pl.coderunner.championsposa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;
import java.util.TimeZone;


@SpringBootApplication
public class ChampionsPosaApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("UTC+1")));
        SpringApplication.run(ChampionsPosaApplication.class, args);
    }



}
