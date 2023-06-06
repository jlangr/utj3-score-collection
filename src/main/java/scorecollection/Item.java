package scorecollection;

public record Item(int score, String description) implements Scoreable {
}
