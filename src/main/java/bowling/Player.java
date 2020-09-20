package bowling;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {

    private static final Pattern NAMING_PATTERN = Pattern.compile("^[a-zA-Z]{3}$");
    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        validate(name);
        return new Player(name);
    }

    private static void validate(String name) throws IllegalArgumentException {
        if (!NAMING_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("이름은 영문 3 글자만 허용 됩니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}