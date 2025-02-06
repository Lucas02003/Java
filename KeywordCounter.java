import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class KeywordCounter {
    private static final Set<String> KEYWORDS = new HashSet<>();

    static {
        // Add Java keywords to the set
        String[] keywordsArray = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", 
            "class", "const", "continue", "default", "do", "double", "else", "enum", 
            "extends", "final", "finally", "float", "for", "goto", "if", "implements", 
            "import", "instanceof", "int", "interface", "long", "native", "new", "null", 
            "package", "private", "protected", "public", "return", "short", "static", 
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", 
            "transient", "try", "void", "volatile", "while"
        };
        for (String keyword : keywordsArray) {
            KEYWORDS.add(keyword);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java KeywordCounter <JavaFileName>");
            return;
        }

        String fileName = args[0];
        int keywordCount = countKeywords(fileName);
        System.out.println("Total keywords: " + keywordCount);
    }

    private static int countKeywords(String fileName) {
        int count = 0;
        boolean inComment = false;
        boolean inString = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);

                    // Check for string literals
                    if (currentChar == '"') {
                        inString = !inString; // Toggle inString state
                    }

                    // Check for comments
                    if (!inString && currentChar == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        break; // Ignore the rest of the line
                    }
                    if (!inString && currentChar == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                        inComment = true; // Start of block comment
                    }
                    if (inComment && currentChar == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        inComment = false; // End of block comment
                        i++; // Skip the next character
                        continue;
                    }

                    // Count keywords if not in comment or string
                    if (!inComment && !inString && Character.isJavaIdentifierStart(currentChar)) {
                        StringBuilder keywordBuilder = new StringBuilder();
                        while (i < line.length() && Character.isJavaIdentifierPart(line.charAt(i))) {
                            keywordBuilder.append(line.charAt(i));
                            i++;
                        }
                        String keyword = keywordBuilder.toString();
                        if (KEYWORDS.contains(keyword)) {
                            count++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

