public class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name; //присваиваем значение, которые передали в аргументе name
        this.age =age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString() {
        return name + " " + age;
    }
}
