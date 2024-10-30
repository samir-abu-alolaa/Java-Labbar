package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class d {
    
    private final String folderName = "data";
    private String currentPath;
    private String folderPath;

    @Test
    public void setUp() {
        // Use File.separator for platform independence
        String currentPath = System.getProperty("user.dir");
        folderPath = currentPath + File.separator + "src" + File.separator + 
                     "main" + File.separator + "resources" + File.separator + folderName;

        System.out.println(folderPath);
    }
}
