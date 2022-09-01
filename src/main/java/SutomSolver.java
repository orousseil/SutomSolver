import utils.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static utils.StringUtils.*;

public class SutomSolver {

    private String query;
    private String match;
    private String missplacedLetters;
    private String missingLetters;
    private int wordSize;
    private int numberOfProposals;

    private List<WordPoposal> proposals = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length == 0 || args.length > 2) {
            System.out.println("Usage   : SutomSolver <query> [number of proposals]");
            System.out.println("Example : SutomSolver U--N--E/AI^RT 20 => lettres A et I mal placées et R et T absents (mot à trouver USINAGE)");
        } else {
            SutomSolver app = new SutomSolver();
            app.query = args[0];
            app.match = substringBefore(app.query, '/');
            app.missplacedLetters = substringBefore(substringAfter(app.query, '/'), '^');
            app.missingLetters = substringAfter(substringAfter(app.query, '/'), '^');
            app.wordSize = app.match.length();
            app.numberOfProposals = (args.length == 2) ? Integer.parseInt(args[1]) : 30;
            app.run();
        }
    }

    public void run() {
        System.out.println("query=" + this.query);
        System.out.println("match=" + this.match);
        System.out.println("missplacedLetters=" + this.missplacedLetters);
        System.out.println("missingLetters=" + this.missingLetters);
        System.out.println("wordSize=" + this.wordSize);
        System.out.println("numberOfProposals=" + this.numberOfProposals);
        System.out.println();

        loadDictionary();
        displayProposalsOrderedByScore();
    }

    private void loadDictionary() {
        String regexp = "(?i)" + match.toUpperCase().replaceAll("\\-", ".");

        try (Stream<String> stream = Files.lines(Paths.get("french.dic"))) {
            stream.forEach(line -> {
                String word = unaccent(line).toUpperCase();
                if (!word.contains("'") && !word.contains("-") && word.matches(regexp)
                        && (missplacedLetters.length() == 0 || StringUtils.containsAllLetters(word, missplacedLetters))
                        && (missingLetters.length() == 0 || !StringUtils.containsAllLetters(word, missingLetters))) {
                    var wordPoposal = new WordPoposal(word);
                    computeScore(wordPoposal);
                    proposals.add(wordPoposal);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void computeScore(WordPoposal wordPoposal) {
        var letters = wordPoposal.getWord().chars()
                .mapToObj(i -> LetterFrequency.valueOf(String.valueOf((char) i)))
                .distinct()
                .collect(Collectors.toList());
        double factor = 1.0;
        double score = letters.stream().mapToDouble(letter -> letter.getFreq() * factor).sum();
        wordPoposal.setScore(score);
    }

    private void displayProposalsOrderedByScore() {
        var results = proposals.stream()
                .sorted(comparing(p -> p.getScore()))
                .collect(Collectors.toList());

        Collections.reverse(results);

        results.stream().limit(numberOfProposals).forEach(proposal -> {
            System.out.println(String.format("%s score %.3f", proposal.getWord(), proposal.getScore()));
        });
    }
}
