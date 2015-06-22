package org.anderes.edu.regex.exercise;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Diese Test's beziehen sich auf die entsprechenden Unterlagen
 * 
 * @author René Anderes
 *
 */
public class ExerciseTest {
    
    @Test
    public void exercise_1() {
        
        Pattern pattern = Pattern.compile("\\b[A-Z]\\w+[A-Z]\\b");
        Matcher matcher = pattern.matcher(readFile("exercise_1.txt"));

        int counter = dumpResult(matcher);
        assertThat(counter, is(10));
    }

    @Test
    public void exercise_2() {
        
        String regEx = "^ISBN\\x20(978|979)([-]|\\x20)\\d{1,5}([-]|\\x20)\\d{5,7}([-]|\\x20)\\d{3}([-]|\\x20)\\d$";
        
        Collection<String> txt = readLines("exercise_2.txt");
        for (String value : txt) {
            assertThat("Fehler: " + value, value.matches(regEx), is(true));
            System.out.println(value);
        }
    }
    
    @Test
    public void exercise_3() {
        
        Pattern pattern = Pattern.compile("<[h|H][r|R] ?((size|SIZE)? ?= ?\"[0-9]+\" ?)?>");
        Matcher matcher = pattern.matcher(readFile("exercise_3.txt"));

        int counter = dumpResult(matcher);
        assertThat(counter, is(4));
    }
    
    
    
    private int dumpResult(Matcher matcher) {
        int counter = 0;
        System.out.println("Gefunden:");
        while (matcher.find()) {
            counter++;
            System.out.println(matcher.group());
        }
        return counter;
    }
    
    private Collection<String> readLines(final String txtFile) {
        try (Stream<String> lines = Files.lines(getFile(txtFile), StandardCharsets.UTF_8)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e1) {
            throw new IllegalArgumentException("Unbekante Filebezeichnung");
        } 
    }
    
    private String readFile(final String txtFile) {
        try (Stream<String> lines = Files.lines(getFile(txtFile), StandardCharsets.UTF_8)) {
            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e1) {
            throw new IllegalArgumentException("Unbekante Filebezeichnung");
        } 
    }
    
    private Path getFile(final String txtFile) throws URISyntaxException {
        URL url = this.getClass().getResource(txtFile);
        assertThat(String.format("Das File '%s' existiert nicht.", txtFile), url, is(not(nullValue())));
        return Paths.get(url.toURI());
    }
}
