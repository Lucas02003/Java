<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>

<%
    // Initialize variables
    Random random = new Random();
    int numberOfQuestions = 5;
    ArrayList<Integer> answers = new ArrayList<>();
    int score = 0;

    // Check if the form has been submitted
    if (request.getParameter("submit") != null) {
        // Calculate score based on user answers
        for (int i = 0; i < numberOfQuestions; i++) {
            int userAnswer = Integer.parseInt(request.getParameter("answer" + i));
            if (userAnswer == answers.get(i)) {
                score++;
            }
        }
        out.println("<h2>Your score: " + score + " out of " + numberOfQuestions + "</h2>");
    } else {
        // Generate random addition questions
        for (int i = 0; i < numberOfQuestions; i++) {
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10);
            answers.add(num1 + num2);
            out.println("<p>Question " + (i + 1) + ": " + num1 + " + " + num2 + " = <input type='text' name='answer" + i + "' /></p>");
        }
        out.println("<input type='submit' name='submit' value='Submit' />");
    }
%>