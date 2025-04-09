import java.util.*;
import java.io.*;

class Path {
    
    public static HashMap<Character, ArrayList<Character>> map;
    
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.print("No file entered");
            System.exit(0);
        }

        String[][]  cases = readFile(args[0]);

        System.out.println("Nodes:  Shortest Path");
        for(int i = 0; i < cases[0].length; i++) {
            map = create(cases[0][i]);
            int result = search(Character.valueOf(cases[1][i].charAt(0)), Character.valueOf(cases[1][i].charAt(1)));
            
            if(result == -1) {
                System.out.println(cases[1][i].charAt(0) + " and " + cases[1][i].charAt(1) + ": " + "No Path");
            } else {
                System.out.println(cases[1][i].charAt(0) + " and " + cases[1][i].charAt(1) + ": " + result);
            }
        }
        
    }

    public static String[][] readFile(String fileName) {
        String cases[][];
        try {
            Scanner input = new Scanner(new FileReader(fileName));
            int caseNum = Integer.valueOf(input.nextLine());
            cases = new String[2][caseNum];

            for(int i = 0; i < caseNum; i++) {
                cases[0][i] = input.nextLine();
                cases[1][i] = input.nextLine();
            }

            input.close();
        } catch(Exception e) {
            System.out.println("Invalid File");
            System.exit(0);
            return new String[0][0];
        }

        return cases;
    }

    public static HashMap<Character, ArrayList<Character>> create(String statement) {
        HashMap<Character, ArrayList<Character>>  map = new HashMap<Character, ArrayList<Character>>();
        for(int i = 0; i < statement.length(); i++) {
            if(!map.containsKey(statement.charAt(i)) && Character.isLetter(statement.charAt(i))) {
                map.put(statement.charAt(i), new ArrayList<Character>());
            } 
        }
        
        String[] adjPairs = statement.split(" ");
        for(String x: adjPairs) {
            map.get(x.charAt(0)).add(x.charAt(1));
            map.get(x.charAt(1)).add(x.charAt(0));
        }
        
        return map;
    }

    public static int search(Character start, Character goal) {
        if (start == null) return -1;

        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        int counter = 0;
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Character current = queue.poll();
                if (current.equals(goal)) {
                    return counter;
                }
                
                ArrayList<Character> neighbors = map.getOrDefault(current, new ArrayList<>());
                for (Character neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            counter++;
        }
        return -1;
    }

}
