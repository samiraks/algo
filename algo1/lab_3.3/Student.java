public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    @Override
    public int compareTo(Student other) {
        // Сначала сравниваем по имени, если имена разные
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        // Если имена одинаковые, сравниваем по возрасту
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
