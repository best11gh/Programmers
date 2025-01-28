import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Person[] arr = new Person[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Person(age, name);
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i].toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

}
