package trainee.david.other.H14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trainee.david.other.H7.Person;
import trainee.david.other.H7.PersonDiedException;

import java.util.*;

public class Main {

    private static Map<String, Integer> uniqueResults;

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws PersonDiedException {
        uniqueResults = new HashMap<>();
        Person david = new Person("David", 24);
        Person david2 = new Person("David", 24);
        Person alice = new Person("Alice", 25);
        Person bob = new Person("Bob", 26);

        Set<Person> people = new TreeSet<>();
        people.add(david);
        people.add(david2);
        people.add(alice);
        people.add(bob);

        for (Person p : people) {
            System.out.println(p);
        }

        Map<Integer, String> alphabet = new TreeMap<>();
        alphabet.put(3, "C");
        alphabet.put(1, "A");
        alphabet.put(2, "B");
        System.out.println(alphabet);

        System.out.println(concordance("Hello World"));
    }

    public static int uniqueChars(String input) {
        if (uniqueResults.containsKey(input)) return uniqueResults.get(input);

        Map<Character, Integer> characters = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (characters.containsKey(c)) {
                characters.put(c, characters.get(c) + 1);
                continue;
            }
            characters.put(c, 1);
        }
        int uniques = 0;
        for (int chars : characters.values()) {
            if (chars == 1) uniques++;
        }
        uniqueResults.put(input, uniques);
        return uniques;
    }

    private static Map<Character, List<Integer>> concordance(String input) {
        Map<Character, List<Integer>> result = new HashMap<>();
        log.info("Reading input...");

        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            if (currentChar == ' ') continue;

            if (result.containsKey(currentChar)) {
                result.get(currentChar).add(index);
            } else {
                log.debug("Encountered new letter: " + currentChar);
                List<Integer> newIndexList = new ArrayList<>();
                newIndexList.add(index);
                result.put(currentChar, newIndexList);
            }
        }
        return result;
    }

}
