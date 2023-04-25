package com.kenzie.executingtests.writingcases;


import com.kenzie.executingtests.ATATestHelpers.ATAFileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kenzie.test.infrastructure.assertions.PlantUmlClassDiagramAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class WritingCasesTest {
    private static final String FILENAME = "shopping_cart_test_cases.md";
    private static final String WRITING_PACKAGE = "com.kenzie.executingtests.writingcases";
    private static final String CLASS_DIAGRAM_PATH = "src/main/java/com/kenzie/executingtests/shoppingcart";
    private static final String TEST_CASE_PATH = "../..";

    @Test
    void does_test_case_file_exist() {
        // GIVEN - path to directory that .md file should exist in
        List<String> filesWithPumlExtension = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(filesWithPumlExtension != null && filesWithPumlExtension.size() > 0)  {
            countOfFilesWithExtensionInDirectory = true;
        }
        // THEN - test case file found
        assertTrue(countOfFilesWithExtensionInDirectory, "Failed: Could not find " + FILENAME + " file in project folder");
    }


    @Test
    void addItem_withEmptyItemName_isRejected_brackets_replaced() {
        // GIVEN - path to directory that .md file should exist in
        List<String> testCaseFiles = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(testCaseFiles != null && testCaseFiles.size() > 0)  {
            // WHEN
            String content = getFileContentFromResources(testCaseFiles.get(0));

            // THEN - check for bracketed values
            assertFalse(content.contains("[What given is needed]"), "Failed: Bracketed section in GIVEN clause needs to be replaced inside " + FILENAME);
            assertFalse(content.contains("[What other given is needed?]"), "Failed: Bracketed section in GIVEN clause needs to be replaced inside " + FILENAME);
        }
        else{
            fail("Could not find test cases file: " + FILENAME);
        }
    }

    @Test
    void addItem_withNegativeQuantity_isRejected_brackets_replaced() {
        // GIVEN - path to directory that .md file should exist in
        List<String> testCaseFiles = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(testCaseFiles != null && testCaseFiles.size() > 0)  {
            // WHEN
            String content = getFileContentFromResources(testCaseFiles.get(0));

            // THEN - check for bracketed values
            assertFalse(content.contains("[What happens in this situation?]"), "Failed: Bracketed section in THEN clause needs to be replaced inside " + FILENAME);
            assertFalse(content.contains("[Take a look above if necessary]"), "Failed: Bracketed section in THEN clause needs to be replaced inside " + FILENAME);
        }
        else{
            fail("Could not find test cases file: " + FILENAME);
        }
    }

    @Test
    void addItem_withZeroQuantity_isRejected_brackets_replaced() {
        // GIVEN - path to directory that .md file should exist in
        List<String> testCaseFiles = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(testCaseFiles != null && testCaseFiles.size() > 0)  {
            // WHEN
            String content = getFileContentFromResources(testCaseFiles.get(0));

            // THEN - check for bracketed values
            assertFalse(content.contains("[Provide a given]"), "Failed: Bracketed section in GIVEN clause needs to be replaced inside " + FILENAME);
            assertFalse(content.contains("[What is returned?]"), "Failed: Bracketed section in THEN clause needs to be replaced inside " + FILENAME);
            assertFalse(content.contains("[What is the ShoppingCart's status? Has anything changed?]"), "Failed: Bracketed section in THEN clause needs to be replaced inside " + FILENAME);
        }
        else{
            fail("Could not find test cases file: " + FILENAME);
        }
    }


    @Test
    void updateQuantity_withNullItemName_isRejected_brackets_replaced() {
        // GIVEN - path to directory that .md file should exist in
        List<String> testCaseFiles = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(testCaseFiles != null && testCaseFiles.size() > 0)  {
            // WHEN
            String content = getFileContentFromResources(testCaseFiles.get(0));

            // THEN - check for bracketed values
            assertFalse(content.contains("[What else should be given?]"), "Failed: Bracketed section in GIVEN clause needs to be replaced inside " + FILENAME);
        }
        else{
            fail("Could not find test cases file: " + FILENAME);
        }
    }

    @Test
    void updateQuantity_withEmptyItemName_isRejected_brackets_replaced() {
        // GIVEN - path to directory that .md file should exist in
        List<String> testCaseFiles = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(testCaseFiles != null && testCaseFiles.size() > 0)  {
            // WHEN
            String content = getFileContentFromResources(testCaseFiles.get(0));

            // THEN - check for bracketed values
            assertFalse(content.contains("[What else is given?]"), "Failed: Bracketed section in GIVEN clause needs to be replaced in test case " + FILENAME);
            assertFalse(content.contains("[test1: does or does not?]"), "Failed: Bracketed section in THEN clause needs to be replaced inside " + FILENAME);

        }
        else{
            fail("Could not find test cases file: " + FILENAME);
        }
    }

    @Test
    void updateQuantity_onItemNotInCart_isRejected_brackets_replaced() {
        // GIVEN - path to directory that .md file should exist in
        List<String> testCaseFiles = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(testCaseFiles != null && testCaseFiles.size() > 0)  {
            // WHEN
            String content = getFileContentFromResources(testCaseFiles.get(0));

            // THEN - check for bracketed values
            assertFalse(content.contains("[test2: does or does not?]"), "Failed: Bracketed section in THEN clause needs to be replaced inside " + FILENAME);

        }
        else{
            fail("Could not find test cases file: " + FILENAME);
        }
    }

    @Test
    void updateQuantity_withNegativeQuantity_isRejected_brackets_replaced() {
        // GIVEN - path to directory that .md file should exist in
        List<String> testCaseFiles = fileExistingInPathByName(TEST_CASE_PATH, FILENAME);

        boolean countOfFilesWithExtensionInDirectory = false;

        if(testCaseFiles != null && testCaseFiles.size() > 0)  {
            // WHEN
            String content = getFileContentFromResources(testCaseFiles.get(0));

            // THEN - check for bracketed values
            assertFalse(content.contains("[What else is given based on the test name?]"), "Failed: Bracketed section in THEN clause needs to be replaced inside " + FILENAME);
        }
        else{
            fail("Could not find test cases file: " + FILENAME);
        }
    }


    private static String getFileContentFromResources(String filename) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            ATAFileReader fileReader = new ATAFileReader(filename);
            fileReader.readLines().forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Unable to find file: %s.", filename), e);
        }

        return contentBuilder.toString();
    }

    private static List<String> filesExistingInPathByExtension(String pathToSearch, String fileExtension) {

        Path path = Paths.get(pathToSearch);

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result = null;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static List<String> fileExistingInPathByName(String pathToSearch, String fileName) {

        Path path = Paths.get(pathToSearch);

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result = null;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.contains(fileName))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}