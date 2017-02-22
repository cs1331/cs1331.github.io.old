public interface Destiny {

    default public String getName() {
        return "Child";
    }

    default public String say() {
        return "my " + getName();
    }
}
