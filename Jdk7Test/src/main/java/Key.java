public class Key {
    private int value;

    public Key(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value%2;
    }
}
