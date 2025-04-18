import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Person person = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            people[i] = person;
        }

        StringBuilder sb = new StringBuilder();

        for (Person person1 : people) {
            int rank = 1;
            for (Person person2 : people) {
                if (person2.compareTo(person1) > 0) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);


    }


    private static class Person implements Comparable<Person> {

        private final int weight;
        private final int height;

        private Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {
            if (this.weight > o.weight && this.height > o.height) {
                return 1;
            }

            return 0;
        }
    }
}
