package com.lwq.precious.p11_文档导入;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestCSV {

    public List<User> readUsersFromCsv() throws IOException, CsvValidationException {

        Path path = Paths.get("C:\\Users\\wenqiang.li1\\Desktop\\目标融合数据\\信源数据\\hehe.csv");

        CSVReader reader = new CSVReader(Files.newBufferedReader(path));
        List<User> users = new ArrayList<>();

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            User user = new User();
            user.setName(nextLine[0]);
            user.setEmail(nextLine[1]);
            users.add(user);
        }

        reader.close();
        return users;
    }

    @Test
    public void name1() {
        try {
            List<User> userList = readUsersFromCsv();
            System.out.println(userList.size());
        } catch (CsvValidationException | IOException e) {

            e.printStackTrace();
        }
    }

}
