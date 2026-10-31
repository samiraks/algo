public class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // ОБЯЗАТЕЛЬНО: без этого будет выводиться Student@27bc2616
    @Override
    public String toString() {
        return name + " " + age;
    }
}