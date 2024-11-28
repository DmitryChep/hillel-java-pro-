package ua.ithillel.javapro;

public record User (int id, String name, String email) {
    @Override
    public String toString() {
        return "\n[id: " + id +
                ", name: " + name +
                ", email: " +  email + "]";
    }
}
